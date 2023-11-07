/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Viagem {
    
    private int id;
    @JacksonXmlElementWrapper(localName = "Passageiros")
    @JacksonXmlProperty(localName = "Passageiro")
    private List<Passageiro>  listaPassageiros;
    private Aviao aviao;
    private String origem;
    private String destino;
    private Date data;
    private int totalPassageiros;

    public Viagem(int id, List<Passageiro> listaPassageiros, Aviao aviao, String origem, String destino, Date data, int totalPassageiros) {
        this.id = id;
        this.listaPassageiros = listaPassageiros;
        this.aviao = aviao;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.totalPassageiros = totalPassageiros;
    }
   public Viagem(Aviao aviao, String origem, String destino, String data) throws ParseException {
        this.aviao = aviao;
        this.origem = origem;
        this.destino = destino;
        
         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.data = format.parse(data);
    }
       

    public List<Passageiro> getListaPassageiros() {
        return listaPassageiros;
    }

    public void setListaPassageiros(List<Passageiro> listaPassageiros) {
        this.listaPassageiros = listaPassageiros;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getTotalPassageiros() {
        return totalPassageiros;
    }

    public void setTotalPassageiros(int totalPassageiros) {
        this.totalPassageiros = totalPassageiros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }
    
       
    @Override
    public String toString() {
        return this.origem + " - " + this.destino;
    }
    
}
