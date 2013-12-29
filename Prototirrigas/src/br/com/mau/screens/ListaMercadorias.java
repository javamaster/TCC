/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mau.screens;

import br.com.mau.tablemodel.MercadoriaTableModel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import br.com.mau.model.Mercadoria;

/**
 *
 * @author Mauricio
 */
public class ListaMercadorias extends javax.swing.JInternalFrame {

    private JTable table;
    /**
     * Creates new form ListaMercadorias
     */
    public ListaMercadorias() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,500);
        criarTabela();
        carregaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregaTabela(){
        List<Mercadoria> ms = new ArrayList<Mercadoria>();
        
        for (int i = 0; i < 20; i++) {
            ms.add(new Mercadoria("Computador", "DEll", 1560.00, new Date(), new Date()));
        }
        
       MercadoriaTableModel model = new MercadoriaTableModel(ms);
        
        table.setModel(model);
    }
    private void criarTabela(){
        
        //Criando a tabela
        table = new JTable();
        table.setBorder(new LineBorder(Color.BLACK));
        table.setGridColor(Color.BLACK);
        table.setShowGrid(true);
        
                
        //Criando o JScrollPane
        JScrollPane scroll = new JScrollPane();
        scroll.setBackground(Color.RED);
        scroll.getViewport().setBorder(null);
        scroll.setSize(450,280);
        scroll.getViewport().add(table);  
        jPanel1.add(scroll);
        
    }
    

    
     // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
