package DAO;

import jdbc.DbConnection;
import service.MessagesS;
import service.User;
import service.UsersList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
}
