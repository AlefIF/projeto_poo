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

public class ClienteMySqlDAO {

    //armazernar meu objeto de conexao com o BD MySQL    
    private Connection connection;
    //objeto stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public ClienteMySqlDAO() {
        //inicializa a conexão com o BD - chamando o FActory e Singleton
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(ClienteBEAN c) {
        String sql = "insert into cliente (cliNome,"
                + " cliIdade,"
                + " cliCPF, cliEndereco, cliTelefone) values (?,?,?,?,?);";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getIdade());
            stmt.setString(3, c.getCpf());
            stmt.setString(4, c.getEndereco());
            stmt.setString(5, c.getTelefone());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<ClienteBEAN> listarALL() {
        String sql = "select * from cliente;";
        ArrayList<ClienteBEAN> contatoAL = new ArrayList<ClienteBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ClienteBEAN
                ClienteBEAN c = new ClienteBEAN();
                c.setCod(rs.getInt(1));//indica que o cod ta no campo 1 do rs
                c.setNome(rs.getString(2));
                c.setIdade(rs.getInt(3));
                c.setCpf(rs.getString(4));
                c.setEndereco(rs.getString(5));
                c.setTelefone(rs.getString(6));

                //adiciona os dados no ArrayLIst
                contatoAL.add(c);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contatoAL;
    }

    public ClienteBEAN localizarCPF(String cpf) {
        String sql = "select * from cliente where cliCPF = ?;";
        ClienteBEAN c = new ClienteBEAN();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                //ContatoBEAN c = new ContatoBEAN();
                c.setCod(rs.getInt(1)); // Ou pode colocar o nome da tabela quie esta no Banco de Dados
                c.setNome(rs.getString(2));
                c.setIdade(rs.getInt(3));
                c.setCpf(rs.getString(4));
                c.setEndereco(rs.getString(5));
                c.setTelefone(rs.getString(6));

                //adiciona os dados no array
                //contatoAL.add(c);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public boolean editar(ClienteBEAN c) {
        String sql = "update cliente set cliNome = ?, cliIdade = ?, cliCPF = ?, cliEndereco = ?, cliTelefone = ? where cliCodigo = ?";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getIdade());
            stmt.setString(3, c.getCpf());
            stmt.setString(4, c.getEndereco());
            stmt.setString(5, c.getTelefone());
            stmt.setInt(6, c.getCod());

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

    public boolean remover(int codigo) {
        String sql = "delete from cliente where cliCodigo = ?";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setInt(1, codigo);

            //executa
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClienteBEAN localizarCodigo(int busca) {
        String sql = "select * from cliente where cliCodigo = ?;";
        ClienteBEAN c = new ClienteBEAN();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, busca);

            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                //ContatoBEAN c = new ContatoBEAN();
                c.setCod(rs.getInt(1)); // Ou pode colocar o nome da tabela quie esta no Banco de Dados
                c.setNome(rs.getString(2));
                c.setIdade(rs.getInt(3));
                c.setCpf(rs.getString(4));
                c.setEndereco(rs.getString(5));
                c.setTelefone(rs.getString(6));

                //adiciona os dados no array
                //contatoAL.add(c);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public ClienteBEAN localizarNome(String busca) {
        String sql = "select * from cliente where cliNome = ?;";
        ClienteBEAN c = new ClienteBEAN();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, busca);

            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                //ContatoBEAN c = new ContatoBEAN();
                c.setCod(rs.getInt(1)); // Ou pode colocar o nome da tabela quie esta no Banco de Dados
                c.setNome(rs.getString(2));
                c.setIdade(rs.getInt(3));
                c.setCpf(rs.getString(4));
                c.setEndereco(rs.getString(5));
                c.setTelefone(rs.getString(6));

                //adiciona os dados no array
                //contatoAL.add(c);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

}
