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
public class ItemCompra {

    private int id;
    private Adesivos adesivo;
    private int quantidade;
    private double total;

    /**
     * Contrutor da Classe recebendo parametros
     *
     */
    public ItemCompra() {
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
    public Adesivos getAdesivo() {
        return adesivo;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param adesivo
     */
    public void setAdesivo(Adesivos adesivo) {
        this.adesivo = adesivo;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     *
     * @return
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     *
     * @return
     */
    public double getTotal() {
        this.total = this.quantidade * this.adesivo.getPreco();
        return total;
    }

}
