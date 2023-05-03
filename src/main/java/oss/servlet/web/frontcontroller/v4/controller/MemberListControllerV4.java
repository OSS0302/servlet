package oss.servlet.web.frontcontroller.v4.controller;

import oss.servlet.domain.member.Member;
import oss.servlet.domain.member.MemberRepository;
import oss.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {

        List<Member> members = memberRepository.findAll();// memberRepository 이름과 나이를 조회하겠다.
        // 조회도 마찬가지로  put 해서 멤버 데이터를 반환하면된다.
        model.put("member",members);
        return "members";
    }
}
