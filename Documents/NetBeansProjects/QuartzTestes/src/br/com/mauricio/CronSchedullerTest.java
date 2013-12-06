/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mauricio;

import br.com.mauricio.jobs.DataPersistDBJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Mauricio
 */
public class CronSchedullerTest {
    
    public static void main(String[] args) {
        try {
            
            //Fábrica de Schedulers
            SchedulerFactory schedFact = new StdSchedulerFactory();
            
            //obtem um Schduler d fábrica
            Scheduler sched = schedFact.getScheduler();
            
            //Inicia o scheduler
            sched.start();
            
            //Cria um Job (Tarefa) para ser executada
            JobDetail job = JobBuilder.newJob(DataPersistDBJob.class).withIdentity("DBJob","group1" ).build();
            
            //Criar um Trigger (Gatilho) para disparar a execução da tarefa agendada.
            Trigger trigger = TriggerBuilder.newTrigger()
                              .withIdentity("disparaDB", "group1")
                              .withSchedule(CronScheduleBuilder.cronSchedule("0/5 49 * * * ?"))
                              .build();
            
            //Executa a tarefa agendada
            sched.scheduleJob(job, trigger);
            
        } catch (SchedulerException ex) {
            System.err.println("Error");
        }
        
    }
    
}
