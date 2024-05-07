package connect2;

import java.sql.SQLException;
import java.util.Scanner;

import static connect2.CRUDTable.deleteTaB;

public class DeleteTable {
    public static void deleteTable() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the table name delete : ");
        String deleteNameTB = scanner.nextLine();
        deleteTaB(deleteNameTB);
    }
}
