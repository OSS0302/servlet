package oss.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // [state-line]
    response.setStatus(HttpServletResponse.SC_OK);

    //[state-headers]
    response.setHeader("content-Type", "text/plain;charset = utf-8");
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate" );// 캐쉬를 무효화 하겠다 .
    response.setHeader("Pragma","no-cache");// 과거버전까지 캐쉬를 없애겠다.
    response.setHeader("my-header","hello");// 임의의 헤더 을  넣겠다.

        //[header 편의 메서드 ]
       content(response);
    // 테스트
        PrintWriter writer = response.getWriter();
        writer.println("ok");

    }
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        response.setHeader("Content-Type", "text/plain;charset=utf-8"); response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // response.setContentLength(2); //(생략시 자동 생성)
    }
}
