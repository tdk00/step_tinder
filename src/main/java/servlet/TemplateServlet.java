package servlet;
import controller.TemplateEngine;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TemplateServlet extends HttpServlet {
  private final TemplateEngine engine;

  public TemplateServlet(TemplateEngine engine) {
    this.engine = engine;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // https://freemarker.apache.org/docs/index.html
    String name = "Alex";
    Integer age = 33;

    List<String> skills = Arrays.asList("Java", "Scala", "JavaScript");

    HashMap<String, Object> data = new HashMap<>();
    data.put("name", name);
    data.put("age", age);
    data.put("skills", skills);

    engine.render("one.ftl", data, resp);
  }
}
