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
public class Compra {

    private int id;
    private String codigo;
    private int idCarrinho;
    private String emailCliente;
    private List<Adesivos> adesivos;
    private Timestamp dataCompra;
    private double valorCompra;

    /**
     * Contrutor da Classe recebendo parametros
     *
     * @param codigo
     * @param idCarrinho
     * @param emailCliente
     * @param adesivos
     * @param valorCompra
     * @param dataCompra
     */
    public Compra(String codigo, int idCarrinho, String emailCliente, List<Adesivos> adesivos, Timestamp dataCompra, double valorCompra) {
        this.codigo = codigo;
        this.idCarrinho = idCarrinho;
        this.emailCliente = emailCliente;
        this.adesivos = adesivos;
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra;
    }

    /**
     * Contrutor da Classe recebendo parametros
     *
     */
    public Compra() {
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
    public String getCodigo() {
        return codigo;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     *
     * @return
     */
    public int getIdCarrinho() {
        return idCarrinho;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param idCarrinho
     */
    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     *
     * @return
     */
    public String getEmailCliente() {
        return emailCliente;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param emailCliente
     */
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
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
    public Timestamp getDataCompra() {
        return dataCompra;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param dataCompra
     */
    public void setDataCompra(Timestamp dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     *
     * @return
     */
    public double getValorCompra() {
        return valorCompra;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param valorCompra
     */
    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

}
