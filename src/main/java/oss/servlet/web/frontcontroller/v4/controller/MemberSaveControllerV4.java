package oss.servlet.web.frontcontroller.v4.controller;

import oss.servlet.domain.member.Member;
import oss.servlet.domain.member.MemberRepository;


import oss.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
            String username = paramMap.get("username"); //데이터를 꺼내서 사용하면된다.
            int age = Integer.parseInt(paramMap.get("age"));
            // 비지니스 로직 실행하고
            Member member = new Member(username,age);
            memberRepository.save(member); // 이름과 나이를 저장한다.

            //v4 에서는 v3 할필요는없고 그냥 model 객체안에 member의 데이터 넣고 save-reslut로 반환하면된다.
            model.put("member",member);
            return "save-result";

    }
}
