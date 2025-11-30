package com.mycompany.mavenproject1.controlador;

import com.mycompany.mavenproject1.catalogo.CatalogoLotePao;
import com.mycompany.mavenproject1.modelo.LotePao;
import com.mycompany.mavenproject1.modelo.Padeiro;
import com.mycompany.mavenproject1.modelo.TipoPao;

public class ControladorLotePao {
    private CatalogoLotePao catalogoLotePao;

    public ControladorLotePao() {
        this.catalogoLotePao = new CatalogoLotePao();
    }
    
    public ControladorLotePao(CatalogoLotePao catalogoLotePao) {
        this.catalogoLotePao = catalogoLotePao;
    }
    
    public int fazerLote(float quilosFazer, Padeiro padeiroResponsavel, TipoPao tipoPao){
        return catalogoLotePao.fazerLote(quilosFazer, padeiroResponsavel, tipoPao);
    }

    public void venderLote(int codigoInt){
        catalogoLotePao.venderLote(codigoInt);
    }

    public CatalogoLotePao getCatalogoLotePao(){
        return catalogoLotePao;
    }

    public LotePao getLote(int codigo){
        return catalogoLotePao.getLote(codigo);
    }
}
