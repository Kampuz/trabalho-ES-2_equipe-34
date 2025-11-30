/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.controlador;

import java.util.ArrayList;

import com.mycompany.mavenproject1.catalogo.CatalogoTipoPao;
import com.mycompany.mavenproject1.modelo.Receita;
import com.mycompany.mavenproject1.modelo.TipoPao;
/**
 *
 * @author campinho
 */
public class ControladorTipoPao {
    private CatalogoTipoPao catalogoTipoPao;
    
    public ControladorTipoPao() {
        this.catalogoTipoPao = new CatalogoTipoPao();
    }
    
    public ControladorTipoPao(CatalogoTipoPao catalogoTipoPao) {
        this.catalogoTipoPao = catalogoTipoPao;
    }
    
    public void adicionarTipoPao(String nome, Receita receita,  String CUP, int tempoNecessario) {
        catalogoTipoPao.adicionarTipoPao(nome, receita, CUP, tempoNecessario);
    }

    public Receita getReceita(String nomeTipoPao){
        return catalogoTipoPao.getReceita(nomeTipoPao);
    }
    
    public TipoPao getTipoPaoPorNome(String nome) {
        return catalogoTipoPao.getTipoPaoPorNome(nome);
    }
    
    public TipoPao getTipoPaoPorCup(String cup) {
        return catalogoTipoPao.getTipoPaoPorCup(cup);
    }
    
    public ArrayList<TipoPao> getTodosTiposDePao() {
        return catalogoTipoPao.getTodosTiposDePao();
    }
    
    public void removerTipoPao(String nomeCup, String tipoInput) {
        if (tipoInput.equals("cup")) {
            catalogoTipoPao.removeTipoPaoPorCup(nomeCup);
        } else {
            catalogoTipoPao.removeTipoPaoPorNome(nomeCup);
        }
    }

}
