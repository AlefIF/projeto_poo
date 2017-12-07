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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LUCASP
 */
public class FuncionarioDAO {

    public void cadastrar(FuncionarioBEAN user) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO funcionario(funNome,funIdade,funEndereco,funCPF,funNomeUsuario,funUsuarioSenha,funTelefone,funNisPis"
                    + ") values(?,?,?,?,?,?,?,?)");
            stmt.setString(1, user.getNome());
            stmt.setInt(2, user.getIdade());
            stmt.setString(3, user.getEndereco());
            stmt.setString(4, user.getCpf());
            stmt.setString(5, user.getNomeUsuario());
            stmt.setString(6, user.getSenha());
            stmt.setString(7, user.getTelefone());
            stmt.setString(8, user.getNisPis());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário:\n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public void editar(FuncionarioBEAN user) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE funcionario SET funNome=?,funIdade=?,"
                    + "funEndereco=?,funCPF=?,funNomeUsuario=?,funUsuarioSenha=?,"
                    + "funTelefone=?,funNisPis=? WHERE funCodigo=?");

            stmt.setString(1, user.getNome());
            stmt.setInt(2, user.getIdade());
            stmt.setString(3, user.getEndereco());
            stmt.setString(4, user.getCpf());
            stmt.setString(5, user.getNomeUsuario());
            stmt.setString(6, user.getSenha());
            stmt.setString(7, user.getTelefone());
            stmt.setString(8, user.getNisPis());
            stmt.setInt(9, user.getCodigo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar:\n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public List<FuncionarioBEAN> ListarALL() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FuncionarioBEAN> users = new ArrayList<FuncionarioBEAN>();
        try {
            // prepared statement para seleção
            stmt = con.prepareStatement("SELECT * from funcionario");
            // executa a consulta SQL usando o comando executeQuery
            rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto user do tipo userBEAN
                FuncionarioBEAN user = new FuncionarioBEAN();
                user.setCodigo(rs.getInt("funCodigo"));
                user.setNome(rs.getString("funNome"));
                user.setIdade(rs.getInt("funIdade"));
                user.setEndereco(rs.getString("funEndereco"));
                user.setCpf(rs.getString("funCPF"));
                user.setNomeUsuario(rs.getString("funNomeUsuario"));
                user.setSenha(rs.getString("funUsuarioSenha"));
                user.setTelefone(rs.getString("funTelefone"));
                user.setNisPis(rs.getString("funNisPis"));

                //adiciona os dados no ArrayLIst
                users.add(user);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário não encontrado" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return users;
    }

    public boolean verificaLogin(String senha) {
        Connection con = ConnectionFactory.getConnection();
        String sql = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean verifica = false;
        try {
            // prepared statement para seleção
            stmt = con.prepareStatement("SELECT * from funcionario WHERE funNomeUsuario=ADM AND funUsuarioSenha=?");

            stmt.setString(2, senha);
            // executa a consulta SQL usando o comando executeQuery
            rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            if (rs.next()) {
                verifica = true;
            }

            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return verifica;
    }

    public boolean verificaLogin2(String login, String senha) {
        Connection con = ConnectionFactory.getConnection();
        String sql = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean verifica = false;
        try {
            // prepared statement para seleção
            stmt = con.prepareStatement("SELECT * from funcionario WHERE funNomeUsuario=? AND funUsuarioSenha=?");

            stmt.setString(2, senha);
            // executa a consulta SQL usando o comando executeQuery
            rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            if (rs.next()) {
                verifica = true;
            }

            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return verifica;
    }

    public void excluir(FuncionarioBEAN user) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE from funcionario WHERE funCodigo=?");
            stmt.setInt(1, user.getCodigo());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public List<FuncionarioBEAN> readForNome(String funNome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FuncionarioBEAN> users = new ArrayList<FuncionarioBEAN>();
        try {
            // prepared statement para seleção
            stmt = con.prepareStatement("SELECT * from funcionario WHERE funNome LIKE ?");
            stmt.setString(1, "%" + funNome + "%");
            // executa a consulta SQL usando o comando executeQuery
            rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto user do tipo userBEAN
                FuncionarioBEAN user = new FuncionarioBEAN();
                user.setCodigo(rs.getInt("funCodigo"));
                user.setNome(rs.getString("funNome"));
                user.setIdade(rs.getInt("funIdade"));
                user.setEndereco(rs.getString("funEndereco"));
                user.setCpf(rs.getString("funCPF"));
                user.setNomeUsuario(rs.getString("funNomeUsuario"));
                user.setSenha(rs.getString("funUsuarioSenha"));
                user.setTelefone(rs.getString("funTelefone"));
                user.setNisPis(rs.getString("funNisPis"));

                //adiciona os dados no ArrayLIst
                users.add(user);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return users;
    }
}
