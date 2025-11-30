/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.controlador;

import java.util.List;

import com.mycompany.mavenproject1.catalogo.CatalogoPadeiro;
import com.mycompany.mavenproject1.modelo.Padeiro;

/**
 *
 * @author campinho
 */
public class ControladorPadeiro {
    private CatalogoPadeiro catalogoPadeiro;
    
    public ControladorPadeiro() {
        this.catalogoPadeiro = new CatalogoPadeiro();
    }
    public ControladorPadeiro(CatalogoPadeiro catalogoPadeiro) {
        this.catalogoPadeiro = catalogoPadeiro;
    }
    
    public void adicionarPadeiro(String nome, String CPF, String salario) {
        float salarioFloat = Float.parseFloat(salario);
        catalogoPadeiro.adicionarPadeiro(nome, CPF, salarioFloat);
    }
    
    public Padeiro getPadeiroPorNome(String nome) {
        return catalogoPadeiro.getPadeiroPorNome(nome);
    }

    public Padeiro getPadeiroPorCpf(String cpf) {
        return catalogoPadeiro.getPadeiroPorCpf(cpf);
    }

    public List<String> getNomesPadeiros() {
        return catalogoPadeiro.getNomesPadeiros();
    }


    public void setPadeiroSalarioPorNome(String nome, float salario){
        Padeiro padeiro = catalogoPadeiro.getPadeiroPorNome(nome);
        if (padeiro != null) {
            this.catalogoPadeiro.setSalarioPorNome(nome, salario);
        }else{
            throw new IllegalArgumentException("Padeiro não encontrado!");
        }
    }

    public void setPadeiroSalarioPorCpf(String cpf, float salario){
        Padeiro padeiro = catalogoPadeiro.getPadeiroPorCpf(cpf);
        if (padeiro != null) {
            this.catalogoPadeiro.setSalarioPorCpf(cpf, salario);
        } else {
            throw new IllegalArgumentException("Padeiro não encontrado!");
        }
    }
    
    public void removePadeiroPorCpf(String cpf) {      
         
        Padeiro padeiro = catalogoPadeiro.getPadeiroPorCpf(cpf);
         
         if (padeiro == null) {
             throw new IllegalArgumentException("Padeiro não encontrado!");
         }
         
         catalogoPadeiro.removePadeiroPorCpf(cpf);
    }

    public void removePadeiroPorNome(String nome) {      
         
        Padeiro padeiro = catalogoPadeiro.getPadeiroPorNome(nome);
         
         if (padeiro == null) {
             throw new IllegalArgumentException("Padeiro não encontrado!");
         }
         
         catalogoPadeiro.removePadeiroPorNome(nome);
    }
}