/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.dao;

import br.edu.unijui.dataBase.DataBase;
import br.edu.unijui.model.Aviao;
import br.edu.unijui.model.Passageiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PassageiroImpl implements PassageiroDAO{
    
    private final Connection con;
    
    public PassageiroImpl() throws ClassNotFoundException, SQLException {
       con = new DataBase().getConnection();
    }

    @Override
    public boolean inserirPassageiro(Passageiro passageiro) {
   
        PreparedStatement pstmtInserir;
         
        try {
   
           pstmtInserir = con.prepareStatement(""
         + "insert into passageiro (nome, passaporte)" 
         + "values (?, ?)");
            
            pstmtInserir.setString(1, passageiro.getNome());
            pstmtInserir.setString  (2, passageiro.getPassaporte());
            return pstmtInserir.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AviaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Passageiro> getAllPassageiros() {
        
       PreparedStatement pstmtListar;
       List<Passageiro> listaPassageiros = new ArrayList<>();
    
        try{     
         pstmtListar = con.prepareStatement("select * from passageiro");   
         ResultSet resultSet = pstmtListar.executeQuery();
         ResultSetMetaData metaData = resultSet.getMetaData();
         listaPassageiros = parseLista(resultSet);
         resultSet.close();
                 
        }catch (SQLException ex) {
        
        }
    return listaPassageiros;
    }
    
    public static List<Passageiro> parseLista(ResultSet rst) throws SQLException {
        List<Passageiro> passageiros = new ArrayList<>();
        while (rst.next()) {
            passageiros.add(new Passageiro(
                    rst.getInt("id"),
                    rst.getString("nome"),
                    rst.getString("passaporte"),
                    rst.getInt("idViagem")
            ));
        }
        return passageiros;
}

    public  List<Passageiro> buscarPassageirosNaViagem(int idViagem) throws SQLException{

        List<Passageiro> passageirosNaViagem = new ArrayList<>();
        List<Passageiro> listPassageiros = getAllPassageiros();

        for(Passageiro p: listPassageiros){
            if(p.getIdViagem() == idViagem){
                passageirosNaViagem.add(p);
            }
        }
        return passageirosNaViagem;
    }

    @Override
    public boolean updatePassageiro(Passageiro passageiro) {
        
        PreparedStatement pstmtAtualizar;
         
        try {
   
           pstmtAtualizar = con.prepareStatement(""
         + "update passageiro set nome = ?, passaporte = ?, idViagem = ?  where id = ?");
            
            pstmtAtualizar.setString(1, passageiro.getNome());
            pstmtAtualizar.setString(2, passageiro.getPassaporte());
            pstmtAtualizar.setInt(3, passageiro.getIdViagem());
            pstmtAtualizar.setInt(4, passageiro.getId());
            return pstmtAtualizar.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AviaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
