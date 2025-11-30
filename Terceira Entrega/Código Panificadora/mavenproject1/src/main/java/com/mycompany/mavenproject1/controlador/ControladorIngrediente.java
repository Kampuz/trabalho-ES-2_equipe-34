/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.controlador;

import java.util.ArrayList;

import com.mycompany.mavenproject1.catalogo.CatalogoIngrediente;
import com.mycompany.mavenproject1.modelo.Ingrediente;
import com.mycompany.mavenproject1.modelo.Receita;

/**
 *
 * @author campinho
 */
public class ControladorIngrediente {
    private CatalogoIngrediente catalogoIngrediente;
    
    public ControladorIngrediente() {
        this.catalogoIngrediente = new CatalogoIngrediente();
    }
    
    public ControladorIngrediente(CatalogoIngrediente catalogoIngrediente) {
        this.catalogoIngrediente = catalogoIngrediente;
    }
    
    public Receita fazerReceita(ArrayList<String> ingredientes, ArrayList<Float> quantiaIngredientes) {
        ArrayList<Ingrediente> ingredientesReceita = new ArrayList<>();
            for (String nomeIngrediente : ingredientes) {
                Ingrediente ingredienteBusca = catalogoIngrediente.getIngredientePorNome(nomeIngrediente);
                if (ingredienteBusca != null) {
                    ingredientesReceita.add(ingredienteBusca);
                }else{
                    throw new IllegalArgumentException("Ingrediente não encontrado!");
                }
            }
        return new Receita(ingredientesReceita, quantiaIngredientes);
    }
    
    public void adicionarIngrediente(String nome, String custoPorQuilo, String CUP) {
        catalogoIngrediente.adicionarIngrediente(nome, custoPorQuilo, CUP);
    }

    public void comprarIngrediente(String nome, float quantiaIngrediente) {
        catalogoIngrediente.comprarIngrediente(nome, quantiaIngrediente);
    }

    public void consumirIngrediente(Receita receita) {
        for (int index = 0; index < receita.getIngredientes().size(); index++) {
            String nome = receita.getIngredientes().get(index).getNome();
            float quantia = receita.getQuantiaIngredientes().get(index);
          catalogoIngrediente.consumirIngrediente(nome, quantia);
        }
    }

    public Ingrediente getIngredientePorNome(String nome) {
        return catalogoIngrediente.getIngredientePorNome(nome);
    }

    public Ingrediente getIngredientePorCUP(String cup) {
        return catalogoIngrediente.getIngredientePorCUP(cup);
    }

    // essa funçao serve pra reotornar os ingredientes já criados, assim é possível selecionar ao criar tipopao
    public ArrayList<String> getTodosNomesIngrediente() {
        ArrayList<String> nomes = new ArrayList<>();
        for (Ingrediente ingrediente : catalogoIngrediente.getIngredientes()) {
            nomes.add(ingrediente.getNome());
        }
        return nomes;
    }  

    public void setIngredientePorNome(String nome, float custo){
        Ingrediente ingrediente = catalogoIngrediente.getIngredientePorNome(nome);
        if (ingrediente != null) {
            this.catalogoIngrediente.setIngredientePorNome(nome, custo);
        }else{
            throw new IllegalArgumentException("Ingrediente não encontrado!");
        }
    }

    public void setIngredientePorCUP(String cup, float custo){
        Ingrediente ingrediente = catalogoIngrediente.getIngredientePorCUP(cup);
        if (ingrediente != null) {
            this.catalogoIngrediente.setIngredientePorCUP(cup, custo);
        }else{
            throw new IllegalArgumentException("Ingrediente não encontrado!");
        }
    }

    // este seria os removes
    public void removerIngrediente(String nomeCup, String tipoInput) {
        if (tipoInput.equals("cup")) {
            catalogoIngrediente.removeIngredientePorCUP(nomeCup);
        } else {
            catalogoIngrediente.removeIngredientePorNome(nomeCup);
        }
    }
}