package connect2;

import java.util.Scanner;
import static connect2.GetTable.getAllTable;
import static connect2.CreateTable.createTable;
import static connect2.DeleteTable.deleteTable;
import static connect2.Menu.menu;
import static connect2.MenuTableClient.menuTableClient;
import static connect2.UpdateTable.updateTable;


public class MenuTable {
    public static void menuTable(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            menuTableClient();
            int chose = scanner.nextInt();
            scanner.nextLine();
            try{
                switch (chose) {
                    case 1:
                        System.out.println("Show table");
                        getAllTable();
                        break;
                    case 2:
                        System.out.println("Create table");
                        createTable();
                        break;
                    case 3:
                        System.out.println("Update table");
                        updateTable();
                        break;
                    case 4:
                        System.out.println("Delete table");
                        deleteTable();
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
                System.out.println("sai dinh dang!");
            }
        }
    }
}
