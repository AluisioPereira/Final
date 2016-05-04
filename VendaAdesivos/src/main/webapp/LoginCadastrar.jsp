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
            <div class="panel-heading">
                <%@include file="/WEB-INF/jspf/menu.jspf" %>                 
            </div>
            <div class="panel-body">
                <div class="panel panel-default col-lg-6">
                    <div class="panel-heading">
                        <div class="panel-heading">
                            <span class='aluisio-account_circle'></span>
                            ACESSE
                        </div>
                    </div>
                    <div class="panel-body">
                        <form class="form-group-lg" action="ServletClienteLogin" method="post">
                            <div class="input-group">
                                <span class='aluisio-mail_outline'></span> E-mail *: 
                                <input id="usuario" name="email" class="form-control" placeholder="e-mail" type="text">
                            </div>
                            <div class="input-group">
                                <span class=' aluisio-lock_open'></span> Senha *: 
                                <input id="senha" type="password" name="senha" class="form-control" placeholder="senha" type="text">
                            </div>
                            <br>
                            <div class="input-group-btn">
                                <div class="form-group">
                                    <div class="">
                                        <button type="submit" class="btn btn-success">acesse</button>
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
                        <form class="form-group-lg" action="ServletCliente" method="post">
                            <div class="input-group">
                                <span class='aluisio-mail_outline'></span> E-mail *: 
                                <input id="usuario" name="email" class="form-control" placeholder="e-mail" type="text">
                            </div>
                            <div class="input-group">
                                <span class=' aluisio-lock_open'></span> Senha *: 
                                <input id="senha" type="password" name="senha" class="form-control" placeholder="senha" type="text">
                            </div>
                            <br>
                            <div class="input-group-btn">
                                <div class="form-group">
                                    <div class="">
                                        <button type="submit" class="btn btn-success">salvar</button>
                                    </div>
                                </div>                            
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="panel-footer">
                <%@include file="/WEB-INF/jspf/rodape_1.jspf" %>
            </div>
        </div>
        <script src="acessor/js/jquery-2.1.4.min.js"></script>
        <script src="acessor/js/bootstrap.min.js"></script>
        <script type="text/javascript">

            function processaRequest() {
                event.preventDefault();

                $('#alertaCpfErro').hide();
                $('#alertaClienteSemCadastro').hide();

                var dados = $("#formulario_cliente").serialize();

                if ($("#cpf").val() === "") {
                    $("#alertaCpfErro").html("Informe um número de CPF").show(250);
                } else {
                    $.post("Atendimento", dados, function (responseJson) {
                        var cpf = responseJson.cpf;

                        if (cpf === "verificado") {
                            if (responseJson.operacao === "clienteNãoExiste") {
                                $("#btnCadastrar").attr("href", 'cadastro?cpf=' + $("#cpf").val());
                                $("#alertaClienteSemCadastro").show(250);
                            } else {
                                $(location).attr('href', 'ServletIniciarAtendimento?cpf=' + $("#cpf").val());
                            }
                        } else {
                            $("#alertaCpfErro").html("O CPF informado <strong>não é válido</strong>").show(250);
                        }

                    });
                }

            }

            $("#btnEntrar").click(processaRequest);


            function mascaraInteiro() {
                if (event.keyCode < 48 || event.keyCode > 57) {
                    event.returnValue = false;
                    return false;
                }
                return true;
            }
            function MascaraCPF(cpf) {
                if (mascaraInteiro(cpf) === false) {
                    event.returnValue = false;
                }
                return formataCampo(cpf, '000.000.000-00', event);
            }
            function formataCampo(campo, Mascara, evento) {
                var boleanoMascara;

                var Digitato = evento.keyCode;
                exp = /\-|\.|\/|\(|\)| /g;
                campoSoNumeros = campo.value.toString().replace(exp, "");

                var posicaoCampo = 0;
                var NovoValorCampo = "";
                var TamanhoMascara = campoSoNumeros.length;
                ;

                if (Digitato !== 8) { // backspace 
                    for (i = 0; i <= TamanhoMascara; i++) {
                        boleanoMascara = ((Mascara.charAt(i) === "-") || (Mascara.charAt(i) === ".")
                                || (Mascara.charAt(i) === "/"));
                        boleanoMascara = boleanoMascara || ((Mascara.charAt(i) === "(")
                                || (Mascara.charAt(i) === ")") || (Mascara.charAt(i) === " "));
                        if (boleanoMascara) {
                            NovoValorCampo += Mascara.charAt(i);
                            TamanhoMascara++;
                        } else {
                            NovoValorCampo += campoSoNumeros.charAt(posicaoCampo);
                            posicaoCampo++;
                        }
                    }
                    campo.value = NovoValorCampo;
                    return true;
                } else {
                    return true;
                }
            }
        </script>
    </body>
</html>
