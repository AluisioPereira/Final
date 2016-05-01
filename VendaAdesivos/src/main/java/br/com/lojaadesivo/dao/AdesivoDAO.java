/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.dao;

import br.com.lojaadesivo.entidades.Adesivos;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Aluísio
 */
public class AdesivoDAO {

    private static final String SELECTALL = "SELECT * FROM adesivo";
    private static final String SELECTID = "SELECT * FROM adesivo WHERE id=?";

    public ArrayList<Adesivos> listar() {
        Connection conexao = null;
        ArrayList<Adesivos> listaAdesivo = new ArrayList<Adesivos>();
        

    }

}
