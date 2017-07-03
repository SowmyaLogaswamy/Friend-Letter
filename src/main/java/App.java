import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    get("/hello", (request, response) ->{
    return new ModelAndView(new HashMap(), "templates/hello.vtl");
  }, new VelocityTemplateEngine());


    get("/favorite_photos", (request, response) ->
    "<!DOCTYPE html>" +
    "<html>" +
    "<head>" +
      "<title>Hello Dad!</title>" +
      "<link rel= 'stylesheet'  href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
      "</head>" +
      "<body>" +
      "<h1>Favorite Travelling Photos</h1>" +
      "<ul>" +
        "<li><img src= '/images/shane-rounce-205187.jpg' alt='A photo of an animal' /></li>" +
        "<li><img src='/images/blue-spruce-and-bench.png' alt= 'A photo of a spruce' /></li>" +
      "</ul>" +
      "</body>" +
      "</html>"
      );
  }
}
