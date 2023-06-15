package main;

import connection.FabricaConexao;
import controller.ArquivosDao;
import controller.BancoDao;
import controller.ClienteDao;
import java.sql.Connection;
import util.Alexa;
import util.OsUtils;
import view.MenuPrincipalForm;

/**
 *
 * @author mastermac
 */
public class Principal {
    
    public static String senhaMysql = "";
    public static Boolean conectou = false;
    public static String pastaUsers = "";
    
    public static void main(String[] args) {
        while (conectou == false) {
            // Verificar se exite o mysql instalado na máquina
            senhaMysql = ArquivosDao.lerArquivoSenhaBanco();
            if(senhaMysql != null){ // arquivo de senha não existe
                FabricaConexao.PWD_BD = senhaMysql;
            }
            Connection conexao = FabricaConexao.getConnection();
            if (conexao == null) {
                if (FabricaConexao.ERR_BANCO.contains("Access denied")) {
                    String erroSenha = "Sua senha padrão para o usuário root do mysql \nestá diferente da configurada."
                            + "Por favof informe \na senha do usuário root do mysql.";
                    senhaMysql = Alexa.escrevaLeiaJanela(erroSenha);
                    FabricaConexao.PWD_BD = senhaMysql;
                    ArquivosDao.criarPastaArquivosProjetoDentroPastaUsers();
                    pastaUsers = ArquivosDao.pastaUsers;
                    ArquivosDao.criarArquivoSenhaBanco(senhaMysql);
                } else {
                    Alexa.escrevaJanela("Aparentemente você não tem o MYSQL instalado, "
                            + "\ninstale primeiro para depois prosseguirmos por favor."
                            + "\nUse a senha MySQL$3rver para o usuário root.");
                    conectou = true;
                    System.exit(0);
                }
            } else {
                criarBancoETabelas();
                //Alexa.escrevaJanela("Sucesso, conexão bem sucedida!");
                conectou = true;
            }
        }
        MenuPrincipalForm menuPrincipalForm = new MenuPrincipalForm();
        menuPrincipalForm.setVisible(true);
        menuPrincipalForm.setLocationRelativeTo(null);
    }
    
    public static void criarBancoETabelas() {
        BancoDao bancoDao = new BancoDao();
        Boolean bancoCriado = bancoDao.criarBanco();
        if (bancoCriado) {
            System.out.println("Banco criado: " + bancoCriado);
            FabricaConexao.setDefaultDB();
            ClienteDao clienteDao = new ClienteDao();
            Boolean clienteCriado = clienteDao.criarClienteNoBanco();
            System.out.println("Cliente criado: " + clienteCriado);
        } else {
            Alexa.escrevaJanela("Falha ao criar banco de dados!");
        }
        
    }
    
}
