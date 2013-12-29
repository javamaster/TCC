/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mau.communication;

import br.com.mau.model.Ambiente;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 *
 * @author Mauricio
 */
public class BluetoothCommunicator implements Communicator, SerialPortEventListener{
    
    private Ambiente a = new Ambiente();
    private SerialPort serialPort;
    private static final String PORT_NAMES[] = {
                        "/dev/tty.usbserial-A9007UX1", // Mac OS X
            "/dev/ttyUSB0", // Linux
            "COM4", "COM7",// Windows   
            "/dev/rfcomm0" // Ubuntu Bluetooth
    };
    private BufferedReader reader;
    private static InputStream input;
    private static OutputStream output;
    private static final int TIME_OUT = 2000;   
    private static final int DATA_RATE = 9600;
    
    

    @Override
    public void initialize() {
        Enumeration portIdentifers = getAvailablePorts();
        
        CommPortIdentifier port = null;
        String portName = "";
        
        while (portIdentifers.hasMoreElements()) {            
            CommPortIdentifier currentPortId = (CommPortIdentifier) portIdentifers.nextElement();
            for (String name : PORT_NAMES) {
                if(currentPortId.getName().equals(name)){
                    port = currentPortId;
                    portName = name;
                    break;
                }
            }
        }        
        
        if (port != null) {
            connect(port);
            System.out.println("Sistema rodando na porta: "+port.getName());
        }
       

    }

    @Override
    public boolean connect(CommPortIdentifier objectPort) {
        try {
            //CommPortIdentifier port = (CommPortIdentifier) objectPort;
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) objectPort.open(this.getClass().getName(),
                    TIME_OUT);
            
            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

        
            // open the streams
            input = serialPort.getInputStream();
            reader = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);            
            
            return true;
            
        } catch (PortInUseException | UnsupportedCommOperationException | IOException | TooManyListenersException e) {
            e.printStackTrace();
            System.out.println("Error: "+e.getMessage());
        }
        return false;
    }

    @Override
    public void close() {
       if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    @Override
    public Enumeration getAvailablePorts() {
        return CommPortIdentifier.getPortIdentifiers();
    }

    @Override
    public synchronized void write(int cmd) {
        if(output != null){
            try {                                
                output.write(cmd);
                output.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(BluetoothCommunicator.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{
                System.out.println("Não foi possível enviar o comando");
            }
    }
    
    public static synchronized void escreve(int cmd){
        if(output != null){
            try {                                
                output.write(cmd);
                output.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(BluetoothCommunicator.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{
                System.out.println("Não foi possível enviar o comando");
            }
    }
    
    public Ambiente readAmbiente(){
        return a;
    }

    public synchronized void serialEvent(SerialPortEvent spe) {
        if(spe.getEventType() == SerialPortEvent.DATA_AVAILABLE){
            try {
                
//                int available = input.available();//                                
//				byte chunk[] = new byte[available];//                                
//				input.read(chunk, 0, available);//
//                                String inputLine = new String(chunk);                                
//                
//                                System.out.println(inputLine.toUpperCase());
                
                String inputLine = reader.readLine();
                
                System.out.println(inputLine);
                //trataResposta(inputLine);
            } catch (IOException ex) {
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                }
            }
        }
    }

    private void trataResposta(String inputLine) {
        switch (inputLine) {
            case "l":
                System.out.println("Systema está ligado");
                break;
            case "d":
                System.out.println("Systema está desligado");
                break;
            case "r":
                System.out.println("Systema retorna os dados do ambiente");
                break;
        }
    }
    
    
    public static void main(String[] args) {
        
        BluetoothCommunicator comm = new BluetoothCommunicator();
        comm.initialize();  
        
        Thread t = new Thread(){

            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    escreve(1);
                } catch (InterruptedException ex) {                   
                }                            
            }     
           };
        t.start();
        System.out.println("Start");
//        comm.write(1);
    }
//    
}
