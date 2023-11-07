package br.edu.unijui.dataBase;

import java.sql.*;

public class ConnectionTest {

    public static void main(String[] args) throws SQLException {
        try {
            /*Cria um objeto da classe DataBase para estabelecer uma conexão 
              com o banco de dados
             */
            DataBase db = new DataBase();

            //verifica se a conexão foi estabelecida
            if (db.getConnection() != null) {
                //cria Statement para consultar o banco de dados
                Statement stmt = db.getConnection().createStatement();
                /*executa a consulta no banco de dados
                  o retorno da consulta é armazenado no ResultSet
                 */
                ResultSet resultSet = stmt.executeQuery("SELECT * FROM passageiro");

                //Obtém os metadados do resultado
                ResultSetMetaData metaData = resultSet.getMetaData();
                //monta as colunas de resultado
                int numberOfColumns = metaData.getColumnCount();
                System.out.println("clientes:");
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-8s\t", metaData.getColumnName(i));
                }
                System.out.println();

                //percorre os dados retornados pela consulta exibindo-os
                while (resultSet.next()) {
                    for (int i = 1; i <= numberOfColumns; i++) {
                        System.out.printf("%-8s\t", resultSet.getObject(i));
                    }
                    System.out.println();
                }

                resultSet.close();
                stmt.close();
                //encerra a conexão com o banco de dados
                db.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
}
