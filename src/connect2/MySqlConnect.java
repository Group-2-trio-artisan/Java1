package connect2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnect {



    public static Connection getMySQLConnection() throws SQLException {
        Connection connection = null;
        String hostName = "localhost";
        String dbName = "ecommerceFPT";
        String userName = "root";
        String password = "";
        String connectionURL = "jdbc:mysql://"+hostName+":3306/"+dbName;
        try {
            connection = DriverManager.getConnection(connectionURL,userName,password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection ;
    }
//    public static void main(String[] args) throws SQLException {
//        if (getMySQLConnection() != null) {
//            System.out.println("Connect Database success!");
//        }
//        //get connection:goi doi tuong ket noi la connection de su dung
//        Connection connection = getMySQLConnection();// tra ve 1 doi tuong connection
//
//    }
}
