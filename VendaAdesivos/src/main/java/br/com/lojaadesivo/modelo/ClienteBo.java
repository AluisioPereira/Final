/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.modelo;

import br.com.lojaadesivo.dao.ClienteDao;
import br.com.lojaadesivo.entidades.Cliente;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluísio
 */
public class ClienteBo {

    private ClienteDao dao1;

    public boolean adicionarCliente(Cliente c) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new ClienteDao();
        return dao1.addCliente(c);
    }
     public boolean atualizarCliente(Cliente c) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
         this.dao1 = new ClienteDao();
        return dao1.atualizarCliente(c);

    }
    public boolean removerCliente(Cliente c) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {  
         this.dao1 = new ClienteDao();
        return dao1.removerCliente(c);
    }
    
    public Cliente buscarCliente(String key) throws IOException, URISyntaxException, ClassNotFoundException, SQLException { 
        this.dao1 = new ClienteDao();
        return dao1.buscarCliente(key);
    }
    public Cliente loginCliente(String email, String senha) throws IOException, URISyntaxException, ClassNotFoundException, SQLException { 
        this.dao1 = new ClienteDao();
        return dao1.loginCliente(email, senha);
    }
    public List<Cliente> listarTodos() throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new ClienteDao();
        return dao1.listarTodos();
    }
    public Cliente verificarCliente(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            return null;
        }
        if (cliente.getSenha() == null || cliente.getSenha().trim().isEmpty()) {
            return null;        
        } else {
            return cliente;
        }
    }
}
