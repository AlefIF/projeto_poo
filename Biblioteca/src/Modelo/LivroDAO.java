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
public class LivroDAO {

    //armazernar meu objeto de conexao com o BD MySQL    
    private Connection connection;
    //objeto stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public LivroDAO() {
        //inicializa a conexão com o BD - chamando o FActory e Singleton
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(Livro l) {
        String sql = "insert into livro (liv_Titulo,"
                + " liv_Genero,"
                + " liv_Situacao, liv_Autor) values (?,?,?,?);";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, l.getTitulo());
            stmt.setInt(2, l.getGenero());
            stmt.setBoolean(3, l.isSituacao());
            stmt.setString(4, l.getAutor());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Livro> listarALL() {
        String sql = "select * from livro;";
        ArrayList<Livro> livroAL = new ArrayList<Livro>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo LivroBEAN
                Livro l = new Livro();
                l.setId(rs.getInt(1));//indica que o cod ta no campo 1 do rs
                l.setTitulo(rs.getString(2));
                l.setSituacao(rs.getBoolean(3));                           
                l.setAutor(rs.getString(4));
                l.setGenero(rs.getInt(5));

                //adiciona os dados no ArrayLIst
                livroAL.add(l);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return livroAL;
    }

    public boolean editar(Livro l) {
        String sql = "update livro set liv_Titulo = ?, liv_Genero = ?, liv_Situacao = ?, liv_Autor = ? where liv_Id = ?";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setString(1, l.getTitulo());
            stmt.setInt(2, l.getGenero());
            stmt.setBoolean(3, l.isSituacao());
            stmt.setString(4, l.getAutor());
            stmt.setInt(5,l.getId());

            //executa update(mudança)
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

    public boolean remover(Livro l) {
        String sql = "delete from livro where liv_Id = ?";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setInt(1, l.getId());

            //executa
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
