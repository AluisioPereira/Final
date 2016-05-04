/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.modelo;

import br.com.lojaadesivo.dao.CarrinhoDao;
import br.com.lojaadesivo.entidades.Adesivos;
import br.com.lojaadesivo.entidades.Carrinho;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluísio
 */
public class CarrinhoBo {

    private CarrinhoDao dao1;
    
    
    public boolean addProdutoCarrinho(Adesivos a) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CarrinhoDao();
        return dao1.addProdutoCarrinho(a);
    }
    public boolean AtualizarProdutoCarrinho(Adesivos a) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CarrinhoDao();
        return dao1.AtualizarProdutoCarrinho(a);
    }
    public boolean removerProdutoCarrinho(Carrinho a) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CarrinhoDao();
        return dao1.removerProdutoCarrinho(a);
    }
   
    public boolean addCarrinho(Carrinho a) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CarrinhoDao();
        return dao1.addCarrinho(a);
    }

    public boolean atualizarCarrinho(Carrinho a) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CarrinhoDao();
        return dao1.atualizarCarrinho(a);
    }

    public boolean removerCarrinho(Carrinho a) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CarrinhoDao();
        return dao1.removerCarrinho(a);
    }

    public List<Carrinho> listarTodos() throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new CarrinhoDao();
        return dao1.listarTodos();
    }
   
}
