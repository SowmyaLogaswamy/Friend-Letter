import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    get("/hello", (request, response) ->{
    Map hmp = new HashMap();
    String username = request.queryParams("username");
    request.session().attribute("ss", username);
    hmp.put("username", username);
    hmp.put("sowmy", "templates/hello.vtl");
    return new ModelAndView(hmp, "templates/layout.vtl");
  }, new VelocityTemplateEngine());

    get("/favorite_photos", (request, response) ->{
      Map hmp = new HashMap();
      hmp.put("sowmy", "templates/favorite_photos.vtl");
    return new ModelAndView(hmp, "templates/layout.vtl");
  }, new VelocityTemplateEngine());

  get("/form", (request, response) -> {
    Map model = new HashMap();
    String userNameFromSession = request.session().attribute("ss")
    model.put("username", userNameFromSession);
    model.put("sowmy", "templates/form.vtl");
    return new ModelAndView(model, "templates/layout.vtl");
  }, new VelocityTemplateEngine());

  get("/greeting_card", (request, response) -> {
    Map model = new HashMap();
    model.put("sowmy", "templates/greeting_card.vtl");
    String sender = request.queryParams("sender");
    String recipient = request.queryParams("recipient");
    model.put("sender", sender);
    model.put("recipient", recipient);
    return new ModelAndView(model, "templates/layout.vtl");
  }, new VelocityTemplateEngine());


  get("/", (request, response) -> {
    Map model = new HashMap();
    model.put("sowmy", "templates/login_form.vtl");
    return new ModelAndView(model, "templates/layout.vtl");
  }, new VelocityTemplateEngine());
  }
}
