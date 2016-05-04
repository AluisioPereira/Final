/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.controle;

import br.com.lojaadesivo.entidades.Adesivos;
import br.com.lojaadesivo.entidades.Cliente;
import br.com.lojaadesivo.modelo.AdesivoBo;
import br.com.lojaadesivo.modelo.CarrinhoBo;
import br.com.lojaadesivo.modelo.CompraBo;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluísio
 */
public class ServletCompra extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, URISyntaxException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");

        if (cliente != null) {
            String emailCliente = cliente.getSenha();
            String idAdesivo = (String) request.getParameter("idAdesivo");
            request.getSession().setAttribute("idAdesivo", idAdesivo);
            Map<String, String> resultadoLocacao = new HashMap<>();
            boolean comprado = false;
            Adesivos a = null;
            comprado = new CarrinhoBo().AtualizarProdutoCarrinho(a);
            if (comprado) {
                resultadoLocacao.put("comprado", "ok");
            }
            String json = new Gson().toJson(resultadoLocacao);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } else {
            response.sendRedirect("index");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ServletCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ServletCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
