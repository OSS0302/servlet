package oss.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j //log를 찍을 수있다.
@RestController // 응답 값을 뷰를 찾는게 아니고 바로 문자 그대로 http 받아서 사용한다.
public class requestHeaderController {
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String,String >headerMap, // MAP과 유사한데, 하나의 키에 여러 값을 받을 수 있다.
                          @RequestHeader("host")String host, // 헤더의 이름을 맵핑한다..
                          @CookieValue(value= "myCookie",required = false)String cookie
                          ){ // 현시점에서는 쿠키가 없어서 쿠키가 없다.
                            log.info("request={}", request);
                            log.info("response={}", response);
                            log.info("httpMethod={}", httpMethod);
                            log.info("locale={}", locale);
                            log.info("headerMap={}", headerMap);
                            log.info("header host={}", host);
                            log.info("myCookie={}", cookie);

                            return "ok";
    }
}
