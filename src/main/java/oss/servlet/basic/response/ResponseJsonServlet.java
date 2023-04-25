package oss.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import oss.servlet.basic.request.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="responseJsonServlet",urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper(); //writeValueAsString 를 사용하기 위해서 문자 -> 제이슨 형식으로
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     // Content-Type: application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData(); // json 테스트할  인스턴스 객체 생성
        helloData.setUsername("OH"); // 이름
        helloData.setAge(20); // 나이

        // 문자 -> json형식으로 변환
        //{"username":"kim","age":20}
        String result = objectMapper.writeValueAsString(helloData);// 객체 값을 사용해서 json 로 바꿔라
        response.getWriter().write(result); // 결과값 출력하기
    }
}
