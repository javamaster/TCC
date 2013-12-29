/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mau.beans;

import java.util.Date;

/**
 *
 * @author Mauricio
 */
public class Mercadoria {
    
    private String nome;
    private String descricao;
    private Double valor;
    private Date fabricacao;
    private Date validade;

    public Mercadoria() {
    }

    public Mercadoria(String nome, String descricao, Double valor, Date fabricacao, Date validade) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.fabricacao = fabricacao;
        this.validade = validade;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(Date fabricacao) {
        this.fabricacao = fabricacao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
    
    
    
}
