package DAO;

import jdbc.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LikeDAO {
    static Connection currentCon = null;
    public boolean likeTo (int like_from, int like_to) {
        String insertQuery = "INSERT INTO liked_users (like_from, like_to)" +
                "VALUES (?, ?)";
        try {
            currentCon = DbConnection.getConnection();
            PreparedStatement preparedStatement = currentCon.prepareStatement(insertQuery);
            preparedStatement.setInt(1, like_from);
            preparedStatement.setInt(2, like_to);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            return false;
        }
        return true;
    }
}
