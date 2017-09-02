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
 * @author Alunos
 */
public class CategoriaMysqlDAO {

    //armazernar meu objeto de conexao com o BD MySQL    
    private Connection connection;
    //objeto stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public CategoriaMysqlDAO() {
        //inicializa a conexão com o BD - chamando o FActory e Singleton
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(CategoriaBEAN c) {
        String sql = "insert into categoria (catNome) values (?);";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            //stmt.setInt(1, c.getCatCodigo());
            stmt.setString(1, c.getCatNome());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<CategoriaBEAN> listarALL() {
        String sql = "select *from categoria;";
        ArrayList<CategoriaBEAN> catAL = new ArrayList<CategoriaBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
                CategoriaBEAN c = new CategoriaBEAN();
                c.setCatCodigo(rs.getInt("catCodigo"));//indica que o cod ta no campo 1 do rs
                c.setCatNome(rs.getString(2));
                //adiciona os dados no ArrayLIst
                catAL.add(c);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return catAL;
    }

    public boolean editar(CategoriaBEAN c) {
        String sql = "update categoria set catNome = ? where catCodigo = ?;";

        try {
            /* metodo usado para criar um objeto que representa a instrução 
            SQL que será executada, sendo que é invocado através do objeto 
            Connection.
            
            Deve ser colocado dentro de um bloco try catch */
            stmt = connection.prepareStatement(sql);
            // seta os valores           
            stmt.setString(1, c.getCatNome());
            stmt.setInt(2, c.getCatCodigo());

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

    public boolean remover(int codigo) {
        String sql = "delete from categoria where catCodigo = ?";
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
