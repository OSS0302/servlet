package oss.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyView {
    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }
    // JSP 이동하고 이런거를 랜더링한다. 포워트 해서 이동을 하던 뷰를 만드는 행위를 랜더링한다.
    public void render(HttpServletRequest request ,HttpServletResponse response) throws ServletException , IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response); // 포워트가 끝이난다.

    }
}
