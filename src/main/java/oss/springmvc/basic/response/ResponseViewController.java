package oss.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView modelAndVie =new ModelAndView("/response/hello")
                .addObject("data","hello!");

        return modelAndVie;
    }

        //@ResponseBody 를 사용하게 되면 response/hello 로 안가고 문자그대로인 response/hello 응답 코드로 나온다.
        @RequestMapping("/response-view-v2")
        public String responseViewV2(Model model){
          model.addAttribute("data","hello!!");

            return "response/hello";
        }
    @RequestMapping("/response-view-v3")
    public void responseViewV3(Model model){
        model.addAttribute("data","hello!!!");


    }

}
