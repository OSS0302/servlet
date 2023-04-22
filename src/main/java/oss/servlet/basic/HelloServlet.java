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
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service"); // 서블릿이 되는지 확인하는 테스트
        System.out.println("request = " + request); //요청 받는
        System.out.println("response = " + response);

    }
}
