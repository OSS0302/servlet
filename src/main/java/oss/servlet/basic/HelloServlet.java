package oss.servlet.basic;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@WebServlet (name = "helloServlet",urlPatterns = "/hello")
public class HelloServlet extends HttpServlet { // HttpServlet를 상속받는다.
}
