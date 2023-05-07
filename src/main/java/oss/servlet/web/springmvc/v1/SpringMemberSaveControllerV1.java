package oss.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import oss.servlet.domain.member.Member;
import oss.servlet.domain.member.MemberRepository;


import java.util.Map;
@Controller

public class SpringMemberSaveControllerV1  {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(Map<String, String> paramMap) {
        String username = paramMap.get("username"); //데이터를 꺼내서 사용하면된다.
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username,age);
        memberRepository.save(member); // 이름과 나이를 저장한다.

        //모델 인스턴스 를 만들어서 멤버의 데이터를  modelView 를 넣는다.
        ModelAndView mv =new ModelAndView("save-result");
        //mv.getModel().put("member",member); //이거 사용해도 되지만
        mv.addObject("member",member);
        return mv; // modelVeiw로 반환하다.


    }
}