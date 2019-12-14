package DAO;
import jdbc.DbConnection;
import service.User;

import java.sql.*;

public class LoginDAO
{
    static Connection currentCon = null;
    static ResultSet rs = null;
    public static int checkLogin(User us) {
        String email = us.getEmail();
        String password = us.getPassword();
        Statement stmt = null;
        String searchQuery =
                "select * from users where email='" + email + "' AND password='"+ password+ "'";
        try
        {
            //connect to DB
            currentCon = DbConnection.getConnection();
            stmt=currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            if(rs.next()){
                int user_id = rs.getInt("user_id");
                return user_id;
            }
            else
            {
                return -1;
            }
        }

        catch (Exception ex)
        {
           return -1;
        }

    }
}