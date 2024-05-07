package MVCLogin.model;

import MVCLogin.entity.Users;
import MVCLogin.model.Dbconnection;
import MVCLogin.model.LoginDAO;

import java.sql.*;

public class LoginDaoImpl implements LoginDAO {
    private static final Connection conn;

    static {
        try {
            conn = Dbconnection.getMySQLConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Statement stmt = null;
    private PreparedStatement pstm = null;


    @Override
    public String checkLoginStatement(Users users) {
        String query = "select username from users where username = '"+users.getUsername()+"'and password='"+users.getPassword()+"'";
        try{
            // tao lai statement moi lan thuc thi
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                System.out.println("username is : " + rs.getString("username"));
                return rs.getString("username");
            }
            return "not in database";
        }catch (SQLException e){
            System.out.println("un success!");
            return "false";
        }
    }

    @Override
    public String checkLoginPrepareStatement(Users users) {
        String query = "select username from users where username like ? and password like ?";
        try{
            // tai su dung lai prepare statement
            pstm = conn.prepareStatement(query);
            pstm.setString(1,users.getUsername());
            pstm.setString(2,users.getPassword());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                System.out.println("Username is :" + rs.getString("username"));
                return  rs.getString("username");
            }
            return "not in database";
        }catch (SQLException e){
            return "false";
        }

    }
}
