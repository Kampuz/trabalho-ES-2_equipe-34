/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.modelo;

/**
 *
 * @author campinho
 */

public class Gas {
    private float precoRecipiente;
    private float peso;
    private float tempoRestante;

    public Gas(float peso, float precoRecipiente, float tempoRestante) {
        this.peso = peso;
        this.precoRecipiente = precoRecipiente;
        this.tempoRestante = tempoRestante;
    }

    public float getPrecoRecipiente() {
        return precoRecipiente;
    }

    public void setPrecoRecipiente(float precoRecipiente) {
        this.precoRecipiente = precoRecipiente;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getTempoRestante() {
        return tempoRestante;
    }

    public void setTempoRestante(float tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

    public void consumirGas(float minutosGastos){
        this.tempoRestante = this.tempoRestante - minutosGastos;
        if(this.tempoRestante < 0){
            this.tempoRestante = 0;
        }
    }

    public void reabastecerGas(){
        this.tempoRestante = this.tempoRestante + 750; //suporta 750 minutos de consumo
    }
    
}
