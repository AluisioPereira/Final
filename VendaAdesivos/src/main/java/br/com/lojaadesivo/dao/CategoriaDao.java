/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.dao;

import br.com.lojaadesivo.entidades.Adesivos;
import br.com.lojaadesivo.entidades.Categorias;
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
public class CategoriaDao {

    private Connection conexao;

    public CategoriaDao() throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.conexao = new ConexaoFabrica().getConection();
    }

    /**
     *
     * Método responsável por inserir no banco de dados as iformações relativa
     * ao objeto.
     */
    public boolean addCategoria(Categorias c) {
        String sql = "INSERT INTO categoria (descricao, idadesivo) VALUES (?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, c.getDescricao());
            ps.setArray(2, (Array) c.getAdesivos());
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
    public boolean atualizarCategoria(Categorias c) {
        String sql = "UPDATE categoria SET descricao = ?, idadesivo=? where id= ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, c.getDescricao());
            ps.setArray(2, (Array) c.getAdesivos());
            ps.setInt(3, c.getId());
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
    public boolean removerCategoria(Categorias c) {
        String sql = "DELETE FROM categoria WHERE descricao = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, c.getDescricao());
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
    public Categorias buscarCategoria(String key) {
        Categorias categoria = null;
        String sql = "SELECT * FROM categoria WHERE idadesivo=?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                categoria = preencherCategoria(rs);
            }
            ps.close();
            return categoria;
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
    public List<Categorias> listarTodos() {
        String sql = "SELECT * FROM categoria";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Categorias> categorias = new ArrayList<>();
            while (rs.next()) {
                Categorias categoria = preencherCategoria(rs);
                categorias.add(categoria);
            }
            ps.close();
            return categorias;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Método responsável receber um resultSet de uma consulta e montar o objeto
     * esperado deste resultSet
     */
    private Categorias preencherCategoria(ResultSet rs) {
        Categorias categoria;
        try {
            categoria = new Categorias();
            categoria.setId(rs.getInt("id"));
            categoria.setDescricao(rs.getString("descricao"));
            categoria.setAdesivos((List<Adesivos>) rs.getArray("idadesivo"));
        } catch (SQLException ex) {
            ex.printStackTrace();
            categoria = null;
        }
        return categoria;
    }
}
