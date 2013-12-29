/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mau.command.impl;

import br.com.mau.command.ArduinoReceiver;
import br.com.mau.command.Command;

/**
 *
 * @author Mauricio
 */
public class StartSystemCommand implements Command{

    private ArduinoReceiver receiver ;

    public StartSystemCommand() {
        receiver = new ArduinoReceiver();
    }
    
    @Override
    public void execute() {
        receiver.startSystem();
    }
    
}
