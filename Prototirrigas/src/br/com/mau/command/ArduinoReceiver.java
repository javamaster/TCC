package br.com.mau.command;
import br.com.mau.communication.BluetoothCommunicator;
import br.com.mau.model.Ambiente;

/**
 *
 * @author Mauricio
 */
public class ArduinoReceiver {
    
    private boolean statusSystem = false;
    private BluetoothCommunicator communicator;
    public static final int ON = 1, OFF = 0, READ = 2;

    public ArduinoReceiver() {
        communicator = new BluetoothCommunicator();
        communicator.initialize();
    }
    
    
    public boolean startSystem(){
        if(statusSystem == false){
            communicator.write(ArduinoReceiver.ON);
            System.out.println("Comando enviado: "+ArduinoReceiver.ON);
            return true;
        }
        return false;
    }
    
    public boolean stopSystem(){
        if(statusSystem){
            communicator.write(ArduinoReceiver.OFF);
            communicator.close();
            return true;
        }
            
        return false;
    }
    
    public Ambiente readData(){
        if(statusSystem){
           communicator.write(ArduinoReceiver.READ);
           Ambiente a = communicator.readAmbiente();
           return a;
        }
        return null;
    }
    
}
