package kcm.project.member.controller;


import kcm.project.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @Resource (name = "memberService")
    private MemberService memberService;

    //회원가입
    @RequestMapping(value = "/signUp")
    public String signUp(Model model){
        model.addAttribute("test","가입테스트");
        return "redirect:/member/signUp/signUp";
    }

    //회원목록 조회하기
    @RequestMapping(value = "/list")
    public void memList(Model model){
        model.addAttribute("list", memberService.getList());
    }

    //회원상세 조회하기
    @GetMapping("/get")
    public void get(@RequestParam("no") Long no, Model model){
        model.addAttribute("list", memberService.get(no));
    }
    //회원수정

    //회원탈퇴
    public String remove(@RequestParam("no") Long no, RedirectAttributes rttr){
        if(memberService.remove(no)){
            rttr.addFlashAttribute("result", "회원삭제 완료");
        }
        return "redirect:/member/signUp/signUp";
    }
}