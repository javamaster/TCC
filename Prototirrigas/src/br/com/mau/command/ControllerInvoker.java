/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mau.command;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public class ControllerInvoker {
    
    List<Command> commands = new ArrayList<Command>();
    
    public void storeAndExecuteCommand(Command cmd){
        commands.add(cmd);
        cmd.execute();
    }
    
}
