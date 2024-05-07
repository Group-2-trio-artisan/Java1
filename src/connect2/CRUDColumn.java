package connect2;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;



public class CRUDColumn extends CRUDatabase{
    public static void createColumn(String newColumn,String dataType,String numberCharacter) throws SQLException {
        openConnection();
        String query = "alter table " + tableDB + " add " + newColumn + " " + dataType + "(" + numberCharacter + ")";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        closeConnection();
    }
    public static void updateColum(String nameColumn,String newName,String dataType,String numberCharacter) throws SQLException {
        openConnection();
        String query = "ALTER TABLE " + tableDB + " CHANGE COLUMN " + nameColumn + " " + newName + " " + dataType + "(" + numberCharacter + ")";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        closeConnection();
    }
    public static void deleteColum(String nameColumn) throws SQLException {
        openConnection();
        String query = "ALTER TABLE " + tableDB + " DROP COLUMN " + nameColumn;
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        closeConnection();
    }
    public static void getAllColumn()throws SQLException{
        openConnection();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + tableDB);

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        System.out.println("Tên các cột trong bảng:");
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rsmd.getColumnName(i);
            System.out.println("Column " + i + ": " + columnName);
        }
        System.out.println("====================");
        closeConnection();
    }
}
