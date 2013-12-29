/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mau.communication;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 *
 * @author Mauricio
 */
public class SerialCommunicator implements SerialPortEventListener {

    
    private SerialPort serialPort;
    
    private static final String PORT_NAMES[] = {
        "COM3" // Windows
    };
    
    private BufferedReader input;
    private OutputStream output;
    
    private static final int TIME_OUT = 2000;
    
    private static final int DATA_RATE = 9600;
    
    public void initialize(){
        CommPortIdentifier portId = null;
        
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        
        while(portEnum.hasMoreElements()){
            CommPortIdentifier commPortCur = (CommPortIdentifier) portEnum.nextElement();
            
            for (String portName : PORT_NAMES) {
                if(commPortCur.getName().equals(portName)){
                    portId = commPortCur;
                    break;
                }
            }
            
            
        }
        if(portId == null){
                System.out.println("Could not find COM Port");
                return;
            }
            
            try {
                //Abre a conexão com a porta
                serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
                
                //Configura os parametros de comunicação
                serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                
                //Abrir os Streams
                input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
                output = serialPort.getOutputStream();
                
                //Add Event Listeners
                serialPort.addEventListener(this);
                serialPort.notifyOnDataAvailable(true);
                
        } catch (Exception e) {
            System.err.print(e.toString());            
        }
            
    }
    
    
    @Override
    public void serialEvent(SerialPortEvent spe) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
