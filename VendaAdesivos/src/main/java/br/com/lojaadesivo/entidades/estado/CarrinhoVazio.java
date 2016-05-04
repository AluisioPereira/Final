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
public class CarrinhoVazio implements EstadoCarrinho {

    /**
     * Método busca dado atributo da classe a ser retornado
     *
     * @return
     * @throws br.com.lojaadesivo.excecao.CarrinhoVazioExcecao
     */
    @Override
    public EstadoCarrinho cheio() throws CarrinhoVazioExcecao {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método busca dado atributo da classe a ser retornado
     *
     * @return
     * @throws br.com.lojaadesivo.excecao.CarrinhoVazioExcecao
     */
    @Override
    public EstadoCarrinho vazio() throws CarrinhoVazioExcecao {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
