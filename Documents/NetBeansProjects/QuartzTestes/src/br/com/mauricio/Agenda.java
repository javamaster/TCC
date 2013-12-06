/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mauricio;

import java.util.Date;

/**
 *
 * @author Mauricio
 */
public class Agenda {
    
    private Date data_inicio;
    private Date data_fim;
    private int id_setor;

    public Agenda() {}

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public int getId_setor() {
        return id_setor;
    }

    public void setId_setor(int id_setor) {
        this.id_setor = id_setor;
    }
    
    
    
}
