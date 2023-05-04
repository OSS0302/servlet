package oss.servlet.web.frontcontroller.v5.adapter;

import oss.servlet.web.frontcontroller.ModelVeiw;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter  { //handler는 컨트롤러를 말한다. 어댑터가 해당 컨트롤러를 처리할 수 있는지 판단하는 메서드다.
    boolean supports(Object handler);
    ModelVeiw handle(HttpServletRequest request, HttpServletResponse response,
                     Object handler) throws ServletException, IOException;
}
