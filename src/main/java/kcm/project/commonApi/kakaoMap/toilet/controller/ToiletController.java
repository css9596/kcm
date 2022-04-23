package kcm.project.commonApi.kakaoMap.toilet.controller;

import kcm.project.commonApi.kakaoMap.toilet.service.ToiletService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


/**
 * @author choisungsik
 * @version
 * v1.0 2022.04.23 choisungsik 최초작성
 */
@Controller
@RequestMapping(name = "/toilet")
public class ToiletController {

    @Resource(name = "toiletService")
    private ToiletService toiletService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String ToiletCallMain(Model model){

        /*
        * 기능 구현 List
        * 1. 현재 위치 정보 조회
        * 2. 위치 기반으로 주변 화장실 Location 조회
        * 3. Return
        * */

        System.out.println("toiletMain 인입");

        StringBuffer stringBuffer = toiletService.getToiletData();

        model.addAttribute("result", stringBuffer);

        return "toilet/main";
    }

}
