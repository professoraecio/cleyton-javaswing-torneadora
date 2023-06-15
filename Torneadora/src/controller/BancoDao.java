/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author mastermac
 */
public class BancoDao {

    public boolean criarBanco() {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            String sql = "CREATE DATABASE IF NOT EXISTS torneadora;";
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement(sql);
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

    public boolean voltarModoDeFabrica() {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            String sql = "drop database torneadora;";
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement(sql);
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
