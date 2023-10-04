package br.edu.unijui.dataBase;

import java.sql.*;

public class PreparedStatements {

    public static void main(String[] args) throws SQLException {
        try {
            /*Cria um objeto da classe DataBase para estabelecer uma conexão 
              com o banco de dados
             */
            DataBase db = new DataBase();

            //verifica se a conexão foi estabelecida
            if (db.getConnection() != null) {
                // Instanciando o objeto preparedStatement (pstmt)
                PreparedStatement pstmt = db.getConnection().prepareStatement("SELECT * FROM cliente "
                        + "WHERE nome_cliente LIKE ? AND id_tipo_cliente =  ?");

                // Setando o valor ao parâmetro 
                pstmt.setString(1, "Ada Lovelace");
                pstmt.setInt(2, 7);

                // Executando a consulta
                ResultSet resultSet = pstmt.executeQuery();

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
                pstmt.close();
                //encerra a conexão com o banco de dados
                db.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
}
