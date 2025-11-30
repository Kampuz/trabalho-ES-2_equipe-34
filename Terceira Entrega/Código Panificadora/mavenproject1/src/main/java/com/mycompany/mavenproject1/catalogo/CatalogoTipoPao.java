/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.catalogo;

import java.util.ArrayList;

import com.mycompany.mavenproject1.modelo.Receita;
import com.mycompany.mavenproject1.modelo.TipoPao;

/**
 *
 * @author campinho
 */
public class CatalogoTipoPao {
    private ArrayList<TipoPao> tiposPaes;
    
    public CatalogoTipoPao() {
        this.tiposPaes = new ArrayList<>();
    }
    
    public CatalogoTipoPao(ArrayList<TipoPao> tiposPaes) {
        this.tiposPaes = tiposPaes;
    }

    public void adicionarTipoPao(String nome, Receita receita, String CUP, int tempoNecessario) {
        TipoPao novoTipoPao = new TipoPao(nome, receita, CUP, tempoNecessario);
        this.tiposPaes.add(novoTipoPao);
    }

    public Receita getReceita(String nomeTipoPao){
        TipoPao tipoPao = getTipoPaoPorNome(nomeTipoPao);
        if(tipoPao != null) {
            return tipoPao.getReceita();
        }
        return null;
    }
    

    // getters, setters e removers básicos
    public TipoPao getTipoPaoPorNome(String nome) {
        for (TipoPao tipoPao : tiposPaes) {
            if(nome.equals(tipoPao.getNome())) {
                return tipoPao;
            }
        }
        return null;
    }

    public TipoPao getTipoPaoPorCup(String cup) {
        for (TipoPao tipoPao : tiposPaes) {
            if(cup.equals(tipoPao.getNome())) {
                return tipoPao;
            }
        }
        return null;
    }
    
    public ArrayList<TipoPao> getTodosTiposDePao() {
        return tiposPaes;
    }

    public void setTipoPaoPorNome(String nome, int tempoNecessario){
        TipoPao tipoPao = getTipoPaoPorNome(nome);
        tipoPao.setTempoNecessario(tempoNecessario);
    }

    public void setTipoPaoPorCup(String cup, int tempoNecessario) {
        TipoPao tipoPao = getTipoPaoPorCup(cup);
        tipoPao.setTempoNecessario(tempoNecessario);
    }
        
    public void removeTipoPaoPorNome(String nome) {
        TipoPao tipoPao = getTipoPaoPorNome(nome);
        tiposPaes.remove(tipoPao);
    }

    public void removeTipoPaoPorCup(String cup) {
        TipoPao tipoPao = getTipoPaoPorCup(cup);
        tiposPaes.remove(tipoPao);
    }
}
