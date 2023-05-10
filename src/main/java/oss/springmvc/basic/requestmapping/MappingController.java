package oss.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //  @RestController @Controller 는 반환 값이 String 이면 뷰 이름으로 인식된다. 그래서 뷰를 찾고 뷰가 랜더링 된다.

public class MappingController {

    private Logger log= LoggerFactory.getLogger(getClass());

    @RequestMapping({"/hello-basic","hello-basic1"})
    public String helloBasic(){
        log.info("helloBasic");
        return  "ok";
    }
}
