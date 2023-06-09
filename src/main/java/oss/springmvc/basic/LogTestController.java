package oss.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //private final Logger  log = LoggerFactory.getLogger(getClass()) 자동으로 적용 시켜주며 을 롬복에서 편리하게 해주는 어노테이션
@RestController // @RestController : 반환 할때 스트링이 그냥 반환이 된다.
public class LogTestController {


    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);
        log.info("info log="+name); // 문자 더하기 여서 상관없다.
        log.trace("trace log={}", name);
        log.debug("debug log={}", name); //현재 로그는 디버그
        log.info(" info log={}", name); // 비즈니스 정보
        log.warn(" warn log={}", name); // 경고
        log.error("error log={}", name); // 에러


        return "ok";

    }
}
