package oss.servlet.web.springmvc.v3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import oss.servlet.domain.member.Member;
import oss.servlet.domain.member.MemberRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public String newForm(){
        return "new-form";

    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username"); // String 타입으로 데이터 이름 을 요청한다
        int age = Integer.parseInt(request.getParameter("age")); //int 타입으로 데이터 나이 을 요청한다

        Member member = new Member(username,age); // 이름 나이를 객체 생성

        memberRepository.save(member);// 멤버를 저장한다.

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member",member);
        return mv;
    }

    @RequestMapping
    public ModelAndView members() {
        List<Member> members = memberRepository.findAll();// memberRepository 이름과 나이를 조회하겠다.
        ModelAndView mv = new ModelAndView("members");
        //mv.getModel().put("members", members);
        mv.addObject("members", members);
        return mv;
    }


}
