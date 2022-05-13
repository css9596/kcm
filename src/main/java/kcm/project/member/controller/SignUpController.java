package kcm.project.member.controller;

import kcm.project.member.service.SignUpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


/**
 * 회원가입 controller
 * */
@Controller
@RequestMapping(value = "/member")

public class SignUpController {

    @Resource (name = "signUpService")
    private SignUpService signUpService;

    // 회원가입 메소드
    @RequestMapping(value = "/signUp")
    public String SignUp(Model model){
        model.addAttribute("test","signUpTest");
        String errorMsg = "";

        //기 회원 여부 조회
        String errorCode = signUpService.selectMember();


        model.addAttribute("ERROR_CODE", errorCode);

        return "/member/signUp/signUp";
    }
}
