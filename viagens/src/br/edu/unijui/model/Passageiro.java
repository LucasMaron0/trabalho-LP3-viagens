
package br.edu.unijui.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Passageiro {
    
    private int id;
    private String nome;
    private String passaporte;
    private int idViagem;

    public Passageiro(String nome, String passaporte) {
        this.nome = nome;
        this.passaporte = passaporte;
    }

    public Passageiro(int id, String nome, String passaporte, int idViagem) {
        this.id = id;
        this.nome = nome;
        this.passaporte = passaporte;
        this.idViagem = idViagem;
    }
    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public int getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(int idViagem) {
        this.idViagem = idViagem;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
}

