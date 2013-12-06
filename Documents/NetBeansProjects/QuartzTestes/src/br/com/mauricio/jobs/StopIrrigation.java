/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mauricio.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Mauricio
 */
public class StopIrrigation implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        stopIrrigation();
    }
    
    
    public void stopIrrigation(){
        System.out.println("Sistema de irrigação desligando");
    }
    
}
