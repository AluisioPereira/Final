/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.modelo;

import br.com.lojaadesivo.dao.CategoriaDao;
import br.com.lojaadesivo.entidades.Categorias;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluísio
 */
public class CategoriasBo {

    private CategoriaDao dao1;

    public boolean addCategoria(Categorias c) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CategoriaDao();
        return dao1.addCategoria(c);
    }

    public boolean atualizarCategoria(Categorias c) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CategoriaDao();
        return dao1.atualizarCategoria(c);
    }

    public boolean removerCategoria(Categorias c) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CategoriaDao();
        return dao1.removerCategoria(c);
    }

    public Categorias buscarCategoria(String key) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CategoriaDao();
        return dao1.buscarCategoria(key);
    }

    public List<Categorias> listarTodos() throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CategoriaDao();
        return dao1.listarTodos();
    }

}
