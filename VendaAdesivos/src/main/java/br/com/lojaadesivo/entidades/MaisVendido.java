/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.entidades;

/**
 *
 * @author Aluísio
 */
public class MaisVendido {

    private int id;
    private int idProduto;
    private String emailCliente;

    /**
     * Contrutor da Classe sem parametros
     *
     */
    public MaisVendido() {
    }

    /**
     * Contrutor da Classe recebendo parametros
     *
     * @param idProduto
     * @param emailCliente
     */
    public MaisVendido(int idProduto, String emailCliente) {
        this.idProduto = idProduto;
        this.emailCliente = emailCliente;
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
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param idProduto
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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

}
