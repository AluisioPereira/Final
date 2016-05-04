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
public class MaisVendidoDao {

    private Connection conexao;

    public MaisVendidoDao() throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.conexao = new ConexaoFabrica().getConection();
    }

    /**
     *
     * Método responsável por inserir no banco de dados as iformações relativa
     * ao objeto.
     */
    public boolean addMaisVendido(Integer idadesivo, String emailcliente) {
        String sql = "INSERT INTO maisvendido(idadesivo, emailcliente) VALUES (?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idadesivo);
            ps.setString(2, emailcliente);
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
    public boolean removerMaisVendido(Integer idadesivo, String emailcliente) {
        String sql = "DELETE FROM maisvendido WHERE idadesivo = ? AND emailcliente = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idadesivo);
            ps.setString(2, emailcliente);
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
    public List<Adesivos> buscarMaisVendido() {
        String sql = "SELECT * FROM maisvendido";
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
     * Método responsável receber um resultSet de uma consulta e montar o objeto
     * esperado deste resultSet
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
