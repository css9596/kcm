package kcm.project.member.controller;

import kcm.project.member.service.SignUpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/member")
public class SignUpController {

    @Resource (name = "signUpService")
    private SignUpService signUpService;

    // 회원가입 메소드
    public String SignUp(Model model){

        return "";
    }
}
