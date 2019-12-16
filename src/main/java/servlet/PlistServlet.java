package servlet;

import DAO.LikedListDAO;
import DAO.PeopleListDAO;
import service.LikedList;
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

public class PlistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // folder/file
        Path path = Paths.get("./content/templates/people-list.html");
        ServletOutputStream os = resp.getOutputStream();
        Files.copy(path, os);
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
        LikedListDAO a = new LikedListDAO();
        int myId = Integer.parseInt(c_user_id);
        List<LikedList> allList = a.getLikedPersons(myId);

        if(allList.size()==0){
            PrintWriter out = resp.getWriter();
            out.print("size0");
            out.flush();
        }else
        {
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print("{\"allLiked\":[");
            for (int i = 0; i<allList.size();i++) {
                int like_from = allList.get(i).getLike_from();
                int like_to = allList.get(i).getLike_to();
                String first_name = allList.get(i).getFirst_name();
                String last_name = allList.get(i).getLast_name();
                String user_img = allList.get(i).getUser_img();

                out.print("{\"like_from\":\""+like_from+"\",\"like_to\":\""+like_to+"\",\"name\":\""+first_name+" "+last_name+"\",\"user_img\":\""+user_img+"\"}");
                if(i<allList.size()-1){
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