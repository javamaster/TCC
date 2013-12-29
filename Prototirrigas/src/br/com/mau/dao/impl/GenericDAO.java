/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mau.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Mauricio
 */
public class GenericDAO<PK, T> {
    
    private EntityManager em;
    private Class classFind;

    public GenericDAO(EntityManager manager, Class c) {
        this.em = manager;
        this.classFind = c;
    }
    
    
    public T getByID(PK pk){
        return (T) this.em.find(classFind, pk);
    }
   
    public void save(T entity){
        try {
            this.em.getTransaction().begin();
            this.em.persist(entity);       
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        
    }
    
    public void update(T entity){
        this.em.merge(entity);
    }
    
    public void delete(T entity){
        
         this.em.remove(entity);
        
    }
    
    public List<T> findAll(){
        return this.em.createQuery("Select e From " + classFind.getName()+ " e").getResultList();
    }
    
    
}
