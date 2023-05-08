package oss.servlet.web.springmvc.v3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String save(
        @RequestParam("username")String username ,//@RequestParam를 직접 받을 수도있다.
        @RequestParam("age") int age,
        Model model) {

        Member member = new Member(username,age); // 이름 나이를 객체 생성

        memberRepository.save(member);// 멤버를 저장한다.

        model.addAttribute("member",member); // 모델에 데이터 실어서 보낸다.
        return "save-result"; //save-result로 반환
    }

    @RequestMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();// memberRepository 이름과 나이를 조회하겠다.

        model.addAttribute("members",members); // 모델 데이터 를 실어서 보내면된다.
        return "members";
    }


}
