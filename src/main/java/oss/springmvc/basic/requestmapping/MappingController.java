package oss.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 편리한 축약 애노테이션 (코드보기) * @GetMapping
 * @PostMapping
 * @PutMapping
 * @DeleteMapping
 * @PatchMapping
 */
@RestController //  @RestController @Controller 는 반환 값이 String 이면 뷰 이름으로 인식된다. 그래서 뷰를 찾고 뷰가 랜더링 된다.

public class MappingController {

    private Logger log= LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic",method = RequestMethod.GET )
    public String helloBasic(){
        log.info("helloBasic");
        return  "ok";
    }
}
