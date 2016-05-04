/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.dao;

import br.com.lojaadesivo.entidades.Adesivos;
import br.com.lojaadesivo.entidades.Carrinho;
import br.com.lojaadesivo.entidades.ItemCompra;
import br.com.lojaadesivo.fabrica.ConexaoFabrica;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluísio
 */
public class CarrinhoDao {

    private Connection conexao;

    public CarrinhoDao() throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.conexao = new ConexaoFabrica().getConection();
    }

    /**
     * Método responsável por inserir no banco de dados as iformações relativa
     * ao objeto.
     */
    public boolean addProdutoCarrinho(Adesivos a) {
        String sql = "INSERT INTO carrinho (idproduto, precounid, qtdprodutos) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, a.getId());
            ps.setDouble(2, a.getPreco());
            ps.setInt(3, a.getQtdDisponivel());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    /**
     * Método responsável pelo UPDATE do objeto no banco de dados este recebe um
     * objeto passo por parametro e atualiza as informações do mesmo no banco.
     */
    public boolean AtualizarProdutoCarrinho(Adesivos a) {
        String sql = "UPDATE carrinho SET idproduto=?, precounid=?, qtdprodutos=?  where idproduto=?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, a.getId());
            ps.setDouble(2, a.getPreco());
            ps.setInt(3, a.getQtdDisponivel());
            ps.setInt(4, a.getId());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    /**
     * Método responsável pelo relizar o DELETE de dado referente ao objeto
     * passado por paramento no banco de dados Seleciona o ojeto a ser excluido
     * pelo idetificador (id) e retorna um boolean true(verdade) caso operação
     * bem sucessida false(falso) caso não foi encontrodo o adesivo.
     */
    public boolean removerProdutoCarrinho(Carrinho a) {
        String sql = "DELETE FROM carrinho WHERE idproduto = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, a.getId());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Método responsável por inserir no banco de dados as iformações relativa
     * ao objeto.
     */
    public boolean addCarrinho(Carrinho a) {
        String sql = "INSERT INTO carrinho (idproduto, precounid, qtdprodutos) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, a.getId());
            ps.setDouble(2, a.getTotal());
            ps.setInt(3, a.getQtdproduto());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    /**
     * Método responsável pelo UPDATE do objeto no banco de dados este recebe um
     * objeto passo por parametro e atualiza as informações do mesmo no banco.
     */
    public boolean atualizarCarrinho(Carrinho a) {
        String sql = "UPDATE carrinho SET idproduto=?, precounid=?, qtdprodutos=?  where id=?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setArray(1, (Array) a.getItens());
            ps.setDouble(2, a.getTotal());
            ps.setInt(3, a.getQtdproduto());
            ps.setInt(4, a.getId());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    /**
     * Método responsável pelo relizar o DELETE de dado referente ao objeto
     * passado por paramento no banco de dados Seleciona o ojeto a ser excluido
     * pelo idetificador (id) e retorna um boolean true(verdade) caso operação
     * bem sucessida false(falso) caso não foi encontrodo o adesivo.
     */
    public boolean removerCarrinho(Carrinho a) {
        String sql = "DELETE FROM carrinho WHERE id = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, a.getId());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Método responsável pelo relizar uma busca de todos os ojetos presente no
     * banco retornando assim uma lista destes ojetos, caso não exista nenhum
     * ojeto presente no banco o mesmo retorna a lista vazia.
     */
    public List<Carrinho> listarTodos() {
        String sql = "SELECT * FROM carrinho";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Carrinho> carrinhos = new ArrayList<>();
            while (rs.next()) {
                Carrinho carrinho = preencherCarrinho(rs);

                carrinhos.add(carrinho);
            }
            ps.close();
            return carrinhos;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Método responsável receber um resultSet de uma consulta e montar o objeto
     * esperado deste resultSet
     */
    private Carrinho preencherCarrinho(ResultSet rs) {
        Carrinho carrinho;
        try {
            carrinho = new Carrinho();
            carrinho.setId(rs.getInt("id"));
            carrinho.setItens((List<ItemCompra>) rs.getArray("idproduto"));
            carrinho.setTotal(rs.getInt("precounid"));
            carrinho.setQtdprodutos();
        } catch (SQLException ex) {
            ex.printStackTrace();
            carrinho = null;
        }
        return carrinho;
    }

}
