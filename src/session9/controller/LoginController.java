package session9.controller;

import MVCLogin.entity.Users;
import MVCLogin.model.LoginDaoImpl;

import java.sql.SQLException;

public class LoginController {
    //Call instance of Model step 2
    LoginDaoImpl loginDao = new LoginDaoImpl();

    public String loginStatementController(Users user) throws SQLException {
        //Step 2 and 3
        String message = loginDao.checkLoginStatement(user);
        //return loginDao.checkLoginStatement(user)
        //Step 3
        return message;
    }

    public String loginPreparedStatementController(Users user) throws SQLException {
        //Step 2
        String message = loginDao.checkLoginPrepareStatement(user);
        //Step 3
        return message;
    }
}
