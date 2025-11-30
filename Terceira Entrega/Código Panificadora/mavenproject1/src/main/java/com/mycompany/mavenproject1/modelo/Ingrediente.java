/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.modelo;

/**
 *
 * @author campinho
 */
public class Ingrediente {
    private String nome;
    private float custoPorQuilo; // em reais
    private float quantidadeEstoque; // em quilos
    private String CUP;
    
    public Ingrediente(String nome, float custoPorQuilo, float quantidadeEstoque,  String CUP) {
        this.nome = nome;
        this.custoPorQuilo = custoPorQuilo;
        this.quantidadeEstoque = quantidadeEstoque;
        this.CUP = CUP;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getCustoPorQuilo() {
        return custoPorQuilo;
    }

    public void setCustoPorQuilo(float custoPorQuilo) {
        this.custoPorQuilo = custoPorQuilo;
    }

    public float getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(float quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCUP() {
        return CUP;
    }

    public void setCUP(String CUP) {
        this.CUP = CUP;
    }

    public void comprarIngrediente(float quantia){
        this.quantidadeEstoque = this.quantidadeEstoque + quantia;
    }

    public void consumirIngrediente(float quantia){
        if(quantidadeEstoque >= quantia) {
            this.quantidadeEstoque = this.quantidadeEstoque - quantia;
        } else {
            throw new IllegalArgumentException("Quantidade insuficiente em estoque!");
        }
    }
}
