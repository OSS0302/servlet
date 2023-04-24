package oss.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        printHeaders(request);// 모든 헤더 정보
        printHeaderUtils(request); // 편리한 조회

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
        // 1.헤더 가져오기
//        Enumeration<String> headerNames = request.getHeaderNames(); //request.getHeaderNames http 헤더 메시지에 있는 모든 정보를 다꺼내서 다출력할수있다.
//        while(headerNames.hasMoreElements()){ // headerNames 동작했을때 다음요소 있는가?
//            String headerName = headerNames.nextElement();// 다음 요소가 있다면 값을 꺼내라
//            System.out.println(headerName + " : " + headerName);//  값을 출력해라.
//        }
        // 2. 헤더가져오기 간결하게 쓸수있다.
            request.getHeaderNames().asIterator() // asIterator로 바꿀수있다.
                    .forEachRemaining(headerName -> System.out.println(headerName + " : " + headerName));
            // 원하는 헤더 정보보기
        request.getHeaders("connection"); //하나의 데이터 를 볼수있다.

        System.out.println("--- Headers - end ---");
        System.out.println();
    }
    //Header 편리한 조회
    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " + request.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " + request.getServerPort()); //Host 헤더
        System.out.println();
        System.out.println("[Accept-Language 편의 조회]"); request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " +locale));
                        System.out.println("request.getLocale() = " + request.getLocale()); // request.getLocale 가장 위에 있는게 자동으로 뽑힌다.
        System.out.println();
        System.out.println("[cookie 편의 조회]"); if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            } }
        System.out.println();
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " +
                request.getContentType());
        System.out.println("request.getContentLength() = " +
                request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " +
                request.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }
    private void printEtc(HttpServletRequest request) { System.out.println("--- 기타 조회 start ---");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " +
                request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " +
                request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " +
                request.getRemotePort()); //
        System.out.println();
        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " +
                request.getLocalName()); //
        System.out.println("request.getLocalAddr() = " +
                request.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " +
                request.getLocalPort()); //
        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }

}