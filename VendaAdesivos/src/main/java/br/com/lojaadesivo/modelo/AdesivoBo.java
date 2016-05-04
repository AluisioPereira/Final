/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.modelo;

import br.com.lojaadesivo.dao.AdesivoDao;
import br.com.lojaadesivo.entidades.Adesivos;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluísio
 */
public class AdesivoBo {

    private AdesivoDao dao1;
  /**
     * Método
     *
     * @return
     */
    public boolean addAdesivo(Adesivos a) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new AdesivoDao();
        return dao1.addAdesivo(a);
    }
/**
     * Método
     *
     * @param a
     * @return
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public boolean atualizarAdesivo(Adesivos a) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new AdesivoDao();
        return dao1.atualizarAdesivo(a);
    }
/**
     * Método
     *
     * @param a
     * @return
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public boolean removerAdesivo(Adesivos a) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new AdesivoDao();
        return dao1.removerAdesivo(a);
    }
/**
     * Método
     *
     * @param key
     * @return
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Adesivos buscaSimpleAdesivo(String key) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new AdesivoDao();
        return dao1.buscaSimpleAdesivo(key);
    }
/**
     * Método
     *
     * @param key
     * @return
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     */
    public Adesivos buscaCategoriaAdesivo(String key) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new AdesivoDao();
        return dao1.buscaCategoriaAdesivo(key);
    }
/**
     * Método
     *
     * @return
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public List<Adesivos> listarTodos() throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new AdesivoDao();
        return dao1.listarTodos();
    }

}
