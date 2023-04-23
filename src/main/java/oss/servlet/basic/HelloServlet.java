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
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //localhost:8080/hello?username=kim 호출 하도록 만들겠다.
        //username=kim를  http 쿼리 파라미터
        String usernmae = request.getParameter("username");
        System.out.println("usernmae = " + usernmae);

    }
}
