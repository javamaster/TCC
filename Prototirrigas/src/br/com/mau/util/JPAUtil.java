/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mau.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

/**
 *
 * @author Mauricio
 */
public class JPAUtil {
    
    private static Logger log = Logger.getLogger(JPAUtil.class);
    
    private static final String PERSISTENCE_UNIT_NAME = "irrigas_PU";
    
    private static EntityManagerFactory factory;
    private static EntityManager manager;
    
    static{
        try {
           factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME); 
        } catch (Exception e) {
            log.error("Não conseguiu carregar a EntityManagerFactory: "+e.getMessage());
        }
        
    }
    
    public static EntityManager createEntityManager(){
        
        if(!factory.isOpen()){
            throw new RuntimeException("EntityManagerFactory está fechada!");
        }
        manager = factory.createEntityManager();
        return manager;
    }
    
   public static void close(){
       if(factory.isOpen() ){
            factory.close();
       }
       if(manager.isOpen()){
           manager.close();
       }
   }
   
   public static void beginTransaction(){
       manager.getTransaction().begin();
   }
   
   public static void rollback(){
       manager.getTransaction().rollback();
   }    
   
   public static void commit(){
       manager.getTransaction().commit();
   }
   
   
   
}
