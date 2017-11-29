/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alunos
 */
public class GeneroDAO {
    //armazernar meu objeto de conexao com o BD MySQL    
    private Connection connection;
    //objeto stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public GeneroDAO() {
        
        //inicializa a conexão com o BD - chamando o FActory e Singleton
        this.connection = ConnectionFactory.getConnection();
    }

    
    public ArrayList<Genero> listarALL() {
        String sql = "select * from genero;";
        ArrayList<Genero> genAL = new ArrayList<Genero>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo GeneroBEAN
                Genero g = new Genero();
                g.setId(rs.getInt("gen_Id"));//indica que o cod ta no campo 1 do rs
                g.setNome(rs.getString(2));
                //adiciona os dados no ArrayLIst
                genAL.add(g);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genAL;
    }
    
    
    public Genero listarPorId(int i) {
        String sql = "select * from genero where gen_Id = ?;";
        
        Genero g = new Genero();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            stmt.setString(1, ""+i);
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo GeneroBEAN
                
                g.setId(rs.getInt("gen_Id"));//indica que o cod ta no campo 1 do rs
                g.setNome(rs.getString(2));
                //adiciona os dados no ArrayLIst
                
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return g;
    }

    
    
}
