package DAO;

import jdbc.DbConnection;
import service.User;
import service.UsersList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PeopleListDAO {
    static Connection currentCon = null;
    static ResultSet rs = null;
    List<UsersList> allUsers = new ArrayList<UsersList>();

    public List<UsersList> getUsers() {
        Statement stmt = null;
        String searchQuery =
                "select * from users";
        try
        {
            //connect to DB
            currentCon = DbConnection.getConnection();
            stmt=currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while(rs.next()){
                allUsers.add(new UsersList(
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("user_img")
                ));
            }

        }

        catch (Exception ex)
        {
            return null;
        }
        return allUsers;

    }
}
