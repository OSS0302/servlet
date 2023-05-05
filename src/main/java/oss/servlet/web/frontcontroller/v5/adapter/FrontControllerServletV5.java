package oss.servlet.web.frontcontroller.v5.adapter;



import oss.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import oss.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import oss.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5",urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {
    //private final Map<String, ControllerV4> contrllerMap =new HashMap<>(); //기존 방식 싱글톤으로 한개만 지원된다.
    private final Map<String, Object> handlerMappingMap = new HashMap<>();//모든 컨트롤러를 지원하기 위해서 object를 쓴다.
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap ();
        initHandlerAdapters();

    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());        //핸들러 어텝터 ControllerV3HandlerAdapter를 추가해주자
    }

    private void initHandlerMappingMap () {
        handlerMappingMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }
}
