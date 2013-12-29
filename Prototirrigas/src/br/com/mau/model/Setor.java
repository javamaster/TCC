/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mau.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name="setor")
public class Setor implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @OneToMany(cascade= CascadeType.ALL)
    private Set<Ambiente> ambientes = new HashSet<Ambiente>();
    
    private double largura;
    private double comprimento;
    
    @OneToOne(cascade= CascadeType.ALL)
    private Cultura cultura;
    
    private String descricao;
    private String nome;    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cultura getCultura() {
        return cultura;
    }

    public void setCultura(Cultura cultura) {
        this.cultura = cultura;
    }


    public Set<Ambiente> getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(Set<Ambiente> ambientes) {
        this.ambientes = ambientes;
    }

    @Override
    public String toString() {
        return "Setor{" + "largura=" + largura + ", comprimento=" + comprimento + ", cultura=" + cultura + ", descricao=" + descricao + ", nome=" + nome + '}';
    }
    
    
}
