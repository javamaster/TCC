/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prototirrigas;

import br.com.mau.command.Command;
import br.com.mau.command.ControllerInvoker;
import br.com.mau.command.impl.StartSystemCommand;
import br.com.mau.communication.BluetoothCommunicator;
import br.com.mau.communication.Communicator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mauricio
 */
public class Teste {
    
    public static void main(String[] args) {
        
        
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("irrigas_PU");
        EntityManager manager = fac.createEntityManager();
        manager.getTransaction().begin();
        //manager.clear();
        
//        Cultura cultura = new Cultura();
//        cultura.setNome("Alface");
//        cultura.setCategoria("Hortaliça");
//        cultura.setDescricao("Qualidade A");
//        
//        Setor setor = new Setor();
//        setor.setComprimento(1.00);
//        setor.setLargura(0.5);
//        setor.setDescricao("Cultivo de Hortaliças");
//        setor.setNome("Hortaliças");
//        setor.setCultura(cultura);
////        
//        Ambiente a = new Ambiente();
//        a.setLuminosity(300f);
//        a.setRecordDate(new Timestamp(new Date().getTime()));
//        a.setTemperature(20f);
//        
//         EntityManager manager1 = JPAUtil.createEntityManager();
//         
//        JPAUtil.beginTransaction();
//        GenericDAO dao = new GenericDAO(manager1, Setor.class);
//        
//        //Busca por um setor especifico
//        Setor s = (Setor) dao.getByID(62L);
//        
//        // Adiciona o ambiente no setor
//        s.getAmbientes().add(a);
//        s.setNome("Leguminosas");
//  
////       manager.persist(setor);        
//        //Atualiza o setor
//        
//          dao.update(s);
////        manager.getTransaction().commit();
////        
////      
//        
//       
//         
//                
//        for (Iterator it = dao.findAll().iterator(); it.hasNext();) {
//            Setor setorx = (Setor) it.next();
//            System.out.println(setorx.toString());
//        }
//        
//        //dao.delete(s);
//        JPAUtil.commit();
//        
//        

        
//        ControllerInvoker invoker = new ControllerInvoker();
//        
//        Command cmd = new StartSystemCommand();
//        
//        invoker.storeAndExecuteCommand(cmd);
        
        Communicator comm = new BluetoothCommunicator();
        comm.initialize();
        comm.write(0);
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        comm.write(2);
        
    }
}
