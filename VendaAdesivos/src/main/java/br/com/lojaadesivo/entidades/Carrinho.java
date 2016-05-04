/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaadesivo.entidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Aluísio
 */
public class Carrinho {

    private int id;
    private List<ItemCompra> itens;
    private double total;
    private int qtdproduto;

    /**
     * Método adiciona um determinado item no carrinho
     * @param addItem
     */
    public void addItem(ItemCompra addItem) {
        if (this.itens == null) {
            this.itens = new ArrayList<>();
        } else {
            this.itens.add(addItem);
        }
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @return 
     */
    public int getQtdproduto() {
        return qtdproduto;
    }

    /**
     * Método set altera dado atributo da classe
     * @param qtdproduto
     */
    public void setQtdproduto(int qtdproduto) {
        this.qtdproduto = qtdproduto;
    }

    /**
     * Método set altera dado atributo da classe
     */
    public void setQtdprodutos() {
        this.qtdproduto = this.itens.size();
    }

    /**
     * Método remove um item do carrinho
     * @param removItem
     */
    public void removerItem(ItemCompra removItem) {
        for (Iterator i = itens.iterator(); i.hasNext();) {
            ItemCompra item = (ItemCompra) i.next();
            if (item.getAdesivo().getId() == removItem.getAdesivo().getId()) {
                i.remove();
            }
        }
    }

    /**
     * Método calcula o total final precesnte no carrinho
     * @return 
     */
    public double calcularTotal() {
        double vTotal = 0;
        vTotal = this.itens.stream().map((item) -> item.getTotal()).reduce(vTotal, (accumulator, _item) -> accumulator + _item);
        this.total = vTotal;
        return total;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Método set altera dado atributo da classe
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método set altera dado atributo da classe
     * @param itens
     */
    public void setItens(List<ItemCompra> itens) {
        this.itens = itens;
    }

    /**
     * Método set altera dado atributo da classe
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @return 
     */
    public List<ItemCompra> getItens() {
        return itens;
    }

    /**
     * Método get busca dado atributo da classe a ser retornado
     * @return 
     */
    public double getTotal() {
        return total;
    }
}
