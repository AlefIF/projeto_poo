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
import javax.swing.JOptionPane;

/**
 *
 * @author LUCASP
 */
public class FuncionarioDAO {

    private Connection connection;
    private PreparedStatement stmt;

    public void cadastrar(FuncionarioBEAN user) {
        Connection con = ConnectionFactory.getConnection();
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

    public boolean editar(FuncionarioBEAN user) {
        connection = ConnectionFactory.getConnection();
        try {
            stmt = connection.prepareStatement("UPDATE funcionario SET funNome=?,funIdade=?,"
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

    public ArrayList<FuncionarioBEAN> listarALL() {
        connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<FuncionarioBEAN> users = new ArrayList<FuncionarioBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement("SELECT * from funcionario");
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
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return users;
    }

    public boolean verificaLogin(String senha) {
        connection = ConnectionFactory.getConnection();
        String sql = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean verifica = false;
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement("SELECT * from funcionario WHERE funNomeUsuario=ADM AND funUsuarioSenha=?");

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
            ConnectionFactory.closeConnection(connection, stmt, rs);

        }
        return verifica;
    }

    public boolean verificaLogin2(String login, String senha) {
        connection = ConnectionFactory.getConnection();
        String sql = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean verifica = false;
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement("SELECT * from funcionario WHERE funNomeUsuario=? AND funUsuarioSenha=?");

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
            ConnectionFactory.closeConnection(connection, stmt, rs);

        }
        return verifica;
    }

    public boolean remover(int codigo) {
        connection = ConnectionFactory.getConnection();
        String sql = "delete from funcionario where funcionario = ?";
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

    public List<FuncionarioBEAN> readForNome(String funNome) {
        connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FuncionarioBEAN> users = new ArrayList<FuncionarioBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement("SELECT * from funcionario WHERE funNome LIKE ?");
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
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return users;
    }

    public FuncionarioBEAN localizarCodigo(int funCodigo) {
        String sql = "select * from funcionario where funCodigo = ?;";
        ArrayList<FuncionarioBEAN> users = new ArrayList<FuncionarioBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, funCodigo);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
                FuncionarioBEAN user = new FuncionarioBEAN();
                user.setCodigo(rs.getInt(1));
                user.setNome(rs.getString(2));
                user.setIdade(rs.getInt(3));
                user.setEndereco(rs.getString(3));
                user.setCpf(rs.getString(4));
                user.setNomeUsuario(rs.getString(5));
                user.setSenha(rs.getString(6));
                user.setTelefone(rs.getString(7));
                user.setNisPis(rs.getString(8));
                //adiciona os dados no ArrayLIst
                users.add(user);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users.get(0);
    }

}
