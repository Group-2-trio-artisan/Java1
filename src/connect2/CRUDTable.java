package connect2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CRUDTable extends CRUDatabase {
    public static void getAllTab() throws SQLException {
        openConnection();
        String query = "show tables";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            if (rs.getRow() > 0){
                String name = rs.getString(1);
                System.out.println("===============");
                System.out.println("Table name : " + name);
            }else {
                System.out.println("ok");
            }
        }
        closeConnection();
    }
    public static void deleteTaB(String deleteNameTB) throws SQLException {
        openConnection();
        String query = "DROP TABLE " + deleteNameTB;
        setStatementUpdate(query);
        closeConnection();
    }
    public static void createTab(ArrayList<String> listColumn, String name) throws SQLException {
        openConnection();
        StringBuilder createTableQuery = new StringBuilder("CREATE TABLE " + name + " (");
        for (String column : listColumn) {
            createTableQuery.append(column).append(" VARCHAR(255), "); // Mặc định kiểu dữ liệu là VARCHAR(255)
        }
        createTableQuery.delete(createTableQuery.length() - 2, createTableQuery.length()); // Xóa dấu phẩy cuối cùng
        createTableQuery.append(");");

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableQuery.toString());
            System.out.println("Table " + name + " created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }

        closeConnection();
    }

    public static void updateTab(String name,String newName) throws SQLException {
        openConnection();
        String query = "ALTER TABLE " + name + " RENAME " + newName;
        statement.executeUpdate(query);
        closeConnection();
    }
    public static void searchTable(String name) throws SQLException {
        openConnection();
        String query = "SELECT * FROM information_schema.tables WHERE table_name = '" + name + "'";
        ResultSet rs = statement.executeQuery(query);

        if (rs.next()) {
            setTableDB(name);
        } else {
            System.out.println("Không có bảng này");
        }

        closeConnection();
    }
}
