package oss.servlet.web.frontcontroller.v4;

import oss.servlet.web.frontcontroller.ModelVeiw;
import oss.servlet.web.frontcontroller.MyView;
import oss.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import oss.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import oss.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "frontControllerServletV4", urlPatterns ="/front-controller/v4/*")
  public class FrontControllerServletV4 extends HttpServlet {
    private Map<String, ControllerV4> controllerMap = new HashMap<>();


    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4()
        );
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV4  controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //paramMap // 디테일 한 로직
        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();
        String viewName = controller.process(paramMap, model);// 컨트롤러 동작중에 모델값을 넣으면 아래서 그냥 사용하면된다.


        MyView myView = viewResolver(viewName); // 메서드 만드는 단축키: option+command+m  뷰를 해결 해준다.

        myView .render(model,request,response); // v3 에서 는 모델뷰에서 꺼냈지만 v4에서는 모델에서 제공한다.
    }
    // 일일히 반환할때 경로를 작성하는것이 아니라 논리이름 으로 반환 할 수있는 메서드 viewResolver 를 생성했다.
    private  MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");

    }

    private  Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String>paramMap = new HashMap<>(); // paramMap를 먼저 만들고
        request.getParameterNames().asIterator() // 모든 getParameterNames 를 가져온다.
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName))); //put(paramName(이름), request.getRequestURI(paramName 값을 나타낸다.)));
        return paramMap;
    }
}
