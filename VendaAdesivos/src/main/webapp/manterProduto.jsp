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
                MANUTENÇÃO DE PRODUTOS
            </div>
            <div class="panel-body">
                <div class="panel panel-default col-lg-12">
                    <div class="panel-heading">
                        <div class="text-left">
                            <span class='aluisio-format_list_numbered'></span>
                            PRODUTOS
                        </div>
                        <div class="text-right">                            
                            <a href="" title="" data-product_id="55" data-product_sku="ads-004">
                                <span title="Adicionar produtos" class="aluisio-add_circle" style="font-size: 22px;"></span>
                            </a>
                        </div>
                    </div>
                    <div class="panel-body">
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
                                    <tr class="cart_item alt-table-row">
                                        <td class="product-thumbnail">
                                            <p>
                                                nome
                                            </p>
                                        </td>
                                        <td class="product-thumbnail">
                                            <p>
                                                categoria
                                            </p>
                                        </td>
                                        <td class="product-thumbnail">
                                            <p>
                                                2,50
                                            </p>
                                        </td>
                                        <td class="product-price">
                                            <p>
                                                10
                                            </p>
                                        </td>

                                        <td class="col-lg-1 col-sm-1">
                                            <a href="" class="remove" title="Editar este produto" data-product_id="55" data-product_sku="ads-004">
                                                <span class="aluisio-mode_edit" style="font-size: 22px;"></span>
                                            </a>
                                        </td>
                                        <td class="col-lg-1 col-sm-1">
                                            <a href="" class="remove" title="Remover este produto" data-product_id="55" data-product_sku="ads-004">
                                                <span class="aluisio-delete_forever" style="font-size: 22px;"></span>
                                            </a>
                                        </td>

                                    </tr>                             

                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>

        </div>

        <script src="acessor/js/jquery-2.1.4.min.js"></script>
        <script src="acessor/js/bootstrap.min.js"></script>
        
    </body>
</html>
