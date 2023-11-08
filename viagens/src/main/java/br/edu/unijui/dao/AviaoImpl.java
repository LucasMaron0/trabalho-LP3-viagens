/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.dao;

import br.edu.unijui.dataBase.DataBase;
import br.edu.unijui.model.Aviao;
import br.edu.unijui.utils.LoggerUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas.maron
 */
public class AviaoImpl implements AviaoDAO {
     
    private final Connection con;
    private final LoggerUtils loggerUtils;
    
    public AviaoImpl() throws ClassNotFoundException, SQLException {
       con = new DataBase().getConnection();
        loggerUtils = LoggerUtils.getLoggerUtils();
    }

    @Override
    public boolean inserirAviao(Aviao aviao) {
        
        PreparedStatement pstmtInserir;
         
        try {
       
           pstmtInserir = con.prepareStatement(""
         + "insert into aviao (modelo, empresa, emViagem)" 
         + "values (?, ? ,?)");
            
            pstmtInserir.setString(1, aviao.getModelo());
            pstmtInserir.setString  (2, aviao.getEmpresa());
            pstmtInserir.setBoolean(3, aviao.isEmViagem());
            
            boolean sucesso = pstmtInserir.execute();
            if(sucesso){
                 loggerUtils.logMessage("Sucesso ao inserir aviao");
            }else{
                loggerUtils.logMessage("Erro ao inserir aviao");
            }
            return sucesso;
            
        } catch (SQLException ex) {
            loggerUtils.logMessage("Erro ao inserir aviao - " + ex.getMessage());
            return false;
        }
    }        

    @Override
    public List<Aviao> getAllAvioes() {
        
        PreparedStatement pstmtListar;
        List<Aviao> listAvioes = null;
      
        try{
         
         pstmtListar = con.prepareStatement("select * from aviao");   
         ResultSet resultSet = pstmtListar.executeQuery();
         ResultSetMetaData metaData = resultSet.getMetaData();
         listAvioes = parseLista(resultSet);
         resultSet.close();
          
        loggerUtils.logMessage("Sucesso ao buscar lista de  avioes");
        
        }catch (SQLException ex) {
           loggerUtils.logMessage("Erro ao buscar lista de  avioes");
        }
         return listAvioes;
    }

    @Override
    public Aviao getAviao(int id) {
               
        PreparedStatement pstmtBuscarAviao;
        Aviao aviao = null;
      
        try{
         pstmtBuscarAviao = con.prepareStatement("select * from aviao where id = ?");  
         pstmtBuscarAviao.setInt(1, id);
         ResultSet resultSet = pstmtBuscarAviao.executeQuery();
         if(resultSet.next()){
            aviao = parseAviao(resultSet);
         }
         resultSet.close();
         loggerUtils.logMessage("Sucesso ao buscar detalhes do avião da viagem " + id);
         
        }catch (SQLException ex) {
            loggerUtils.logMessage("Erro ao buscar detalhes do  aviao da viagem "  + id);
        }
    
        return aviao;
    } 
    
    public static List<Aviao> parseLista(ResultSet rst) throws SQLException{
    List<Aviao> listAvioes = new ArrayList<>();

    while(rst.next()){
        listAvioes.add(parseAviao(rst));
    }    
    return listAvioes;
    }
    
    public static Aviao parseAviao(ResultSet rst) throws SQLException{
       
        return  new Aviao(
                        rst.getInt("id"),
                        rst.getString("modelo"),
                        rst.getString("empresa"),
                        rst.getBoolean("emViagem")
                );
        
    }

    @Override
    public boolean updateAviao(Aviao aviao) {
         
        PreparedStatement pstmtAtualizar;
         
        try {
       
           pstmtAtualizar = con.prepareStatement(""
         + "update aviao set modelo = ?, empresa = ?,  emViagem = ? where id = ?"); 

            
            pstmtAtualizar.setString(1, aviao.getModelo());
            pstmtAtualizar.setString  (2, aviao.getEmpresa());
            pstmtAtualizar.setBoolean(3, aviao.isEmViagem());
            pstmtAtualizar.setInt(4, aviao.getId());
            
            
            boolean sucesso = pstmtAtualizar.execute();
            if(sucesso){
                 loggerUtils.logMessage("Sucesso ao atualizar aviao");
            }else{
                loggerUtils.logMessage("Erro ao atualizar aviao");
            }
            return sucesso;
            
        } catch (SQLException ex) {
            loggerUtils.logMessage("Erro ao atualizar aviao - " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean setAviaoEmViagem(Aviao aviao) {
            aviao.setEmViagem(true);
            return  updateAviao(aviao);
    }
    
}
      

