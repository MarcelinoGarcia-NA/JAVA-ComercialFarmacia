/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Garcia
 */
public class Medicamento {
    private int id;
    private String nome_med;
    private String cod_barras;
    private String fabricante;
    private int quant;
    private double valor_med;
    
    public double getValor_med() {
        return valor_med;
    }

    public void setValor_med(double valor_med) {
        this.valor_med = valor_med;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
    private int classe_med;

    public Medicamento() {
    }


    public Medicamento(int id, String nome_med, String cod_barras, String fabricante,int quant, double valor_med, int classe_med) {
        this.id = id;
        this.nome_med = nome_med;
        this.cod_barras = cod_barras;
        this.fabricante = fabricante;
        this.quant = quant;
        this.valor_med = valor_med;
        this.classe_med = classe_med;
    }

  
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_med() {
        return nome_med;
    }

    public void setNome_med(String nome_med) {
        this.nome_med = nome_med;
    }

    public String getCod_barras() {
        return cod_barras;
    }

    public void setCod_barras(String cod_barras) {
        this.cod_barras = cod_barras;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getClasse_med() {
        return classe_med;
    }

    public void setClasse_med(int classe_med) {
        this.classe_med = classe_med;
    }


}
