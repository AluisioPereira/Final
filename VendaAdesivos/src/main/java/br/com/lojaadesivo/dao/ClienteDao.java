/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.dao;

import br.com.lojaadesivo.entidades.Cliente;
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
public class ClienteDao {

    private Connection conexao;

    public ClienteDao() throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.conexao = new ConexaoFabrica().getConection();
    }

    /**
     *
     * Método responsável por inserir no banco de dados as iformações relativa
     * ao objeto.
     */
    public boolean addCliente(Cliente c) {
        String sql = "INSERT INTO cliente (email, senha) VALUES (?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, c.getEmail());
            ps.setString(2, c.getSenha());
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
    public boolean atualizarCliente(Cliente c) {
        String sql = "UPDATE cliente SET senha = ? where email= ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, c.getSenha());
            ps.setString(2, c.getEmail());
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
    public boolean removerCliente(Cliente c) {
        String sql = "DELETE FROM cliente WHERE email = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, c.getEmail());
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
    public Cliente buscarCliente(String key) {
        Cliente usuario = null;
        String sql = "SELECT * FROM cliente WHERE email = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                usuario = preencherCliente(rs);
            }
            ps.close();
            return usuario;
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
    public List<Cliente> listarTodos() {
        String sql = "SELECT * FROM cliente";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente usuario = preencherCliente(rs);

                clientes.add(usuario);
            }
            ps.close();
            return clientes;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Método responsável receber um resultSet de uma consulta e montar o objeto
     * esperado deste resultSet
     */
    private Cliente preencherCliente(ResultSet rs) {
        Cliente cliente;
        try {
            cliente = new Cliente();
            cliente.setEmail(rs.getString("email"));
            cliente.setSenha(rs.getString("senha"));
        } catch (SQLException ex) {
            ex.printStackTrace();
            cliente = null;
        }
        return cliente;
    }

    /**
     * Método responsável receber duas String e comparar com as precente no
     * banco para a compatibilidade e se compativel realizar o login do usuário
     */
    public Cliente loginCliente(String email, String senha) {
        Cliente usuario = null;
        try {
            String sql = "SELECT * FROM cliente WHERE  email='" + email + "'AND senha='" + senha + "'";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                usuario = preencherCliente(rs);
            }
            ps.close();
            return usuario;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

}
