package oss.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import oss.servlet.basic.request.HelloData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4( String username,int age) { //요청 파라미터 이름과 같으면 @RequestParam 의 이름이 생략이 가능하다.
        log.info("username={}, age={}", username, age);
        return "ok";
    }
    //  @RequestParam (required = ture) 기본값이다 무조건 RequestParam 값이 있어야한다. 인그러면  bad required 오류가난다.
    // @RequestParam (required = false) 값이 없어도 된다.
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam (required = false)String username,
            @RequestParam (required = false) Integer age) {  // 자바는 int =null 를 넣을 수없다.
        //int a = null; //컴파일 오류나서  안된다.
        //Integer =null; 자바에서 객체는 null 들어갈수있다.
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // 빈문자에도 설정된 geust 값이 지정된다.
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam (required = false,defaultValue ="guest" )String username, // 회원 이름이 만약에 없다면 게스트로 하겠다.
            @RequestParam (required = false,defaultValue = "-1") Integer age) {  // 나이가 없다면 -1 로 하겠다.

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String,Object> paramMap){ // 맵을 통해서 이름을 스트링으로 나이를 객체로 해서
        // paramMap.get 이름과 나이를 가져오면 된다.
        log.info("username={}, age={}",paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@RequestParam String username , @RequestParam int age) {
        HelloData helloData = new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);

        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        log.info("helloData={}",helloData);
        return "ok";
    }

}
