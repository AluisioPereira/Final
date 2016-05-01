<%-- 
    Document   : LoginCadastrar
    Created on : 30/04/2016, 14:11:30
    Author     : Aluísio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
                        <div class="panel-heading">
                            <span class='aluisio-account_circle'></span>
                            ACESSE
                        </div>
                    </div>
                    <div class="panel-body">
                        <form class="form-group-lg">
                            <div class="input-group">
                                <span class='aluisio-mail_outline'></span> E-mail *: 
                                <input id="usuario" name="usuario" class="form-control" placeholder="e-mail" type="text">
                            </div>
                            <div class="input-group">
                                <span class=' aluisio-lock_open'></span> Senha *: 
                                <input id="senha" type="password" name="senha" class="form-control" placeholder="senha" type="text">
                            </div>
                            <br>
                            <div class="input-group-btn">
                                <div class="form-group">
                                    <div class="">
                                        <button id="butao" type="submit" name="butao" class="btn btn-success">acesse</button>
                                    </div>
                                </div>                            
                            </div>
                        </form>
                        <p class="lost_password"> <a href="">Perdeu sua senha?</a></p>
                    </div>
                </div>
                <div class="panel panel-default col-lg-6">
                    <div class="panel-heading">
                        <div class="panel-heading">
                            <span class='aluisio-keyboard'></span>
                            CADASTRE-SE
                        </div>
                    </div>
                    <div class="panel-body">
                        <form class="form-group-lg">
                            <div class="input-group">
                                <span class='aluisio-mail_outline'></span> E-mail *: 
                                <input id="usuario" name="usuario" class="form-control" placeholder="e-mail" type="text">
                            </div>
                            <div class="input-group">
                                <span class=' aluisio-lock_open'></span> Senha *: 
                                <input id="senha" type="password" name="senha" class="form-control" placeholder="senha" type="text">
                            </div>
                            <br>
                            <div class="input-group-btn">
                                <div class="form-group">
                                    <div class="">
                                        <button id="butao" type="submit" name="butao" class="btn btn-success">salvar</button>
                                    </div>
                                </div>                            
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
        <script src="acessor/js/jquery-2.1.4.min.js"></script>
        <script src="acessor/js/bootstrap.min.js"></script>        
    </body>
</html>
