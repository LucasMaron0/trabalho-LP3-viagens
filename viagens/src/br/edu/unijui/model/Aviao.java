/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Aviao {
    
    private int id;
    private String modelo;
    private String empresa;
    private boolean emViagem;

    public Aviao(int id, String modelo, String empresa, boolean emViagem) {
        this.id = id;
        this.modelo = modelo;
        this.empresa = empresa;
        this.emViagem = emViagem;
    }
    public Aviao( String modelo, String empresa) {
        this.modelo = modelo;
        this.empresa = empresa;
        this.emViagem = false;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public boolean isEmViagem() {
        return emViagem;
    }

    public void setEmViagem(boolean emViagem) {
        this.emViagem = emViagem;
    }
    
    @Override
    public String toString() {
        return this.modelo;
    }
}


