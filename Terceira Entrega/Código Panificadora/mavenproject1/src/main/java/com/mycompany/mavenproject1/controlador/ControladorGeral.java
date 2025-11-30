/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.controlador;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.mavenproject1.modelo.Gas;
import com.mycompany.mavenproject1.modelo.Ingrediente;
import com.mycompany.mavenproject1.modelo.LotePao;
import com.mycompany.mavenproject1.modelo.Padeiro;
import com.mycompany.mavenproject1.modelo.Receita;
import com.mycompany.mavenproject1.modelo.Registro;
import com.mycompany.mavenproject1.modelo.TipoPao;

/**
 *
 * @author campinho
 */
public class ControladorGeral {
    private ControladorPadeiro controladorPadeiro;
    private ControladorLotePao controladorLotePao;
    private ControladorTipoPao controladorTipoPao;
    private ControladorIngrediente controladorIngrediente;
    private Gas gas;
    private Registro registro;

    public ControladorGeral() {
        this.controladorPadeiro = new ControladorPadeiro();
        this.controladorLotePao = new ControladorLotePao();
        this.controladorTipoPao = new ControladorTipoPao();
        this.controladorIngrediente = new ControladorIngrediente();
        this.gas = new Gas(0, 0, 0);
        this.registro = new Registro(0, 0);
    }
    
    public ControladorGeral(
        ControladorPadeiro controladorPadeiro, ControladorLotePao controladorLotePao, 
        ControladorTipoPao controladorTipoPao, ControladorIngrediente controladorIngrediente, 
        Gas gas, Registro registro) 
    {
        this.controladorPadeiro = controladorPadeiro;
        this.controladorLotePao = controladorLotePao;
        this.controladorTipoPao = controladorTipoPao;
        this.controladorIngrediente = controladorIngrediente;
        this.gas = gas;
        this.registro = registro;
    }

    //  **************** Funções do TipoPao ****************
    public void adicionarTipoPao(String nome, String CUP, String tempoNecessario, ArrayList<String> ingredientes, ArrayList<Float> quantiaIngredientes) {
        int tempoNecessarioInt = Integer.parseInt(tempoNecessario);
        Receita novaReceita = this.fazerReceita(ingredientes, quantiaIngredientes);
        controladorTipoPao.adicionarTipoPao(nome, novaReceita, CUP, tempoNecessarioInt);
    }
    
    public void removerTipoPao(String nomeCup) {
        String tipoInput;
        if (ehCup(nomeCup)) {
            tipoInput = "cup";
        } else {
            tipoInput = "nome";
        }
        controladorTipoPao.removerTipoPao(nomeCup, tipoInput);
    }

    public TipoPao getTipoPaoPorNome(String nome) {
        return controladorTipoPao.getTipoPaoPorNome(nome);
    }

    public ArrayList<TipoPao> getTodosTiposDePao() {
        return controladorTipoPao.getTodosTiposDePao();
    }

    //  ******************* Funções do LotePao *******************
    public int fazerLote(String nomeTipoPao, String quilosFazer, String nomePadeiro, String consumoGas){
        //chama ControladorTipoPao
        TipoPao tipo = controladorTipoPao.getTipoPaoPorNome(nomeTipoPao);
        registro.adicionarGastos(tipo.getCustoTotal());

        //chama Gas e Registro
        float consumoFloat = Float.parseFloat(consumoGas);
        if(consumoFloat < gas.getTempoRestante() && consumoFloat < 750){
            gas.consumirGas(consumoFloat);
        }else{
            registro.adicionarGastos(gas.getPrecoRecipiente());
            gas.reabastecerGas();
            gas.consumirGas(consumoFloat);
        }
        //chama ControladorIngrediente
        controladorIngrediente.consumirIngrediente(tipo.getReceita());
        //chama ControladorPadeiro (será possível colocar Salario como gasto dentro do registro)
        Padeiro padeiro = controladorPadeiro.getPadeiroPorNome(nomePadeiro);
        //chama ControladorLotePao
        float quilosFloat = Float.parseFloat(quilosFazer);
        int codigo = controladorLotePao.fazerLote(quilosFloat, padeiro, tipo);
        //retorna o codigo do lote
        return codigo;  //-- por algum motivo funciona
    }

    public void venderLote(String codigo, String preco){
        int codigoInt = Integer.parseInt(codigo);
        float precoFloat = Float.parseFloat(preco);
        controladorLotePao.venderLote(codigoInt);
        registro.adicionarGanhos(precoFloat);
    }

    // Método para obter todos os lotes de pão
    public List<LotePao> getTodosLotes() {
        return controladorLotePao.getCatalogoLotePao().getLotes(); // Aqui estamos pegando os lotes diretamente do CatalogoLotePao
    }
    


    // **************** Funções de Ingredientes/Receita ****************
    
    public Receita fazerReceita(ArrayList<String> ingredientes, ArrayList<Float> quantiaIngredientes) {
        if (ingredientes.size() != quantiaIngredientes.size()) {
            throw new IllegalArgumentException("Há diferença de tamanho entre ingredientes e quantidades!");
        }
        ArrayList<Ingrediente> ingredientesReceita = new ArrayList<>();
        for (int i = 0; i < ingredientes.size(); i++) {
            String nomeIngrediente = ingredientes.get(i);
            Ingrediente ingrediente = controladorIngrediente.getIngredientePorNome(nomeIngrediente);
            
            if (ingrediente != null) {
                ingredientesReceita.add(ingrediente);
            } else {
                throw new IllegalArgumentException("Ingrediente não encontrado: " + nomeIngrediente);
            }
        }
        return new Receita(ingredientesReceita, quantiaIngredientes);
    }


    public void adicionarIngrediente(String nome, String custoPorQuilo, String CUP) {
        controladorIngrediente.adicionarIngrediente(nome, custoPorQuilo, CUP);
    }

    public void comprarIngrediente(String nome, String quantiaIngrediente) {
        this.registro.adicionarGastos(Float.parseFloat(quantiaIngrediente) * controladorIngrediente.getIngredientePorNome(nome).getCustoPorQuilo());
        controladorIngrediente.comprarIngrediente(nome, Float.parseFloat(quantiaIngrediente));
    }

    public ArrayList<String> getTodosNomesIngrediente() {
        return controladorIngrediente.getTodosNomesIngrediente();
    }

    
    // ****************Funções do Padeiro****************

    public void adicionarPadeiro(String nome, String cpf, String salario) {
         if (!cpfValido(cpf)) {
            throw new IllegalArgumentException("CPF inválido!");
        }
         
        controladorPadeiro.adicionarPadeiro(nome, cpf, salario);
    }
    
    public void atualizarSalario(String cpfOuNome, String novoSalario) {
        float salarioFloat = Float.parseFloat(novoSalario);
        if(salarioFloat < 0){
            throw new IllegalArgumentException("Salário não pode ser negativo!");
        }
        else{
            if (cpfValido(cpfOuNome)) {
            controladorPadeiro.setPadeiroSalarioPorCpf(cpfOuNome, salarioFloat);
            } else {
            controladorPadeiro.setPadeiroSalarioPorNome(cpfOuNome, salarioFloat);
            }
        }
    }
    
    public void removePadeiro(String cpfOuNome) {
        if (cpfValido(cpfOuNome)) {
            controladorPadeiro.removePadeiroPorCpf(cpfOuNome);
        } else {
            controladorPadeiro.removePadeiroPorNome(cpfOuNome);
        }
    }

    public List<String> getNomesPadeiros() {
        return controladorPadeiro.getNomesPadeiros();
    }
    
    private boolean cpfValido(String cpf) {
        
        cpf = cpf.replaceAll("\\D", "");
        
        if (cpf.length() != 11) return false;
        
        if (cpf.matches("(\\d)\\1{10}")) return false;
        
        try {
            int soma = 0;
            
            for (int i = 0; i < 9; i ++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            
            int primeiroDigito = 11 - (soma % 11);
            if (primeiroDigito >= 10) primeiroDigito = 0;
            
            soma = 0;
            
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            
            int segundoDigito = 11 - (soma % 11);
            if (segundoDigito >= 10) segundoDigito = 0;
            
            return primeiroDigito == Character.getNumericValue(cpf.charAt(9)) &&
                    segundoDigito == Character.getNumericValue(cpf.charAt(10));
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean ehCup(String nomeCup) {
        return nomeCup.matches("\\d+");
    }


    // getters, setters e removers básicos

    // Ingredientes
    public Ingrediente getIngredientePorNome(String nome) {
        return controladorIngrediente.getIngredientePorNome(nome);
    }

    public Ingrediente getIngredientePorCUP(String cup) {
        return controladorIngrediente.getIngredientePorCUP(cup);
    }

    public void setIngredientePorNome(String nome, float custo){
        controladorIngrediente.setIngredientePorNome(nome, custo);
    }

    public void setIngredientePorCUP(String cup, float custo){
        controladorIngrediente.setIngredientePorCUP(cup, custo);
    }

    public void removerIngrediente(String nomeCup) {
        String tipoInput;
        if (ehCup(nomeCup)) {
            tipoInput = "cup";
        } else {
            tipoInput = "nome";
        }
        controladorIngrediente.removerIngrediente(nomeCup, tipoInput);
    }
}
