package DAO;

import jdbc.DbConnection;
import service.MessagesS;
import service.User;
import service.UsersList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessagesDAO {
    static Connection currentCon = null;
    static ResultSet rs = null;
    List<MessagesS> allMessages = new ArrayList<>();

    public List<MessagesS> getAllMessages(int senderId, int receiverId) {
        Statement stmt;
        String searchQuery =
                "select * from msg_view WHERE (msg_from="+senderId+" AND msg_to="+receiverId+") || (msg_to="+senderId+" AND msg_from="+receiverId+")";
        try
        {
            //connect to DB
            currentCon = DbConnection.getConnection();
            stmt=currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while(rs.next()){
                allMessages.add(new MessagesS(
                        rs.getInt("m_id"),
                        rs.getInt("msg_from"),
                        rs.getInt("msg_to"),
                        rs.getString("content"),
                        rs.getString("sender"),
                        rs.getString("receiver"),
                        rs.getString("senderImg"),
                        rs.getString("receiverImg"),
                        rs.getTimestamp("time").toString()
                ));
            }

        }

        catch (Exception ex)
        {
            return null;
        }
        return allMessages;

    }
    public boolean sendMessage (int msg_from, int msg_to, String content) {
        String insertQuery = "INSERT INTO messages (msg_from, msg_to, content)" +
                "VALUES (?, ?, ?)";
        try {
            currentCon = DbConnection.getConnection();
            PreparedStatement preparedStatement = currentCon.prepareStatement(insertQuery);
            preparedStatement.setInt(1, msg_from);
            preparedStatement.setInt(2, msg_to);
            preparedStatement.setString(3, content);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            return false;
        }
        return true;
    }
}
