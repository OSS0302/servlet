package oss.servlet.web.frontcontroller.v2.controller;

import oss.servlet.web.frontcontroller.MyView;
import oss.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {
    // 중복이 제거 코드가 간결해진다.
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        return new MyView("WEB-INF/views/new-form.jsp"); // command+option+n

    }
}
