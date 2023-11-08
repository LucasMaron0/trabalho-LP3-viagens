/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.dao;

import br.edu.unijui.dataBase.DataBase;
import br.edu.unijui.model.Aviao;
import br.edu.unijui.model.Passageiro;
import br.edu.unijui.utils.LoggerUtils;
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
    private final LoggerUtils loggerUtils;
    
    
    public PassageiroImpl() throws ClassNotFoundException, SQLException {
       con = new DataBase().getConnection();
       loggerUtils = LoggerUtils.getLoggerUtils();
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
           
            boolean sucesso = pstmtInserir.execute();
            if(sucesso){
                 loggerUtils.logMessage("Sucesso ao inserir passageiro");
            }else{
                loggerUtils.logMessage("Erro ao inserir passageiro");
            }
            return sucesso;
            
        } catch (SQLException ex) {
            loggerUtils.logMessage("Erro ao inserir passageiro - " +  ex.getMessage());
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
             loggerUtils.logMessage("Sucesso ao buscar passageiros");

        }catch (SQLException ex) {
             loggerUtils.logMessage("Erro ao buscar lista com todos os passageiros - " +  ex.getMessage());
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

       PreparedStatement pstmtListar;
       List<Passageiro> listaPassageiros = new ArrayList<>();
    
        try{     
            pstmtListar = con.prepareStatement("select * from passageiro where idViagem = ? ");   
            pstmtListar.setInt(1, idViagem);
            ResultSet resultSet = pstmtListar.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            listaPassageiros = parseLista(resultSet);
            resultSet.close();
             loggerUtils.logMessage("Sucesso ao buscar passageiros na viagem " +  idViagem);

        }catch (SQLException ex) {
             loggerUtils.logMessage("Erro ao buscar lista com todos os passageiros na viagem " + idViagem + " " +  ex.getMessage());
        }
        
        return listaPassageiros;
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
           
            boolean sucesso = pstmtAtualizar.execute();
            if(sucesso){
                 loggerUtils.logMessage("Sucesso ao atualizar passageiro");
            }else{
                loggerUtils.logMessage("Erro ao atualizar passageiro");
            }
            return sucesso;
            
        } catch (SQLException ex) {
            loggerUtils.logMessage("Erro ao atualizar passageiro - " + ex.getMessage());
            return false;
        }
    }
    
}
