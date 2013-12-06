/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mauricio;

import br.com.mauricio.jobs.DataPersistDBJob;
import java.text.DateFormat;
import java.text.Format;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Calendar;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerUtils;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Mauricio
 */
public class QuartzTestes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Obter um ScheduleFactory {StdSchedulerFactory ou DirectSchedulerFactory}
            SchedulerFactory factory = new StdSchedulerFactory();
            
            //obter  Schedule a partir de Factory
            Scheduler sch = factory.getScheduler();
            
            //Iniciar um scheduler
            sch.start();
            
            //Criar um jobDetail
            JobDetail job = JobBuilder.newJob(DataPersistDBJob.class).withIdentity("myDB","group1").build();
            
//            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").
//                    withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();
//            
//            Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").
//                    withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(2)).build();
//            
           java.util.Calendar cal =  java.util.Calendar.getInstance();
           cal.set(2013,java.util.Calendar.JULY, 26, 15, 25);
            //DateFormat f = DateFormat.getDateInstance();
            
            System.out.println(cal.getTime());
            
           SimpleTrigger trigger3 = (SimpleTrigger) TriggerBuilder.newTrigger()
                   .withIdentity("trigger3","grupo1")
                   .startAt(cal.getTime())
                   .forJob(job).build(); 
            
            
            
            sch.scheduleJob(job, trigger3);
            
        } catch (SchedulerException ex) {
            Logger.getLogger(QuartzTestes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
