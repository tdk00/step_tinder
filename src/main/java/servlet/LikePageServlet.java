package servlet;

import DAO.PeopleListDAO;
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

public class LikePageServlet extends HttpServlet {
    private PeopleListDAO a = new PeopleListDAO();
    private List<UsersList> allUsers = a.getUsers();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies(); // NULL
        int id=-1;
        if (cookies != null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("user_id")) {
                    id = Integer.parseInt(c.getValue());
                }
            }
        }
        if(id>0){
            // folder/file
            Path path = Paths.get("./content/templates/like-page.html");
            ServletOutputStream os = resp.getOutputStream();
            Files.copy(path, os);
        }
        else {
            resp.sendRedirect("login");
        }
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
        if(allUsers.size()==0){
            PrintWriter out = resp.getWriter();
            out.print("size0");
            out.flush();
        }else
        {
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print("{\"allUsers\":[");
            for (int i = 0; i<allUsers.size();i++) {
                int user_id = allUsers.get(i).getUser_id();
                String last_name = allUsers.get(i).getLast_name();
                String first_name = allUsers.get(i).getFirst_name();
                String user_img = allUsers.get(i).getImg();
                out.print("{\"user_id\":\""+user_id+"\",\"last_name\":\""+last_name+"\",\"first_name\":\""+first_name+"\",\"user_img\":\""+user_img+"\"}");
                if(i<allUsers.size()-1){
                    out.print(",");
                }
                // allUsers.remove(0);

            }

            out.print("],\"c_user_id\":[{\"user_id\":\""+c_user_id+"\"}]}");
            out.flush();
            //allUsers.remove(0);
        }
    }
}