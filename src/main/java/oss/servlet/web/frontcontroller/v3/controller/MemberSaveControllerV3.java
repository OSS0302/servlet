package oss.servlet.web.frontcontroller.v3.controller;

import oss.servlet.domain.member.Member;
import oss.servlet.domain.member.MemberRepository;
import oss.servlet.web.frontcontroller.ModelVeiw;
import oss.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelVeiw process(Map<String, String> paramMap) {
        String username = paramMap.get("username"); //데이터를 꺼내서 사용하면된다.
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username,age);
        memberRepository.save(member); // 이름과 나이를 저장한다.

        //모델 인스턴스 를 만들어서 멤버의 데이터를  modelView 를 넣는다.
        ModelVeiw mv =new ModelVeiw("save-result");
        mv.getModel().put("member",member);
        return mv; // modelVeiw로 반환하다.


    }
}
