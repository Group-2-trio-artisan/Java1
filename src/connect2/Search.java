package connect2;

import java.sql.SQLException;
import java.util.Scanner;

import static connect2.CRUDatabase.searchCustomer;
import static connect2.CRUDatabase.setTableDB;

public class Search {
    public static void search() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID Search : \n");
        String id = scanner.nextLine();

    }
}
