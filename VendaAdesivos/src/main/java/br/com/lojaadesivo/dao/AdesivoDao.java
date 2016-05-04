/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.dao;

import br.com.lojaadesivo.entidades.Adesivos;
import br.com.lojaadesivo.fabrica.ConexaoFabrica;
import java.io.IOException;
import java.net.URISyntaxException;
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
public class AdesivoDao {

    private Connection conexao;

    public AdesivoDao() throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.conexao = new ConexaoFabrica().getConection();
    }

    /**
     *
     * Método responsável por inserir no banco de dados as iformações relativa a
     * adesivos para para inserção de um novo adesivo no banco.
     */
    public boolean addAdesivo(Adesivos a) {
        String sql = "INSERT INTO adesivo (nome, categoria, precounid, qtddisponivel, imagem ) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getCategoria());
            ps.setDouble(3, a.getPreco());
            ps.setInt(4, a.getQtdDisponivel());
            ps.setString(5, a.getImagem());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    /**
     * Método responsável pelo UPDATE de adesivo no banco de dados este recebe
     * um objeto do tipo adesivo e atualiza as informações do mesmo no banco.
     */
    public boolean atualizarAdesivo(Adesivos a) {
        String sql = "UPDATE adesivo SET (nome=?, categoria=?, precounid=?, qtddisponivel=?, imagem=? ) where id=?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getCategoria());
            ps.setDouble(3, a.getPreco());
            ps.setInt(4, a.getQtdDisponivel());
            ps.setString(5, a.getImagem());
            ps.setInt(6, a.getId());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    /**
     * Método responsável pelo relizar o DELETE de dado adesivo no banco de
     * dados Seleciona o ojeto a ser excluido pelo idetificador (id) e retorna
     * um boolean true(verdade) caso operação bem sucessida false(falso) caso
     * não foi encontrodo o adesivo.
     */
    public boolean removerAdesivo(Adesivos a) {
        String sql = "DELETE FROM adesivo WHERE id = ?";
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
     * Método responsável pelo relizar uma busca por determindo valor chave(key)
     * passado por parameto para se comprara com o nome desta forma o mesmo
     * retorna uma adesivo caso seja encontrado caso não retorna-se uma operação
     * nula (null)
     */
    public Adesivos buscaSimpleAdesivo(String key) {
        Adesivos adesivo = null;
        String sql = "SELECT * FROM adesivo WHERE nome = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                adesivo = preencherAdesivo(rs);
            }
            ps.close();
            return adesivo;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Método responsável pelo relizar uma busca por determindo valor chave(key)
     * passado por parameto para se comparar como a categoria desta forma o
     * mesmo retorna uma adesivo caso seja encontrado caso não retorna-se uma
     * operação nula (null)
     */
    public Adesivos buscaCategoriaAdesivo(String key) {
        Adesivos adesivo = null;
        String sql = "SELECT * FROM adesivo WHERE categoria = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                adesivo = preencherAdesivo(rs);
            }
            ps.close();
            return adesivo;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Método responsável pelo relizar uma busca de todos os adesivos presente
     * no banco retornando assim uma lista de adesivos caso não exista adesivos
     * no banco o mesmo retorna a lista vazia.
     */
    public List<Adesivos> listarTodos() {
        String sql = "SELECT * FROM adesivo";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Adesivos> adesivos = new ArrayList<>();
            while (rs.next()) {
                Adesivos adesivo = preencherAdesivo(rs);

                adesivos.add(adesivo);
            }
            ps.close();
            return adesivos;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Método responsável receber um resultSet de uma consulta de montar o
     * objeto esperado deste resultSet
     */
    private Adesivos preencherAdesivo(ResultSet rs) {
        Adesivos adesivo;
        try {
            adesivo = new Adesivos();
            adesivo.setId(rs.getInt("id"));
            adesivo.setNome(rs.getString("nome"));
            adesivo.setCategoria(rs.getString("categoria"));
            adesivo.setPreco(rs.getDouble("precounid"));
            adesivo.setQtdDisponivel(rs.getInt("qtddisponivel"));
            adesivo.setImagem(rs.getString("imagem"));
        } catch (SQLException ex) {
            ex.printStackTrace();
            adesivo = null;
        }
        return adesivo;
    }
}
