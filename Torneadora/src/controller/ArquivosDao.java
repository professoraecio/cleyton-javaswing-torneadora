/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static main.Principal.pastaUsers;
import util.FabricaArquivo;
import util.OsUtils;

/**
 *
 * @author mastermac
 */
public class ArquivosDao {
    
    public static String pastaUsers = "";
    public static String osPathBar = "";
    
    public static void criarPastaArquivosProjetoDentroPastaUsers(){
        pastaUsers = OsUtils.getUsersFolder();
        System.out.println(pastaUsers);
        osPathBar = OsUtils.getOSPathBar();
        FabricaArquivo.criarDiretorio(pastaUsers + osPathBar + "torneadora");
    }
    
    public static void criarArquivoSenhaBanco(String senhaBanco){
        pastaUsers = OsUtils.getUsersFolder();
        osPathBar = OsUtils.getOSPathBar();
        FabricaArquivo.sobrescreverString(senhaBanco, pastaUsers + osPathBar + "torneadora" + osPathBar + "senha.txt", 0);
    }
    
    public static String lerArquivoSenhaBanco(){
        pastaUsers = OsUtils.getUsersFolder();
        osPathBar = OsUtils.getOSPathBar();
        return FabricaArquivo.lerLinhaDoArquivo(pastaUsers + osPathBar + "torneadora" + osPathBar + "senha.txt", 0);
    }
    
}
