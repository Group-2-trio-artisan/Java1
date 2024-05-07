package connect2;

import java.util.Scanner;

import static connect2.CRUDatabase.tableDB;
import static connect2.CreateColumn.addColumn;

import static connect2.DeleteColumn.deleteColumn;
import static connect2.GetColumn.getCL;
import static connect2.Menu.menu;
import static connect2.MenuColumnClient.menuColumnClient;
import static connect2.SearchTab.searchTab;
import static connect2.UpdateColumn.updateColumn;

public class MenuColumn {
    public static void menuColumn(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            menuColumnClient();
            int chose = scanner.nextInt();
            try{
                switch (chose) {
                    case 1:
                        System.out.println("Show column");
                        getCL();
                        break;
                    case 2:
                        System.out.println("Create column");
                        addColumn();
                        break;
                    case 3:
                        System.out.println("Update column");
                        updateColumn();
                        break;
                    case 4:
                        System.out.println("Delete column");
                        deleteColumn();
                        break;
                    case 0:
                        menu();
                        exit = true;
                        break;
                    case 9:
                        if (tableDB== null){
                            System.out.println("Name Table");
                            searchTab();
                            break;
                        }

                    default:
                        System.out.println("Khong co lua chon nay");
                        break;
                }
            }catch (Exception e){
                System.out.println("Moi nhap lai!");
            }
        }
    }
}
