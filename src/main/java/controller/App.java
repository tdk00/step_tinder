package controller;

import service.Auth;
import service.AuthService;
import servlet.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8083);
    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(ServletFile.class, "/static/*");
    Auth authService = new AuthService();
    handler.addServlet(new ServletHolder(new LoginServlet(authService)), "/login/*");
    handler.addServlet(new ServletHolder(new PlistServlet()), "/peopleList/*");
    handler.addServlet(new ServletHolder(new LogoutServlet()), "/logout/*");
    handler.addServlet(new ServletHolder(new LikePageServlet()), "/likePage/*");
    handler.addServlet(new ServletHolder(new MessagesServlet()), "/messages/*");
    handler.addServlet(new ServletHolder(new SendMessageServlet()), "/sendMessage/*");
    handler.addServlet(new ServletHolder(new LikedServlet()), "/liked/*");
//    handler.addServlet(new ServletHolder(new LoginServlet(authService)), "/*");
    TemplateEngine te = new TemplateEngine("./content/templates");
    handler.addServlet(new ServletHolder(new TemplateServlet(te)), "/te/*");

    server.setHandler(handler);
    server.start();
    server.join();
  }
}
