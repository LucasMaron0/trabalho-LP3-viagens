/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.dao;

import br.edu.unijui.dataBase.DataBase;
import br.edu.unijui.model.Aviao;
import br.edu.unijui.model.Passageiro;
import br.edu.unijui.model.Viagem;
import br.edu.unijui.utils.LoggerUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ViagemImpl implements ViagemDAO{
    
    private final Connection con;
    private final AviaoImpl aviaoImpl;
    private final PassageiroImpl passageiroImpl; 
    private final LoggerUtils loggerUtils;
    
    public ViagemImpl() throws ClassNotFoundException, SQLException {
       con = new DataBase().getConnection();
       con.setAutoCommit(false);
       aviaoImpl = new AviaoImpl();
       passageiroImpl = new PassageiroImpl();
       loggerUtils = LoggerUtils.getLoggerUtils();
    }

    @Override
    public boolean inserirViagem(Viagem viagem) {
        
        PreparedStatement pstmtInserir;
         
        try {
                    
            aviaoImpl.setAviaoEmViagem(viagem.getAviao());
            
           pstmtInserir = con.prepareStatement(""
         + "insert into viagem (aviaoID, origem, destino, data)" 
         + "values (?, ?, ?, ?)");
            
            pstmtInserir.setInt(1, viagem.getAviao().getId());
            pstmtInserir.setString  (2, viagem.getOrigem());
            pstmtInserir.setString  (3, viagem.getDestino());
            
            java.sql.Date dataSQL = new java.sql.Date(viagem.getData().getTime());
            pstmtInserir.setDate(4, dataSQL);
           
            boolean sucesso = pstmtInserir.execute();
            
            if(sucesso){
                loggerUtils.logMessage("Sucesso ao inserir viagem");
                
            }else{
                loggerUtils.logMessage("Falha ao inserir viagem - ");
            }         
            return sucesso;
            
        } catch (SQLException ex) {
            loggerUtils.logMessage("Falha ao inserir viagem - " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Viagem> getAllViagens() {
                
        PreparedStatement pstmtListar;
        List<Viagem> listViagens = null;
      
        try{

            pstmtListar = con.prepareStatement("select * from viagem");   
            ResultSet resultSet = pstmtListar.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            listViagens = parseLista(resultSet);
            resultSet.close();
            
            loggerUtils.logMessage("Sucesso ao buscar viagens");
                 
        }catch (Exception ex) {
            loggerUtils.logMessage("Falha ao buscar viagens - " + ex.getMessage());
        } 
        
        return listViagens;
    }
    
    public  List<Viagem> parseLista(ResultSet rst) throws SQLException, ClassNotFoundException{
       
        List<Viagem> listViagens = new ArrayList<>();
        while(rst.next()){
            
            Aviao aviao = aviaoImpl.getAviao(rst.getInt("aviaoID"));
            List<Passageiro> passageiros = passageiroImpl.buscarPassageirosNaViagem(rst.getInt("id"));
            
            listViagens.add(
                    new Viagem(
                            rst.getInt("id"),
                            passageiros,
                            aviao,
                            rst.getString("origem"),
                            rst.getString("destino"),
                            rst.getDate("data"),
                            rst.getInt("totalPassageiros")  
                    )
            );
        }
        return listViagens;
        }

    @Override
    public boolean updateViagem(Viagem viagem) {
                PreparedStatement pstmtUpdate;
         
        try {
   
           pstmtUpdate = con.prepareStatement(""
         + "update viagem set aviaoId = ?, origem = ?,destino = ?, data = ?, totalPassageiros = ? where id = ? ");
            
            pstmtUpdate.setInt(1, viagem.getAviao().getId());
            pstmtUpdate.setString  (2, viagem.getOrigem());
            pstmtUpdate.setString  (3, viagem.getDestino());
            java.sql.Date dataSQL = new java.sql.Date(viagem.getData().getTime());
            pstmtUpdate.setDate(4, dataSQL);
            pstmtUpdate.setInt(5, viagem.getTotalPassageiros());
            pstmtUpdate.setInt(6, viagem.getId());
           
            boolean sucesso = pstmtUpdate.execute();
            
            if(sucesso){
                loggerUtils.logMessage("Sucesso ao atualizar viagem");
                
            }else{
                loggerUtils.logMessage("Falha ao atualizar viagem");
            }         
            
            return sucesso;
            
        } catch (SQLException ex) {
            loggerUtils.logMessage("Falha ao atualizar viagem - " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean agendarViagem(Viagem viagem, Passageiro passageiro){
      
        passageiro.setIdViagem(viagem.getId());
        viagem.getListaPassageiros().add(passageiro);
        viagem.setTotalPassageiros(viagem.getListaPassageiros().size());
        
        try {
            con.setAutoCommit(false);
           
            PreparedStatement pstmtAtualizarPassageiro;                   
            pstmtAtualizarPassageiro =con.prepareStatement(""
            +  "update passageiro set nome = ?, passaporte = ?, idViagem = ?  where id = ?");
            
            pstmtAtualizarPassageiro.setString(1, passageiro.getNome());
            pstmtAtualizarPassageiro.setString(2, passageiro.getPassaporte());
            pstmtAtualizarPassageiro.setInt(3, passageiro.getIdViagem());
            pstmtAtualizarPassageiro.setInt(4, passageiro.getId());
          
            
            int rowsAfetadasPassageiro = pstmtAtualizarPassageiro.executeUpdate();
            
            PreparedStatement pstmtAtualizarViagem;
            pstmtAtualizarViagem = con.prepareStatement(""
            + "update viagem set aviaoId = ?, origem = ?,destino = ?, data = ?, totalPassageiros = ? where id = ? ");

            pstmtAtualizarViagem.setInt(1, viagem.getAviao().getId());
            pstmtAtualizarViagem.setString  (2, viagem.getOrigem());
            pstmtAtualizarViagem.setString  (3, viagem.getDestino());
            java.sql.Date dataSQL = new java.sql.Date(viagem.getData().getTime());
            pstmtAtualizarViagem.setDate(4, dataSQL);
            pstmtAtualizarViagem.setInt(5, viagem.getTotalPassageiros());
            pstmtAtualizarViagem.setInt(6, viagem.getId());
            
    
            int rowsAfetadasViagem = pstmtAtualizarViagem.executeUpdate();

          
            if(rowsAfetadasPassageiro >= 1 && rowsAfetadasViagem >= 1){  
                con.commit();
                loggerUtils.logMessage("Sucesso ao agendar viagem.");
                return true;
            }else{
                loggerUtils.logMessage("Falha ao agendar viagem, executando rollback... ");
                con.rollback();
                return false;
            }
     
        }catch (SQLException ex) {
            loggerUtils.logMessage("Falha ao agendar viagem - " + ex.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex1) {
              loggerUtils.logMessage("Falha ao agendar viagem - " + ex.getMessage());
            }
            return false;
        } 
    }
    

}

