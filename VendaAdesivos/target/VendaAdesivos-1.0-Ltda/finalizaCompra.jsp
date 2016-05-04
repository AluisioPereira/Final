<%-- 
    Document   : finalizaCompra
    Created on : 30/04/2016, 16:17:26
    Author     : Aluísio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finalizar compra</title>
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
                <div class="panel panel-default col-lg-9">
                    <div class="panel-heading">
                        <div class="panel-heading">
                            <span class='aluisio-shopping_cart' style="font-size: 20px;"></span>
                            CARRINHO
                        </div>
                    </div>
                    <div class="panel-body">
                        <form action="" method="post">
                            <table class="shop_table cart table-responsive  col-lg-12" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th class="product-thumbnail">
                                            &nbsp;Excluir
                                        </th>
                                        <th class="product-name ">
                                            &nbsp; Produto
                                        </th>
                                        <th class="product-price ">
                                            &nbsp; Preço R$
                                        </th>
                                        <th class="product-quantity ">
                                            &nbsp; Quantidade
                                        </th>
                                        <th class="product-subtotal">
                                            &nbsp; Total
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="cart_item alt-table-row">
                                        <td class="product-remove">
                                            <a href="" class="remove" title="Remover este item" data-product_id="55" data-product_sku="ads-004">
                                                <span class="aluisio-delete_forever" style="font-size: 22px;"></span>
                                            </a>
                                        </td>
                                        <td class="product-thumbnail">
                                            <p>
                                                descrição
                                            </p>
                                        </td>
                                        <td class="product-price">
                                            <span class="amount">
                                                2,99
                                            </span>
                                        </td>
                                        <td class="product-quantity">
                                            <div class="quantity">
                                                <input step="1" min="1" max="9" name="qtd" value="1" title="Qtd" class="input-text qty alert-info" size="4" type="number">
                                            </div>
                                        </td>
                                        <td class="product-subtotal"> 
                                            <span class="amount">
                                                R$2,99
                                            </span>
                                        </td>
                                    </tr>                             
                                    <tr>
                                        <td colspan="6" class="actions">
                                            <br>
                                            <hr>

                                            <div class="coupon">
                                                <label for="coupon_code">
                                                    Promoção:
                                                </label>
                                                <input name="coupon_code" class="input-group-sm" id="coupon_code" value="" placeholder="Código do cumpo" type="text"> 
                                                <button id="btn1" name="btn1" class="btn btn-primary">calcular desconto</button>
                                                <button id="btn2" name="btn2" class="btn btn-success">atualizar carrinho</button>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
                <div class="panel panel-default col-lg-3">
                    <div class="panel-heading">
                        <div class="panel-heading">
                            <span class='aluisio-monetization_on' style="font-size: 20px;"></span>
                            TOTAL NO CARRINHO
                        </div>
                    </div>
                    <div class="panel-body">

                        <div class="cart_totals ">
                            <table cellspacing="0">
                                <tbody>
                                    <tr class="cart-subtotal alt-table-row">
                                        <th>Subtotal R$: &nbsp;</th>
                                        <td>
                                            <span class="amount">
                                                2,99
                                            </span>
                                        </td>
                                    </tr>
                                    <tr class="shipping">                                        
                                        <th>
                                            Total R$: &nbsp;
                                        </th>
                                        <td>
                                            <strong>
                                                <span class="amount"> 9,99</span>
                                            </strong>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="wc-proceed-to-checkout">
                                <a href="finalizaCompra.jsp" class="checkout-button button alt wc-forward">
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <button id="butao" name="butao" class="btn btn-primary col-md-12">finalizar compra</button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
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
