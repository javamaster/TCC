/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mauricio;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.SchedulerException;

/**
 *
 * @author Mauricio
 */
public class App {
    
    public static void main(String[] args) {
        try {
            java.util.Calendar inicio = java.util.Calendar.getInstance();
            java.util.Calendar fim = java.util.Calendar.getInstance();
            
            inicio.set(Calendar.MINUTE, 33);
            inicio.set(Calendar.SECOND, 40);
            
            fim.set(Calendar.MINUTE, 34);
            fim.set(Calendar.SECOND, 00);
           // cal.set(2013,java.util.Calendar.JULY, 26, 15, 50,5);
            
            Agenda agenda = new Agenda();
            
            agenda.setData_inicio(inicio.getTime());
            agenda.setData_fim(fim.getTime());
            
            agenda.setId_setor(12);
            
            SchedullerService service = new SchedullerService();
            
            System.out.println(service.timerMode(agenda)?"Agendamento iniciado com sucesso":"Não foi possivel realizar o agendamento");
            
            
        } catch (SchedulerException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
