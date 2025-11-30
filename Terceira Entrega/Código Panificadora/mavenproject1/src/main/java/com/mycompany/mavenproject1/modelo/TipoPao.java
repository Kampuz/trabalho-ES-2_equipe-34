/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.modelo;

/**
 *
 * @author campinho
 */
public class TipoPao {
    private String nome;
    private Receita receita;
    private String CUP;
    private int tempoNecessario;
    private float custoTotal;

    public TipoPao(String nome, Receita receita, String CUP, int tempoNecessario) {
        this.nome = nome;
        this.receita = receita;
        this.CUP = CUP;
        this.tempoNecessario = tempoNecessario;
        this.calcularCusto();   // recebe custoTotal
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public String getCUP() {
        return CUP;
    }

    public void setCUP(String CUP) {
        this.CUP = CUP;
    }

    public int getTempoNecessario() {
        return tempoNecessario;
    }

    public void setTempoNecessario(int tempoNecessario) {
        this.tempoNecessario = tempoNecessario;
    }

    public float getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(float custoTotal) {
        this.custoTotal = custoTotal;
    }
    
    public void calcularCusto() {
        float custo = 0.0f;
        for (int index = 0; index < receita.getIngredientes().size(); index++) {
            custo = custo + (receita.getIngredientes().get(index).getCustoPorQuilo() * receita.getQuantiaIngredientes().get(index));
        }
        this.setCustoTotal(custo);
    }
}


