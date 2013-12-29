/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mau.command.impl;

import br.com.mau.command.ArduinoReceiver;
import br.com.mau.command.Command;
import br.com.mau.model.Ambiente;
import java.util.Enumeration;

/**
 *
 * @author Mauricio
 */
public class ReadDataCommand implements Command{

    private Ambiente ambiente = null;
    private ArduinoReceiver receiver = new ArduinoReceiver();
    
    @Override
    public void execute() {        
        this.ambiente = receiver.readData();
    }
    
}
