/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.entidades;

import br.com.lojaadesivo.entidades.estado.AdesivoEstado;
import br.com.lojaadesivo.excecao.AdesivoCompradoExcecao;

/**
 *
 * @author Aluísio
 */
public class Adesivos {

    private int id;
    private String nome;
    private String categoria;
    private double preco;
    private int qtdDisponivel;
    private String imagem;
    private AdesivoEstado estado;

    /**
     * Contrutor da Classe recebendo parametros
     * @param nome
     * @param categoria
     * @param preco
     * @param qtdDisponivel
     * @param imagem
     */
    public Adesivos(String nome, String categoria, double preco, int qtdDisponivel, String imagem) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.qtdDisponivel = qtdDisponivel;
        this.imagem = imagem;
    }

    /**
     * Contrutor da Classe recebendo parametros
     * @param nome
     * @param categoria
     * @param preco
     * @param quantidade
     */
    public Adesivos(String nome, String categoria, String preco, String quantidade, String imagem) {
        this.nome = nome;
        this.categoria = categoria;
        this.imagem = imagem;

    }

    /**
     * Contrutor da padrão sem paramatro da classe
     */
    public Adesivos() {

    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @return 
     */
    public AdesivoEstado getEstado() {
        return estado;
    }

    /**
     * Método set altera dado atributo da classe
     * @param estado
     */
    public void setEstado(AdesivoEstado estado) {
        this.estado = estado;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Método set altera dado atributo da classe
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @return 
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método set altera dado atributo da classe
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @return 
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Método set altera dado atributo da classe
     * @param categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @return 
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Método set altera dado atributo da classe
     * @param preco
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @return 
     */
    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    /**
     * Método set altera dado atributo da classe
     * @param qtdDisponivel
     */
    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @return 
     */
    public String getImagem() {
        return imagem;
    }

    /**
     * Método set altera dado atributo da classe
     * @param imagem
     */
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @throws br.com.lojaadesivo.excecao.AdesivoCompradoExcecao
     */
    public void comprar() throws AdesivoCompradoExcecao {
        this.estado = this.estado.comprados();
    }

    /**
     * Método adicona um dado objeto recebido
     * @param c
     */
    public void addObserver(Cliente c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
