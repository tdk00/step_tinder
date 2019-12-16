package servlet;
import DAO.MessagesDAO;
import DAO.PeopleListDAO;
import service.MessagesS;
import service.UsersList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MessagesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = Paths.get("./content/templates/chat.html");
        ServletOutputStream os = resp.getOutputStream();
        Files.copy(path,os);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String c_user_id = "";
        final Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for (Cookie c : cookies) {

                if(c.getName().equals("user_id"))
                {
                   c_user_id = c.getValue();
                }
            }
        }
        String senderId = c_user_id;
        String receiverId = req.getParameter("receiverId");
        MessagesDAO m = new MessagesDAO();
        List<MessagesS> allMessages = m.getAllMessages(Integer.parseInt(senderId),Integer.parseInt(receiverId));
        if(allMessages==null){
            System.exit(0);
        }
        if(allMessages.size()==0){
            PrintWriter out = resp.getWriter();
            out.print("size0");
            out.flush();
        }else
        {
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print("{\"allMessages\":[");
            for (int i = 0; i<allMessages.size();i++) {
                int message_id = allMessages.get(i).getMessage_id();
                int user_from = allMessages.get(i).getUser_from();
                int user_to = allMessages.get(i).getUser_to();
                String content = allMessages.get(i).getContent();
                String receiverImg = allMessages.get(i).getSenderImg();
                String receiverName = allMessages.get(i).getSender();
                out.print("{\"message_id\":\""+message_id+"\",\"user_from\":\""+user_from+"\",\"user_to\":\""+user_to+"\",\"content\":\""+content+"\",\"receiverImg\":\""+receiverImg+"\",\"receiverName\":\""+receiverName+"\"}");
                if(i<allMessages.size()-1){
                    out.print(",");
                }

            }
            out.print("],\"c_user_id\":[{\"user_id\":\""+c_user_id+"\"}]}");
            out.flush();
        }
    }
}


