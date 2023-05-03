package oss.servlet.web.frontcontroller.v3.controller;

import oss.servlet.web.frontcontroller.ModelVeiw;
import oss.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelVeiw process(Map<String, String> paramMap) {
        return new ModelVeiw("new-form"); //jsp파일 이름만 넣으면 된다.
     }
}
