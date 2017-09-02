/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ClienteDAO {

    private Connection connection;
    private PreparedStatement stmt;

    public ClienteDAO() {
        //inicializa a conexão com o BD
        this.connection = ConnectionFactory.getConnection();
    }

    public void adiciona(ClienteBEAN cliente) {
        String sql = "insert into cliente (CliNome,CliCPF,CliIdade) values (?,?,?);";

        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setInt(3, cliente.getIdade());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleta(int codigo) {
        String sql = "delete from cliente where idCliente = ?;";

        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, codigo);
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<ClienteBEAN> listar() {
        String sql = "select * from Cliente;";
        ArrayList<ClienteBEAN> clienteAL = new ArrayList<ClienteBEAN>();
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                ClienteBEAN cliente = new ClienteBEAN();
                cliente.setCodigo(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setCpf(rs.getString(3));
                cliente.setIdade(rs.getInt(4));
                clienteAL.add(cliente);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clienteAL;
    }
    
    
    public void alterar(int codigo) {
        String sql = "update Cliente set;";

        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, codigo);
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //metodo de consulta (Selecaoo)
    public ResultSet consulta(String strSql) {
        try {
            //criando o objeto Statement para que seja possivel enviar as consultas
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //objeto do ResulSet para receber o resultado da consulta
            ResultSet rs = stmt.executeQuery(strSql);
            return rs;
        } catch (SQLException erro) {
            System.err.println(erro.getMessage());
            return null;
        }
    }

}
