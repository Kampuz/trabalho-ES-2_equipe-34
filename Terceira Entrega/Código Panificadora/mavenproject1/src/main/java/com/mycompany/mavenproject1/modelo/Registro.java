package com.mycompany.mavenproject1.modelo;

public class Registro {
    private float ganhos;
    private float gastos;

    public Registro(float ganhos, float gastos){
        this.ganhos = ganhos;
        this.gastos = gastos;
    }

    public void adicionarGanhos(float ganhos){
        this.ganhos = this.ganhos + ganhos;
    }

    public void adicionarGastos(float gastos){
        this.gastos = this.gastos + gastos;
    }

    public float getGanhos() {
        return ganhos;
    }

    public void setGanhos(float ganhos) {
        this.ganhos = ganhos;
    }

    public float getGastos() {
        return gastos;
    }

    public void setGastos(float gastos) {
        this.gastos = gastos;
    }
}
