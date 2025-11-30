package com.mycompany.mavenproject1.catalogo;

import java.util.ArrayList;

import com.mycompany.mavenproject1.modelo.LotePao;
import com.mycompany.mavenproject1.modelo.LotesVendidos;
import com.mycompany.mavenproject1.modelo.Padeiro;
import com.mycompany.mavenproject1.modelo.TipoPao;

public class CatalogoLotePao {
    private ArrayList<LotePao> lotes;
    private LotesVendidos lotesVendidos;
    private int codigoIncremento;
    
    public CatalogoLotePao() {
        this.lotes = new ArrayList<>();
        this.lotesVendidos = new LotesVendidos();
        this.codigoIncremento = 0;
    }

    public CatalogoLotePao(ArrayList<LotePao> lotes){
        this.lotes = lotes;
        this.codigoIncremento = 0;
    }

    public int fazerLote(float quilosFazer, Padeiro padeiroResponsavel, TipoPao tipoPao){
        // começa com 0 então o primeiro código é 1
        this.codigoIncremento++;
        LotePao novoLote = new LotePao(this.codigoIncremento, quilosFazer, tipoPao, padeiroResponsavel);
        lotes.add(novoLote);
        return this.codigoIncremento;
    }

    public void venderLote(int codigoInt) {
        LotePao loteVendido = null;
        for (LotePao lote : lotes) {
            if (lote.getCodigo() == codigoInt) {
                loteVendido = lote;
                break;
            }
        }

        if (loteVendido != null) {
            lotesVendidos.adicionarLoteVendido(loteVendido);
            lotes.remove(loteVendido);
        } else {
            throw new IllegalArgumentException("Lote não encontrado!");
        }
    }

    // metodo getter de lotepao básico
    public LotePao getLote(int codigo){
        for (LotePao loteV : lotes){
            if (loteV.getCodigo()==codigo){
                return loteV;
            }
        }
        throw new IllegalArgumentException("Lote não encontrado!");
    }

    // pega todos os lotes feitos
    public ArrayList<LotePao> getLotes() {
        return lotes;
    }
}
