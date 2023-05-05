package oss.servlet.web.frontcontroller.v5.adapter;



import oss.servlet.web.frontcontroller.ModelVeiw;
import oss.servlet.web.frontcontroller.MyView;
import oss.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import oss.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import oss.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@WebServlet(name = "frontControllerServletV5",urlPatterns ="/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {
    //private final Map<String, ControllerV4> contrllerMap =new HashMap<>(); //기존 방식 싱글톤으로 한개만 지원된다.
    private final Map<String, Object> handlerMappingMap = new HashMap<>();//모든 컨트롤러를 지원하기 위해서 object를 쓴다.
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();

    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());//핸들러 어텝터 ControllerV3HandlerAdapter를 추가해주자
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object handler = getHandler(request); // 로직이 간결 해졌다 . 요청정보를 찾아서 찾아오세요
        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);

        ModelVeiw mv = adapter.handle(request, response, handler);// 요청 응답 핸들러를 모델뷰로 반환해라


        //paramMap // 디테일 한 로직


        String viewName = mv.getViewName();// 논리이름 예를 들면 new -form 처럼
        MyView myView = viewResolver(viewName); // 메서드 만드는 단축키: option+command+m  뷰를 해결 해준다.

        myView .render(mv.getModel(),request,response);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI(); // 요청된 url를 가지온 다음에
        // 여러개의 컨트롤러 사용하기 위해서는 object로 가져와야한다.
      return handlerMappingMap.get(requestURI); // 요청된requestURI 가 오면 handlerMappingMap을 보내서 handler 를 찾는다.
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        MyHandlerAdapter antherAnther;
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) { //만약에 어텁터가 핸들러를 지원하는 제어문
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler=" + handler);
    }
    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
