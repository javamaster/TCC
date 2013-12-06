/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mauricio.jobs;

import br.com.mauricio.Agenda;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Mauricio
 */
public class WaterController implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        startIrrigation(context);
    }
    
    public void startIrrigation(JobExecutionContext context){
        
        System.out.println("Sistema de irrigação iniciado");
        JobDataMap map = context.getMergedJobDataMap();
        
        Agenda agenda = (Agenda) map.get("agenda");
        
        if(!map.isEmpty())
            System.out.println("Parametros: \n(setor): "+agenda.getId_setor()+"\n(inicio): "+agenda.getData_inicio());
        else{
            System.out.println("Valores não encontrados");
        }
    }
    
    
}
