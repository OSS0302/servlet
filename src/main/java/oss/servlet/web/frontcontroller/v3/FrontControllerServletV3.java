package oss.servlet.web.frontcontroller.v3;

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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns ="/front-controller/v3/*")
  public class FrontControllerServletV3 extends HttpServlet {
    private Map<String, ControllerV3> controllerMap = new HashMap<>();


    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3()
        );
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV3  controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //paramMap // 디테일 한 로직
        Map<String, String> paramMap = createParamMap(request);
        ModelVeiw mv = controller.process(paramMap);
        //"/WEB-INF/views/new-form.jsp과 같다.
        String viewName = mv.getViewName();// 논리이름 예를 들면 new -form 처럼
        MyView myView = viewResolver(viewName); // 메서드 만드는 단축키: option+command+m  뷰를 해결 해준다.

        myView .render(mv.getModel(),request,response);
    }
    // 일일히 반환할때 경로를 작성하는것이 아니라 논리이름 으로 반환 할 수있는 메서드 viewResolver 를 생성했다.
    private  MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views" + viewName + ".jsp");
    }

    private  Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String>paramMap = new HashMap<>(); // paramMap를 먼저 만들고
        request.getParameterNames().asIterator() // 모든 getParameterNames 를 가져온다.
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName))); //put(paramName(이름), request.getRequestURI(paramName 값을 나타낸다.)));
        return paramMap;
    }
}
