package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mastermac
 */
public class FabricaConexao {
    // url do banco: ip , porta , banco

    public static String URL_BD = "jdbc:mysql://localhost:3306/mysql";
    public static String USER_BD = "root";
    public static String PWD_BD = "MySQL$3rver";
    public static String ERR_BANCO = "";

    public static Connection getConnection() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL_BD, USER_BD, PWD_BD);
            return conexao;
        } catch (ClassNotFoundException e) {
            ERR_BANCO = e.toString();
            System.err.println(e);
        } catch (SQLException e) {
            ERR_BANCO = e.toString();
            System.err.println(e);
        }
        return null;
    }
    
    public static void setDefaultDB(){
        URL_BD = "jdbc:mysql://localhost:3306/torneadora";
    }
    
    public static void resetDB(){
        URL_BD = "jdbc:mysql://localhost:3306/mysql";
    }
    
}
