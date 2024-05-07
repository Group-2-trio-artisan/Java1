package connect2;

import java.sql.SQLException;
import java.util.Scanner;

import static connect2.CRUDTable.searchTable;
import static connect2.CRUDatabase.setTableDB;

public class SearchTab {
    public static void searchTab() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the column name: ");
        String name = scanner.nextLine();
        searchTable(name);

    }
}
