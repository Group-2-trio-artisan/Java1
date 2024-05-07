package session8;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExample {
    public static void main(String[] args)throws SQLException {
        Connection connection = MySQLConnectionDB.getMyConnection();
        //Xu ly theo Batch, cung luc chay nhieu cau lenh
        //Update, Insert
        Statement stm = connection.createStatement();
        //query1
        String query1 = "UPDATE customers set first_name = 'Tran' where customer_id = 1";
        stm.addBatch(query1);
        //query2
        String query2 = "UPDATE customers set first_name = 'Ngo' where customer_id = 3";
        stm.addBatch(query2);

        int []counts = stm.executeBatch();
        System.out.println("Query 1: " + counts[0]);
        System.out.println("Query 2: " + counts[1]);
        connection.commit();
    }
}
