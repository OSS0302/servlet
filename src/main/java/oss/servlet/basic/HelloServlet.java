package oss.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "helloServlet",urlPatterns = "/hello")
public class HelloServlet extends HttpServlet { // HttpServlet를 상속받는다.

    @Override //서블릿이 호출되면 서비스 메서드 가 호출된다.
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
