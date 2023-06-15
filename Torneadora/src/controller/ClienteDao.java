package controller;

import connection.FabricaConexao;
import java.sql.Connection;
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
                    + "    observacao VARCHAR(255)"
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

}
