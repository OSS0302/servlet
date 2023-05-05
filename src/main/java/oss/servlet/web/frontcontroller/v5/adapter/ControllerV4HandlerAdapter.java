package oss.servlet.web.frontcontroller.v5.adapter;

import oss.servlet.web.frontcontroller.ModelVeiw;
import oss.servlet.web.frontcontroller.v4.ControllerV4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements  MyHandlerAdapter{
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4); // 핸들러가 컨트롤러v4 를 지원하는지 확인을 한다.
    }

    @Override
    public ModelVeiw handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        // 캐스팅을 먼저 해야한다.
        ControllerV4 controller = (ControllerV4) handler;
        Map<String,String>paramMap = createParamMap(request);
        HashMap<String, Object> model = new HashMap<>();
        String viewName = controller.process(paramMap, model);// 파라미터 와 맵을 받는다.

        ModelVeiw mv = new ModelVeiw(viewName); //모델뷰도 세팅해주고
        mv.setModel(model);// 모델도 세팅해준다.


        return mv;
    }
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
