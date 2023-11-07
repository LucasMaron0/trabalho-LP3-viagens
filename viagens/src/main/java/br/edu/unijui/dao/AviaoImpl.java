/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.dao;

import br.edu.unijui.dataBase.DataBase;
import br.edu.unijui.model.Aviao;
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
    
    public AviaoImpl() throws ClassNotFoundException, SQLException {
       con = new DataBase().getConnection();
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
            return pstmtInserir.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AviaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                 
        }catch (SQLException ex) {
            System.out.print(ex.getMessage());
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
                 
        }catch (SQLException ex) {
            System.out.print(ex.getMessage());
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
            return pstmtAtualizar.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AviaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean setAviaoEmViagem(Aviao aviao) {
            aviao.setEmViagem(true);
            return  updateAviao(aviao);
    }
    
}
      

