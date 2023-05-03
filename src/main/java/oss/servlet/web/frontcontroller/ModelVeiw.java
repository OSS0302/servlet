package oss.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelVeiw {
    private String viewName;
    private Map<String, Object> model = new HashMap<>(); // model에서 put 해서 원하는 데이터 꺼내서 사용한다.

    public ModelVeiw(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
