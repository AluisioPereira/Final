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
public class Administrador {

    private String email;
    private String senha;

    /**
     * Contrutor da Classe recebendo parametros
     * @param email
     * @param senha
     */
    public Administrador(String email, String senha) {
        this.email = email;
        this.senha = email;
    }

    /**
     * Contrutor da padrão sem paramatro da classe
     */
    public Administrador() {
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @return 
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método set altera dado atributo da classe
     * @param nome
     */
    public void setEmail(String nome) {
        this.email = nome;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @return 
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Método set altera dado atributo da classe
     * @param email
     */
    public void setSenha(String email) {
        this.senha = email;
    }

}
