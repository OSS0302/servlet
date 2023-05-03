package oss.servlet.web.frontcontroller.v3;

import oss.servlet.web.frontcontroller.ModelVeiw;

import java.util.Map;

public interface ControllerV3 {

    ModelVeiw process(Map<String,String>paramMap);

}
