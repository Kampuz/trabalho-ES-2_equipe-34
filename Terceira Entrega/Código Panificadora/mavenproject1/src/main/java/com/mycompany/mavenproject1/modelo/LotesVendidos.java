package com.mycompany.mavenproject1.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class LotesVendidos {
    private ArrayList<LotePao> lotes;
    private ArrayList<LocalDate> datasVenda;

    public LotesVendidos(ArrayList<LotePao> lotes, ArrayList<LocalDate> datasVenda) {
        this.lotes = lotes;
        this.datasVenda = datasVenda;
    }

    public LotesVendidos(){
        this.lotes = new ArrayList<>();
        this.datasVenda = new ArrayList<>();
    }

    public ArrayList<LotePao> getLotes(){
        return lotes;
    }
    
    public void setLotes(ArrayList<LotePao> lotes){
        this.lotes = lotes; 
    }

    public ArrayList<LocalDate> getDatasVenda(){
        return datasVenda;
    }

    public void setDatasVenda(ArrayList<LocalDate> datasVenda){
        this.datasVenda = datasVenda;
    }

    public void adicionarLoteVendido(LotePao lote){
        lotes.add(lote);
        datasVenda.add(LocalDate.now());
    }
}