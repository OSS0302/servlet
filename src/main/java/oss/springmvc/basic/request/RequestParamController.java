package oss.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamv1(HttpServletRequest request , HttpServletResponse response)throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={},age={}",username,age );

        response.getWriter().write("ok");
    }

    /**
     * @RequestParam 사용
     * - 파라미터 이름으로 바인딩
     **/

    @ResponseBody //View 조회를 무시하고, HTTP message body에 직접 해당 내용 입력
    @RequestMapping("/request-param-v2")
    public String requestParamv2(
            @RequestParam("username")String username,
            @RequestParam("age")int age){

        log.info("username={},age = {}",username, age); //로그로 유저이름과 나이 뽑아내기

                return "ok";// 일반적으로 반환 하면 뷰 리졸버 찾기 때문에 ok라는 html 를 찾는다.
    }
    /**
     * @RequestParam 사용
     * HTTP 파라미터 이름이 변수 이름과 같으면 @RequestParam(name="xx") 생략 가능 */
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username, // RequestParam를 이름을 생략이가능하다.
            @RequestParam int age) {       // 나이도 생략 가능하다.
        log.info("username={}, age={}", username, age); // 파라미터 네임같아야지 생략이 가능하다
        return "ok";
    }


}
