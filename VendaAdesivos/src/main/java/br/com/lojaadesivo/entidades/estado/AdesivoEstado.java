/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.entidades.estado;

import br.com.lojaadesivo.excecao.AdesivoCompradoExcecao;

/**
 *
 * @author Aluísio
 */
public interface AdesivoEstado {

    /**
     * Método busca dado atributo da classe a ser retornado
     *
     * @return
     * @throws br.com.lojaadesivo.excecao.AdesivoCompradoExcecao
     */
    public AdesivoEstado comprados() throws AdesivoCompradoExcecao;

    /**
     * Método busca dado atributo da classe a ser retornado
     *
     * @return
     * @throws br.com.lojaadesivo.excecao.AdesivoCompradoExcecao
     */
    public AdesivoEstado disponivel() throws AdesivoCompradoExcecao;

}
