/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.entidades;

import br.com.lojaadesivo.entidades.observe.NotificacaoPorEmail;
import br.com.lojaadesivo.entidades.observe.Observador;

/**
 *
 * @author Aluísio
 */
public class Cliente implements Observador<Adesivos> {

    private String email;
    private String senha;

    /**
     * Contrutor da Classe recebendo parametros
     *
     */
    public Cliente() {
    }

    /**
     * Contrutor da Classe recebendo parametros
     *
     * @param email
     * @param senha
     */
    public Cliente(String email, String senha) {
        this.email = email;
        this.senha = email;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param nome
     */
    public void setEmail(String nome) {
        this.email = nome;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     *
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Método set altera dado atributo da classe
     *
     * @param email
     */
    public void setSenha(String email) {
        this.senha = email;
    }

    /**
     * Método manda mensagem do cliente
     *
     * @param adesivo
     */
    public void update(Adesivos adesivo) {
        System.out.println("Notificação por email:");
        NotificacaoPorEmail.sendEmail(this.email, "Seu cadastro realizado com sucesso na loja! Venda Adesivos Ltda. \n Email: " + getEmail() + "Senha: " + getSenha());
    }

}
