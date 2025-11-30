/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.modelo;

import java.util.ArrayList;

/**
 *
 * @author campinho
 */
public class Receita {
    private ArrayList<Ingrediente> ingredientes;
    private ArrayList<Float> quantiaIngredientes;

    public Receita(ArrayList<Ingrediente> ingredientes, ArrayList<Float> quantiaIngredientes) {
        this.ingredientes = ingredientes;
        this.quantiaIngredientes = quantiaIngredientes;
    }


    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public ArrayList<Float> getQuantiaIngredientes() {
        return quantiaIngredientes;
    }

    public void setQuantiaIngredientes(ArrayList<Float> quantiaIngredientes) {
        this.quantiaIngredientes = quantiaIngredientes;
    }
       
}
