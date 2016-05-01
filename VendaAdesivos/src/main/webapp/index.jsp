<%-- 
    Document   : index
    Created on : 29/04/2016, 17:12:15
    Author     : Aluísio 
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Venda Adesivos</title>
        <link rel="stylesheet" href="acessor/css/bootstrap-theme.min.css" type="text/css">
        <link rel="stylesheet" href="acessor/css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="acessor/css/aluisioIcomoon/style.css" type="text/css"/>
        <style>
            body {
                padding-left: 5%;
                padding-top: 2%;
                padding-right: 5%;
                padding-bottom: 2%;
            }
        </style>
    </head>
    <body>
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="panel panel-default col-lg-6">
                    <div class="panel-heading">
                        <span class='aluisio-search'></span>
                        PESQUISE POR PRODUTO
                    </div>
                    <div class="panel-body">
                        <div class="input-group">
                            <input id="veradesivo" name="veradesivo" class="form-control" placeholder="informações de busca" type="text">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                    Busca
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu pull-right">
                                    <li><a href="simples.jsp">Simples</a></li>
                                    <li><a href="categoria.jsp">Por categorias</a></li>
                                </ul>
                            </div>
                        </div>	
                    </div>
                </div>

                <div class="panel panel-default col-lg-6">
                    <div class="panel-heading">
                        <span class='aluisio-format_list_numbered'></span>
                        CLASSIFIQUE OS PRODUTOS
                    </div>
                    <div class="panel-body">
                        <div class="input-group">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle col-lg-12" data-toggle="dropdown">
                                    Ordenar
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu col-lg-12">
                                    <li><a href="simples.jsp">Produtos mais comprados</a></li>
                                    <li><a href="categoria.jsp">Categoria dos mais comprados</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>


        <script src="acessor/js/jquery-2.1.4.min.js"></script>
        <script src="acessor/js/bootstrap.min.js"></script>

    </body>
</html>
