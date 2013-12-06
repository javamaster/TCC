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
public class DataPersistDBJob  implements Job{

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        System.out.println("Serviço de persistencia executando");
    }
    
    
    
}
