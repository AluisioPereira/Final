/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.entidades.estado;

import br.com.lojaadesivo.excecao.CarrinhoVazioExcecao;

/**
 *
 * @author Aluísio
 */
public interface EstadoCarrinho {

    /**
     * Método busca dado atributo da classe a ser retornado
     *
     * @return
     * @throws br.com.lojaadesivo.excecao.CarrinhoVazioExcecao
     */
    public EstadoCarrinho cheio() throws CarrinhoVazioExcecao;

    /**
     * Método busca dado atributo da classe a ser retornado
     *
     * @return
     * @throws br.com.lojaadesivo.excecao.CarrinhoVazioExcecao
     */
    public EstadoCarrinho vazio() throws CarrinhoVazioExcecao;

}
