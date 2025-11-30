/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.catalogo;

import java.util.ArrayList;

import com.mycompany.mavenproject1.modelo.Padeiro;

/**
 *
 * @author campinho
 */
public class CatalogoPadeiro {
    private ArrayList<Padeiro> padeiros;

    public CatalogoPadeiro() {
        this.padeiros = new ArrayList<>();
    }
    
    public CatalogoPadeiro(ArrayList<Padeiro> padeiros) {
        this.padeiros = padeiros;
    }

    public ArrayList<Padeiro> getPadeiros() {
        return padeiros;
    }

    public void setPadeiros(ArrayList<Padeiro> padeiros) {
        this.padeiros = padeiros;
    }

    // Retorna os nomes de todos os padeiros
    public ArrayList<String> getNomesPadeiros() {
        ArrayList<String> nomes = new ArrayList<>();
        for (Padeiro padeiro : padeiros) {
            nomes.add(padeiro.getNome());
        }
        return nomes;
    }
    
    // só adiciona se o nome e cpf forem diferentes dos padeiros que já foram adicionados
    public void adicionarPadeiro(String nome, String CPF, float salario) {
        
        if (getPadeiroPorCpf(CPF)==null && getPadeiroPorNome(nome)==null) {
            Padeiro novoPadeiro = new Padeiro(nome, CPF, salario);
            padeiros.add(novoPadeiro);
        } else {
            throw new IllegalArgumentException("Padeiro já foi adicionado!");
        }
    }

    public Padeiro getPadeiroPorNome(String nome) {
        for(Padeiro padeiro : padeiros) {
            if(nome.equals(padeiro.getNome())) {
                return padeiro;
            }
        }
        
        return null;
    }
    
    public Padeiro getPadeiroPorCpf(String cpf) {
        for(Padeiro padeiro : padeiros) {
            if(cpf.equals(padeiro.getCPF())) {
                return padeiro;
            }
        }
        
        return null;
    }

    public void setSalarioPorNome(String nomePadeiro, float salario){
        Padeiro padeiro = getPadeiroPorNome(nomePadeiro);
        padeiro.setSalario(salario);
    }

    public void setSalarioPorCpf(String cpf, float salario){
        Padeiro padeiro = getPadeiroPorCpf(cpf);
        padeiro.setSalario(salario);
    }

    public void removePadeiroPorNome(String nome) {
        Padeiro padeiro = getPadeiroPorNome(nome);
        padeiros.remove(padeiro);
    }
    
    public void removePadeiroPorCpf(String cpf) {
        Padeiro padeiro = getPadeiroPorCpf(cpf);
        padeiros.remove(padeiro);
    }
}
