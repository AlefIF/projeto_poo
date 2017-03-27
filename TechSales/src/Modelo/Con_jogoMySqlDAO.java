/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Con_jogoMySqlDAO {
    //armazernar meu objeto de conexao com o BD MySQL    
    private Connection connection;
    //objeto stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public Con_jogoMySqlDAO() {
        //inicializa a conexão com o BD - chamando o FActory e Singleton
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrar2(Con_jogoBEAN w) {

        String sql = "insert into Con_jogo (cjg_joCodigo,cjg_conCodigo ) values (?,?);";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, w.getCjg_joCodigo());
            stmt.setInt(2, w.getCjg_conCodigo());             
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }      

    }

    
    public boolean editar2(Con_jogoBEAN w) {
        String sql = "update  Con_jogo set cjg_conCodigo=? where cjg_joCodigo = ?;";

        try {
            /* metodo usado para criar um objeto que representa a instrução 
            SQL que será executada, sendo que é invocado através do objeto 
            Connection.
            
            Deve ser colocado dentro de um bloco try catch */
            stmt = connection.prepareStatement(sql);
            // seta os valores          
            stmt.setInt(1, w.getCjg_conCodigo());     
             stmt.setInt(2, w.getCjg_joCodigo());

            // executa update
            int linhasAtualizadas = stmt.executeUpdate();
            stmt.close();
            //apenas se quiser saber quantas linhas foram alteradas
            if (linhasAtualizadas > 0) {
                System.out.println("Foram alterados " + linhasAtualizadas + " registros");
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean remover2(int codigo) {
        String sql = "delete from Con_jogo where cjg_joCodigo = ?";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, codigo);
            // executa
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
