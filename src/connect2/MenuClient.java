package connect2;

import java.sql.SQLException;
import java.util.Scanner;

import static connect2.CRUDatabase.getAll;
import static connect2.Create.create;
import static connect2.CreateTable.createTable;
import static connect2.Delete.delete;
import static connect2.DeleteTable.deleteTable;
import static connect2.GetColumn.getCL;
import static connect2.Menu.menu;
import static connect2.MenuData.menuCRUD;
import static connect2.MenuDataClient.menuData;
import static connect2.Search.search;
import static connect2.Update.update;

public class MenuClient {
    public static void menuClient(){

        System.out.println("Moi ban lua chon :");
        System.out.println("1.Thao tac voi du lieu Database");
        System.out.println("2.Thao tac voi Cot");
        System.out.println("3.Thao tac voi Bang");
        System.out.println("0.Thoat");
    }
}
