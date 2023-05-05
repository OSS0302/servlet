package oss.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component("/springmvc/old-controller") //스프링 빈에 이름은 "/springmvc/old-controller" 이렇게 된다. 빈이름을 url
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 작동이 되는지 확인
        System.out.println("OldController.handleRequest");
        return  null;
    }
}
