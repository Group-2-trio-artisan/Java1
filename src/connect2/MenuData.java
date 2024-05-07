package connect2;

import java.sql.SQLException;
import java.util.Scanner;

import static connect2.CRUDatabase.*;
import static connect2.Create.create;
import static connect2.CreateTable.createTable;
import static connect2.Delete.delete;
import static connect2.DeleteTable.deleteTable;
import static connect2.GetColumn.getCL;
import static connect2.Menu.menu;
import static connect2.MenuDataClient.menuData;
import static connect2.Search.search;
import static connect2.Update.update;
public class MenuData {
    public static void menuCRUD() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
            while (!exit){
                menuData();
                int chose = scanner.nextInt();
                try {
                    switch (chose) {
                        case 1:
                            System.out.println("Read");
                            getAll();
                            break;
                        case 2:
                            System.out.println("Create");
                            create();
                            break;
                        case 3:
                            System.out.println("Update");
                            update();
                            break;
                        case 4:
                            System.out.println("Delete");
                            delete();
                            break;
                        case 5:
                            System.out.println("Search");
                            search();
                            break;


                        case 0:
                            menu();
                            exit = true;
                            break;
                        default:
                            System.out.println("Khong co lua chon nay");
                            break;
                    }
                }catch (Exception e){
                    System.out.println("da bi loi!");
                }
            }
    }
}
