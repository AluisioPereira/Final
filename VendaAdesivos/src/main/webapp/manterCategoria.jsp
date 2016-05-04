<%-- 
    Document   : manterProduto
    Created on : 30/04/2016, 17:41:12
    Author     : Aluísio
--%>

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
                MANUTENÇÃO DE CATEGORIAS
            </div>
            <div class="panel-body">
                <div class="panel panel-default col-lg-12">
                    <div class="panel-heading">
                        <div class="text-left">
                            <span class='aluisio-format_list_numbered'></span>
                            CATEGORIAS
                        </div>
                        <div>
                            <button title="Adicionar categoria" id="MostrarEsconderMensagem" class="btn-success" type="button"><span class="glyphicon glyphicon-plus-sign"></span></button>
                        </div>  
                    </div>
                    <div class="panel-body">               
                        <div id="Mensagem" style="display:none">
                            <form class="form-horizontal" action="" method="post">
                                <fieldset>
                                    <div class="form-group col-lg-4">
                                        <label class="col-md-1 control-label" for="descricao">Descrição</label>  
                                        <div class="col-md-12">
                                            <input id="descricao" name="descricao" type="text" placeholder="nome da categoria" class="form-control input-md">
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-4">
                                        <label class="col-md-1 control-label" for="produto">Produtos</label>
                                        <div class="col-md-12">
                                            <select id="produto" name="produto" class="form-control" multiple="multiple">
                                                <option value="1">produto1</option>
                                                <option value="2">produto2</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-4">
                                        <br>                                        
                                        <label class="col-md-1 control-label" for="btn1"></label>
                                        <div class="col-md-12">
                                            <button id="btn2" name="btn2" class="btn btn-success col-md-8">salvar</button>
                                        </div>
                                    </div>

                                </fieldset>
                            </form>
                        </div>
                        <br>
                        <hr>
                        <form action="" method="post">
                            <table class="shop_table cart table-responsive  col-lg-12" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th class="product-name ">
                                            DESCRIÇÃO
                                        </th>
                                        <th class="product-price ">
                                            PRODUTOS
                                        </th>                              
                                        <th class="product-thumbnail">
                                        </th>
                                        <th class="product-thumbnail">
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="cart_item alt-table-row">
                                        <td class="product-thumbnail">
                                            <p>
                                                descrição
                                            </p>
                                        </td>
                                        <td class="product-price">
                                            <button type="button" id="">
                                                <a href="" class="remove" title="Lista de produtos desta categoria" data-product_id="55" data-product_sku="ads-004">
                                                    <span class="aluisio-format_list_numbered" style="font-size: 22px; color: blue"></span>                                                  
                                                </a>
                                            </button>
                                        </td>
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
                                    </tr>                             
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
