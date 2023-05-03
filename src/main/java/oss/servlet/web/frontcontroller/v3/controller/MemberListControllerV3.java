package oss.servlet.web.frontcontroller.v3.controller;

import oss.servlet.domain.member.Member;
import oss.servlet.domain.member.MemberRepository;
import oss.servlet.web.frontcontroller.ModelVeiw;
import oss.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelVeiw process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();// memberRepository 이름과 나이를 조회하겠다.
        ModelVeiw mv =new ModelVeiw("members");
        mv.getModel().put("members",members);
        return mv;

    }
}
