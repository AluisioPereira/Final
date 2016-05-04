/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.modelo;

import br.com.lojaadesivo.dao.CompraDao;
import br.com.lojaadesivo.entidades.Compra;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluísio
 */
public class CompraBo {

    private CompraDao dao1;

    public boolean addCompra(Compra c) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CompraDao();
        return dao1.addCompra(c);
    }

    public boolean atualizarCompra(Compra c) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CompraDao();
        return dao1.atualizarCompra(c);
    }

    public boolean removerCompra(Compra c) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CompraDao();
        return dao1.removerCompra(c);
    }

    public Compra buscarCompra(String key) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CompraDao();
        return dao1.buscarCompra(key);
    }

    public List<Compra> listarTodos() throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CompraDao();
        return dao1.listarTodos();
    }

}
