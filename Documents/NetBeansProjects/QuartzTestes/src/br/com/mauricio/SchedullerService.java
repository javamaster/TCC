/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mauricio;

import br.com.mauricio.jobs.StopIrrigation;
import br.com.mauricio.jobs.WaterController;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Mauricio
 */
public class SchedullerService {

    private SchedulerFactory factory;
    private Scheduler scheduller;
    private SimpleTrigger stopTrigger, startTrigger;
    private JobDetail startJob, stopJob;
    
    public SchedullerService() throws SchedulerException {
        factory = new StdSchedulerFactory();
        scheduller = factory.getScheduler();
    }
    
    /*
     * 
     */
    public boolean timerMode(Agenda agenda){
        try {            
            Date inicio = agenda.getData_inicio();
            Date fim = agenda.getData_fim();
            int idSetor = agenda.getId_setor();
            
            JobDataMap map = new JobDataMap();
            
            map.put("agenda", agenda);
            
            startScheduller();
            
            System.out.println(inicio);
            
            //Criando os JOBs
            startJob = JobBuilder.newJob(WaterController.class).withIdentity("start","group1").usingJobData(map).build();
            stopJob = JobBuilder.newJob(StopIrrigation.class).withIdentity("stop","group1").build();
            
            //Criando os Triggers
            startTrigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                        .withIdentity("startTrigger","grupo1")
                        .startAt(inicio)
                        .forJob(startJob).build(); 
            
            stopTrigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                        .withIdentity("stopTrigger","grupo2")
                        .startAt(fim)
                        .forJob(stopJob).build(); 
            
            //Iniciando o scheduller
            scheduller.scheduleJob(startJob, startTrigger);
            scheduller.scheduleJob(stopJob, stopTrigger);
            
            
            
        } catch (SchedulerException ex) {
            Logger.getLogger(SchedullerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Boolean.TRUE;
       
    }
    
    public boolean smartMode(){
        return Boolean.FALSE;
    }
    
    public void startScheduller(){
        try {
            scheduller.start();
        
        } catch (SchedulerException ex) {
            //return Boolean.FALSE;
            Logger.getLogger(SchedullerService.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }

    
}
