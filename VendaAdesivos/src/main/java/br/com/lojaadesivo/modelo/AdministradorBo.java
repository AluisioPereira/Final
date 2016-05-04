/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.modelo;

import br.com.lojaadesivo.dao.AdministradorDao;
import br.com.lojaadesivo.entidades.Administrador;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluísio
 */
public class AdministradorBo {

    private AdministradorDao dao1;

    public boolean addAdministrador(Administrador a) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new AdministradorDao();
        return dao1.addAdministrador(a);
    }

    public boolean atualizarAdministrador(Administrador a) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new AdministradorDao();
        return dao1.atualizarAdministrador(a);
    }

    public boolean removerAdministrador(Administrador a) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new AdministradorDao();
        return dao1.removerAdministrador(a);
    }

    public Administrador buscarAdministrador(String key) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new AdministradorDao();
        return dao1.buscarAdministrador(key);
    }

    public List<Administrador> listarTodos() throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new AdministradorDao();
        return dao1.listarTodos();
    }

    public Administrador loginAdeministrador(String email, String senha) throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        this.dao1 = new AdministradorDao();
        return dao1.loginAdeministrador(email, senha);
    }

}
