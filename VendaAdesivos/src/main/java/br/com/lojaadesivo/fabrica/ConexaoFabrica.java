/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.fabrica;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Aluísio
 */
public class ConexaoFabrica {
  /**
     * Método retorna uma conexão com o banco de dados
     *
     * @return
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public Connection getConection() throws IOException, URISyntaxException, ClassNotFoundException, SQLException {
        String url;
        String user;
        String password;
        String name;
        Properties properties = new Properties();
        properties.load(new FileInputStream(getClass().getResource("/banco/venda.properties").toURI().getPath()));
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        name = properties.getProperty("name");
        Class.forName(name);
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
