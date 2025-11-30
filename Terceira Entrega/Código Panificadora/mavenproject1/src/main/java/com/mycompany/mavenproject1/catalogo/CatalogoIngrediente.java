/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.catalogo;

import java.util.ArrayList;

import com.mycompany.mavenproject1.modelo.Ingrediente;

/**
 *
 * @author campinho
 */
public class CatalogoIngrediente {
    private ArrayList<Ingrediente> ingredientes;

    public CatalogoIngrediente() {
        this.ingredientes = new ArrayList<>();
    }
    
    public CatalogoIngrediente(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }   

    public void adicionarIngrediente(String nome, String custoPorQuilo, String CUP) {
        Ingrediente ingrediente = getIngredientePorNome(nome);
            if (ingrediente != null) {
                ingrediente.setQuantidadeEstoque(ingrediente.getQuantidadeEstoque() + 100f);//valor arbitrario para compra inicial
                return;
        }
        
        float custoPorQuiloFloat = Float.parseFloat(custoPorQuilo);
        
        Ingrediente novoIngrediente = new Ingrediente(nome, custoPorQuiloFloat, 100f, CUP);
        
        ingredientes.add(novoIngrediente);
    }

    public void comprarIngrediente(String nome, float quantiaIngrediente) {
        Ingrediente ingrediente = getIngredientePorNome(nome);
            if (ingrediente != null) {
                ingrediente.comprarIngrediente(quantiaIngrediente); // gasto já foi aplicado antes baseado nos diagramas
            }else{
                throw new IllegalArgumentException("Ingrediente não encontrado!");
            }
    }
    
    public void consumirIngrediente(String nome, float quantia) {
        Ingrediente ingrediente = getIngredientePorNome(nome);
            if (ingrediente != null) {
               ingrediente.consumirIngrediente(quantia);
            }else{
                throw new IllegalArgumentException("Ingrediente não encontrado!");
            }
    }

    public Ingrediente getIngredientePorNome(String nome) {
        for(Ingrediente ingrediente : ingredientes) {
            if(nome.equals(ingrediente.getNome())) {
                return ingrediente;
            }
        }
        return null;
    }

    public Ingrediente getIngredientePorCUP(String CUP) {
        for(Ingrediente ingrediente : ingredientes) {
            if(CUP.equals(ingrediente.getCUP())) {
                return ingrediente;
            }
        }
        return null;
    }
    
    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientePorNome(String nome, float custoPorQuilo){
        Ingrediente ingrediente = getIngredientePorNome(nome);
        ingrediente.setCustoPorQuilo(custoPorQuilo);
    }

    public void setIngredientePorCUP(String CUP, float custoPorQuilo){
        Ingrediente ingrediente = getIngredientePorCUP(CUP);
        ingrediente.setCustoPorQuilo(custoPorQuilo);
    }

    public void removeIngredientePorNome(String nome) {
        Ingrediente ingrediente = getIngredientePorNome(nome);
        ingredientes.remove(ingrediente);
    }

    public void removeIngredientePorCUP(String CUP) {
        Ingrediente ingrediente = getIngredientePorCUP(CUP);
        ingredientes.remove(ingrediente);
    }

}
