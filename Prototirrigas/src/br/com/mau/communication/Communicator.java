/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mau.communication;

import gnu.io.CommPortIdentifier;
import java.util.Enumeration;

/**
 *
 * @author Mauricio
 */
public interface Communicator {
    
    
    public void initialize();
    
    public boolean connect(CommPortIdentifier port);
    
    public void close();
    
    public void write(int cmd);
          
    public Enumeration getAvailablePorts();
}
