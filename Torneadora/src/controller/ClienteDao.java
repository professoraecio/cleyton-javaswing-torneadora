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
            //INSERT INTO aluno (matricula,nome,genero,fone,endereco,dt_nasc) 
            //VALUES ('1','Jose','Masc','6299999-9999','Rua 1','01-01-1960');
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("INSERT INTO cliente (nome,genero,dt_nasc,endereco,celular,email,observacao,imagemPerfil) VALUES (?,?,?,?,?,?,?,?);");
            pstm.setInt(1, cliente.getId());
            pstm.setString(2, cliente.getGenero());
            pstm.setDate(3, (Date) cliente.getDt_nasc());
            pstm.setString(4, cliente.getCelular());
            pstm.setString(5, cliente.getEmail());
            pstm.setString(6, cliente.getObservacao());
            pstm.setString(7, cliente.getImagemPerfil());

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
