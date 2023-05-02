package oss.servlet.web.frontcontroller.v2.controller;

import oss.servlet.domain.member.Member;
import oss.servlet.domain.member.MemberRepository;
import oss.servlet.web.frontcontroller.MyView;
import oss.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //이제 각 컨트롤러는 복잡한 dispatcher.forward() 를 직접 생성해서 호출하지 않아도 된다. 단순히 MyView 객체를 생성하고 거기에 뷰 이름만 넣고 반환하면 된다.
            List<Member> members = memberRepository.findAll();
            request.setAttribute("members", members);
//            String viewPath = "/WEB-INF/views/members.jsp";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//            dispatcher.forward(request, response);
            return new MyView("/WEB-INF/views/members.jsp");
    }
}
