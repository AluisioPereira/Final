/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.dao;

import br.com.lojaadesivo.entidades.Adesivos;
import br.com.lojaadesivo.entidades.Compra;
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
public class CompraDao {

    private Connection conexao;

    public CompraDao() throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.conexao = new ConexaoFabrica().getConection();
    }

    /**
     *
     * Método responsável por inserir no banco de dados as iformações relativa
     * ao objeto.
     */
    public boolean addCompra(Compra c) {
        String sql = "INSERT INTO compra (codigo, idcarrinho, emailcliente, adesivos, datacompra, valorcompra) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.setInt(2, c.getIdCarrinho());
            ps.setString(3, c.getEmailCliente());
            ps.setArray(4, (Array) c.getAdesivos());
            ps.setTimestamp(5, c.getDataCompra());
            ps.setDouble(6, c.getValorCompra());
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
    public boolean atualizarCompra(Compra c) {
        String sql = "UPDATE INTO SET codigo = ?, idcarrinho = ?, emailcliente = ?, adesivos = ?, datacompra = ?, valorcompra =? where id= ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.setInt(2, c.getIdCarrinho());
            ps.setString(3, c.getEmailCliente());
            ps.setArray(4, (Array) c.getAdesivos());
            ps.setTimestamp(5, c.getDataCompra());
            ps.setDouble(6, c.getValorCompra());
            ps.setInt(6, c.getId());
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
    public boolean removerCompra(Compra c) {
        String sql = "DELETE FROM compra WHERE id = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Método responsável pelo relizar uma busca por determindo valor chave(key)
     * passado por parameto para se comprara com o nome, desta forma o mesmo
     * retorna uma ojeto caso seja encontrado caso não, retorna-se uma operação
     * nula (null).
     */
    public Compra buscarCompra(String key) {
        Compra compra = null;
        String sql = "SELECT * FROM compra WHERE emailcliente = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                compra = preencheCompra(rs);
            }
            ps.close();
            return compra;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Método responsável pelo relizar uma busca de todos os ojetos presente no
     * banco retornando assim uma lista destes ojetos, caso não exista nenhum
     * ojeto presente no banco o mesmo retorna a lista vazia.
     */
    public List<Compra> listarTodos() {
        String sql = "SELECT * FROM compra";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Compra> compras = new ArrayList<>();
            while (rs.next()) {
                Compra compra = preencheCompra(rs);

                compras.add(compra);
            }
            ps.close();
            return compras;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Método responsável receber um resultSet de uma consulta e montar o objeto
     * esperado deste resultSet
     */
    private Compra preencheCompra(ResultSet rs) {
        Compra compra;
        try {
            compra = new Compra();
            compra.setId(rs.getInt("id"));
            compra.setCodigo(rs.getString("codigo"));
            compra.setIdCarrinho(rs.getInt("idcarrinho"));
            compra.setEmailCliente(rs.getString("emailcliente"));
            compra.setAdesivos((List<Adesivos>) rs.getArray("idadesivo"));
            compra.setDataCompra(rs.getTimestamp("datacompra"));
            compra.setValorCompra(rs.getDouble("valorcompra"));
        } catch (SQLException ex) {
            ex.printStackTrace();
            compra = null;
        }
        return compra;
    }
}
