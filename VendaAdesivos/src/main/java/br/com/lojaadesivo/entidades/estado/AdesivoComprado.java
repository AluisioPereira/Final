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
public class AdesivoComprado implements AdesivoEstado {

    public AdesivoComprado() {
    }

    /**
     * Método busca dado atributo da classe a ser retornado
     *
     * @return
     */
    @Override
    public AdesivoEstado comprados() throws AdesivoCompradoExcecao {
        throw new AdesivoCompradoExcecao();
    }

    /**
     * Método busca dado atributo da classe a ser retornado
     *
     * @return
     * @throws br.com.lojaadesivo.excecao.AdesivoCompradoExcecao
     */
    @Override
    public AdesivoEstado disponivel() throws AdesivoCompradoExcecao {
        throw new AdesivoCompradoExcecao();
    }
}
