package oss.servlet.basic.response;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseJsonServlet",urlPatterns = "/response-html")
public class ResponseJsonServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Content-Type : text /htnml; charset = utf-8 먼저지정해줘야한다
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8"); // 인코딩 utf-8 로한다.

        PrintWriter writer = response.getWriter();
        // 웹프라우저 에서 렌터링하기
        writer.println("<html>");
        writer.println("<body>");
        writer.println(" <div>안녕?</div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
