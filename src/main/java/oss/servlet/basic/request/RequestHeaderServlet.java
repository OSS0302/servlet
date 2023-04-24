package oss.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet",urlPatterns = "/request-header")
public class RequestHeaderServlet  extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 스타트 라인정보 http 메서드 http 요청 메시지에 가장  첫라인 정보를 불러오는 걸 만들겠다.
        printStartLine(request);
        printHeaders(request);

    }

    private static void printStartLine(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");
        System.out.println("request.getMethod() = " + request.getMethod()); //GET
        System.out.println("request.getProtocol() = " + request.getProtocol()); //HTTP/1.1
        System.out.println("request.getScheme() = " + request.getScheme()); //http
        // http://localhost:8080/request-header
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        // /request-header
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        //username=hi
        System.out.println("request.getQueryString() = " +
                request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure()); //https 사용 유무
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }
    //Header 모든 정보
    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");
        // 헤더를 가져오는 방법이 두가지 있는데
        Enumeration<String> headerNames = request.getHeaderNames(); //request.getHeaderNames http 헤더 메시지에 있는 모든 정보를 다꺼내서 다출력할수있다.
        while(headerNames.hasMoreElements()){ // headerNames 동작했을때 다음요소 있는가?
            String headerName = headerNames.nextElement();// 다음 요소가 있다면 값을 꺼내라
            System.out.println(headerName + " : " + headerName);//  값을 출력해라.

        }
        System.out.println("--- Headers - end ---");
        System.out.println();
    }

}