/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.controle;

import br.com.lojaadesivo.entidades.Administrador;
import br.com.lojaadesivo.entidades.Cliente;
import br.com.lojaadesivo.modelo.AdministradorBo;
import br.com.lojaadesivo.modelo.ClienteBo;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aluísio
 */
public class ServletClienteLogin extends HttpServlet {

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
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        ClienteBo clienteBo = new ClienteBo();
        Cliente cliente = clienteBo.loginCliente(email, senha);
        AdministradorBo adminBo = new AdministradorBo();
        Administrador admin = adminBo.loginAdeministrador(email, senha);
        if (cliente != null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("cliente", cliente);
            response.sendRedirect("index.jsp");

        } else if (admin != null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("admin", admin);
            response.sendRedirect("manterProduto.jsp");
        } else {
            response.sendRedirect("erro1.jsp");
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
            Logger.getLogger(ServletClienteLogin.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletClienteLogin.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(ServletClienteLogin.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletClienteLogin.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletClienteLogin.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(ServletClienteLogin.class
                    .getName()).log(Level.SEVERE, null, ex);
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
