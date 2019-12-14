package servlet;
import service.Auth;
import service.User;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoginServlet extends HttpServlet {
  private final Auth auth;

  public LoginServlet(Auth auth) {
    this.auth = auth;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // folder/file
    final Cookie[] cookies = req.getCookies();
    if(cookies!=null){
      for (Cookie c : cookies) {

        if(c.getName().equals("user_id"))
        {
          resp.sendRedirect("likePage");
        }
      }
    }
    Path path = Paths.get("./content/templates/login.html");
    ServletOutputStream os = resp.getOutputStream();
    Files.copy(path, os);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String user_name = req.getParameter("email");
    String user_paswd = req.getParameter("password");
    int user_id = auth.check(user_name, user_paswd);

    if(user_id<0){
     resp.sendRedirect("");
    }
    else
    {
      String user_idS = String.valueOf(user_id);
      Cookie u = new Cookie("user_id", user_idS); u.setPath("/"); resp.addCookie(u);
      resp.sendRedirect("likePage");
    }
  }
}
