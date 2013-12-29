package br.com.mau.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name="agenda")
public class Agenda implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    private String nome;
    
    private String[] agenda;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar hora_inicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)  
    private Calendar hora_fim;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getAgenda() {
        return agenda;
    }

    public void setAgenda(String[] agenda) {
        this.agenda = agenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Calendar hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Calendar getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(Calendar hora_fim) {
        this.hora_fim = hora_fim;
    }
}
