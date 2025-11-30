/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.modelo;

/**
 *
 * @author campinho
 */
public class LotePao {
    private int codigo;
    private float quilosPao;
    private TipoPao tipoPao;
    private Padeiro padeiroResponsavel;
    
    public LotePao(int codigo, float quilosPao, TipoPao tipoPao, Padeiro padeiroResponsavel) {
        this.codigo = codigo;
        this.quilosPao = quilosPao;
        this.tipoPao = tipoPao;
        this.padeiroResponsavel = padeiroResponsavel;  
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getQuilosPao() {
        return quilosPao;
    }

    public void setQuilosPao(float quilosPao) {
        this.quilosPao = quilosPao;
    }

    public TipoPao getTipoPao() {
        return tipoPao;
    }

    public void setTipoPao(TipoPao tipoPao) {
        this.tipoPao = tipoPao;
    }

    public Padeiro getPadeiroResponsavel() {
        return padeiroResponsavel;
    }

    public void setPadeiroResponsavel(Padeiro padeiroResponsavel) {
        this.padeiroResponsavel = padeiroResponsavel;
    }
}
