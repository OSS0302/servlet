package oss.servlet.web.frontcontroller.v2;

import oss.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {
    MyView   process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException; // MyView를 반환하다.
     //모든 컨트롤러 뷰를 반환한다.
}
