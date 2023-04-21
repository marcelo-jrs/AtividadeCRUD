package control;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    //nome do mysql
    private static final String USERNAME = "root";

    //senha mysql
    private static final String PASSWORD = "";

    //caminho do banco
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/facul";

    public static Connection getConnection() throws Exception {
        //carrega a classe
        Class.forName("com.mysql.jdbc.Driver");

        //cria conexao com o banco
        Connection conexao = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return conexao;
    }

    public static void main(String[] args) throws Exception {
        //recuperar conexao
        Connection con = getConnection();

        if(con != null){
            System.out.println("Conexão obtida");
            con.close();
        }
    }
}
