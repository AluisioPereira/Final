/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.entidades;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Aluísio
 */
public class Promocao {

    private int id;
    private String nome;
    private List<Adesivos> adesivos;
    private Timestamp dataInicio;
    private Timestamp dataFinal;
    private double desconto;

    /**
     * Contrutor da Classe sem parametros
     *
     */
    public Promocao() {
    }

    /**
     * Contrutor da Classe recebendo parametros
     *
     * @param nome
     * @param adesivos
     * @param dataInicio
     * @param dataFinal
     * @param desconto
     */
    public Promocao(String nome, List<Adesivos> adesivos, Timestamp dataInicio, Timestamp dataFinal, double desconto) {
        this.nome = nome;
        this.adesivos = adesivos;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.desconto = desconto;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     *
     * @return
     */
    public List<Adesivos> getAdesivos() {
        return adesivos;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param adesivos
     */
    public void setAdesivos(List<Adesivos> adesivos) {
        this.adesivos = adesivos;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     *
     * @return
     */
    public Timestamp getDataInicio() {
        return dataInicio;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param dataInicio
     */
    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     *
     * @return
     */
    public Timestamp getDataFinal() {
        return dataFinal;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param dataFinal
     */
    public void setDataFinal(Timestamp dataFinal) {
        this.dataFinal = dataFinal;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     *
     * @return
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param desconto
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

}
