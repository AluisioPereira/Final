/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.entidades;

import java.util.List;

/**
 *
 * @author Aluísio
 */
public class Categorias {

    private int id;
    private String descricao;
    private List<Adesivos> adesivos;

    /**
     * Contrutor da Classe recebendo parametros
     */
    public Categorias() {
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
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

}
