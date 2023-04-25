package oss.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@WebServlet(name = "requestBodyStringServlet",urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    //서블릿이 호출되면 서비스 메서드 호출됩니다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();// 메시지 바디에 내용을 바이트 코드로 얻울 수 있다.

        // String을 여러개 변환하면서 바꿔야하는데 String 에서  번거러운 작업 자동으로 해주는 유틸리티 제공한다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);// 인코딩 정보를 넘겨줘야한다. 일반적은로 UTF-8를 많이 사용한다.
        //출력하기
        System.out.println("messageBody = " + messageBody);
        //messagebody 을 받으면 받았다로 나온다.
        response.getWriter().write("받았다.");
    }
}
