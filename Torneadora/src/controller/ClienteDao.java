package controller;

import connection.FabricaConexao;
import entity.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author mastermac
 */
public class ClienteDao {

    public boolean criarClienteNoBanco() {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            String sql = "CREATE TABLE IF NOT EXISTS cliente("
                    + "    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "    nome VARCHAR(255),"
                    + "    genero VARCHAR(255),"
                    + "    dt_nasc DATE,"
                    + "    endereco VARCHAR(255),"
                    + "    celular VARCHAR(255),"
                    + "    email VARCHAR(255),"
                    + "    observacao VARCHAR(255),"
                    + "    imagemPerfil VARCHAR(255)"
                    + ");";
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement(sql);
            int linhas = pstm.executeUpdate();

            conexao.close();
            return true;

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (Exception e) {
                    System.err.println(e);
                }

            }
        }
        return false;
    }
    
        public boolean inserir(Cliente cliente) {
        //alunos.add(aluno);
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            
            java.sql.Date sqlDate = new java.sql.Date(cliente.getDt_nasc().getTime());
            System.out.println(sqlDate);
            
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("INSERT INTO cliente (nome,genero,dt_nasc,endereco,celular,email,observacao,imagemPerfil) VALUES (?,?,?,?,?,?,?,?);");
            
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getGenero());
            pstm.setDate(3, sqlDate);
            pstm.setString(4, cliente.getEndereco());
            pstm.setString(5, cliente.getCelular());
            pstm.setString(6, cliente.getEmail());
            pstm.setString(7, cliente.getObservacao());
            pstm.setString(8, cliente.getImagemPerfil());

            int linhas = pstm.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (Exception e) {
                    System.err.println(e);
                }

            }
        }
        return false;
    }

}
