<%-- 
    Document   : manterProduto
    Created on : 30/04/2016, 17:41:12
    Author     : Aluísio
--%>

<%@page import="br.com.lojaadesivo.entidades.Categorias"%>
<%@page import="br.com.lojaadesivo.dao.CategoriaDao"%>
<%@page import="br.com.lojaadesivo.entidades.Adesivos"%>
<%@page import="java.util.List"%>
<%@page import="br.com.lojaadesivo.dao.AdesivoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class="panel-heading">
                <%@include file="/WEB-INF/jspf/menuAdmin.jspf" %>                
            </div>
            <div class="panel-heading">
                MANUTENÇÃO DE PRODUTOS
            </div>
            <div class="panel-body">
                <div class="panel panel-default col-lg-12">
                    <div class="panel-heading">
                        <div class="text-left">
                            <span class='aluisio-format_list_numbered'></span>
                            PRODUTOS
                        </div>
                        <div>
                            <button title="Adicionar produto" id="MostrarEsconderMensagem" class="btn-success" type="button"><span class="glyphicon glyphicon-plus-sign"></span></button>
                        </div>                        
                    </div>
                    <div class="panel-body">               
                        <div id="Mensagem" style="display:none">
                            <form class="form-horizontal">
                                <fieldset>                                    
                                    <div class="form-group col-md-6">
                                        <label class="col-md-1 control-label" for="nome">Nome</label>  
                                        <div class="col-md-12">
                                            <input id="nome" name="nome" type="text" placeholder="nome do produto" class="form-control input-md">
                                        </div>
                                        <label class="col-md-1 control-label" for="categoria">Categoria</label>
                                        <div class="col-md-12">
                                            <select id="categoria" name="categoria" class="form-control" multiple="multiple">
                                                <%--                                                <%
                                                                                                    CategoriaDao categoriadao = new CategoriaDao();
                                                                                                    List<Categorias> categ = categoriadao.listarTodos();
                                                                                                    for (Categorias a : categ) {
                                                                                                        out.print("<option value='" + a.getId() + "'> " + a.getDescricao() + "</option>");
                                                                                                    }
                                                                                                %>
                                                --%>
                                                <option value="1">categoria 1 </option>
                                                <option value="2">categoria 2 </option>
                                            </select>
                                        </div>
                                    </div>

                                    <!-- Select Multiple -->
                                    <div class="form-group col-md-6">
                                        <label class="col-md-5 control-label" for="preco">Preço unitário</label>  
                                        <div class="col-md-8">
                                            <input id="preco" name="preco" type="text" placeholder="preço" class="form-control input-md">
                                        </div>
                                        <label class="col-md-5 control-label" for="quantidade">Qtd. Disponível</label>  
                                        <div class="col-md-8">
                                            <input id="quantidade" name="quantidade" type="text" placeholder="quantidade disponível" class="form-control input-md">
                                        </div>
                                    </div>

                                    <!-- File Button --> 
                                    <div class="form-group col-md-4">
                                        <div class="col-md-12">
                                            Imagem <input id="imagem" name="imagem" class="input-file" type="file">
                                        </div>
                                    </div>

                                    <!-- Button -->
                                    <div class="form-group col-md-12">
                                        <div class="col-md-6"> 
                                            <button id="salvar" name="salvar" class="btn btn-success col-lg-6">salvar</button>
                                        </div>
                                    </div>

                                </fieldset>
                            </form> 
                            <hr>
                        </div>
                        <form action="" method="post">
                            <table class="shop_table cart table-responsive  col-lg-12" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th class="product-name ">
                                            NOME
                                        </th>
                                        <th class="product-price ">
                                            CATEGORIA
                                        </th>
                                        <th class="product-thumbnail">
                                            PREÇO R$:
                                        </th>
                                        <th class="product-thumbnail">
                                            QTD. DISPONÍVEL
                                        </th>                                        
                                        <th class="col-lg-1 col-sm-1">

                                        </th>
                                        <th class="col-lg-1 col-sm-1">

                                        </th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <%                                        AdesivoDao adesivoDao = new AdesivoDao();
                                        List<Adesivos> adesivo = adesivoDao.listarTodos();
                                        for (Adesivos a : adesivo) {
                                            out.print("<tr onclick=\"displayData(" + a.getId() + ")\" >");
                                            out.print("<th>" + a.getNome() + "</th>");
                                            out.print("<th>" + a.getCategoria() + " </th>");
                                            out.print("<th>" + a.getPreco() + "</th>");
                                            out.print("<th>" + a.getQtdDisponivel() + "</th>");
                                    %>
                                <td class="col-lg-1 col-sm-1">
                                    <button type="button" id="MostrarMensagem">
                                        <a href="" title="" data-product_id="55" data-product_sku="ads-004">
                                            <span  type="button" id="MostrarMensagem" title="Editar Categorias" class="aluisio-mode_edit" style="font-size: 22px; color: orange;"></span>
                                        </a>
                                    </button>
                                </td>
                                <td class="col-lg-1 col-sm-1">
                                    <button type="button" id="">
                                        <a href="" class="remove" title="Remover esta categoria" data-product_id="55" data-product_sku="ads-004">
                                            <span class="aluisio-delete_forever" style="font-size: 22px; color: #ff3333 "></span>
                                        </a>
                                    </button>
                                </td>

                                <%
                                        out.print("</tr>");
                                    }

                                %>

                                                            
                                </tbody>
                            </table>
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
            $(document).ready(function () {
                $("#MostrarMensagem").click(MostrarMensagem);
                $("#EsconderMensagem").click(EsconderMensagem);
                $("#MostrarEsconderMensagem").click(MostrarEsconderMensagem);
            });

            function MostrarMensagem() {
                $("#Mensagem").show();
            }
            function EsconderMensagem() {
                $("#Mensagem").hide();
            }
            function MostrarEsconderMensagem() {
                $("#Mensagem").toggle();
            }
        </script>


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
