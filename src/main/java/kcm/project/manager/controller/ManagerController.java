package kcm.project.manager.controller;

import kcm.project.manager.domain.Manager;
import kcm.project.manager.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/toilet/manager")
public class ManagerController {

    @Resource
    ManagerService managerService;

    @GetMapping
    public String join(){
        return "/manager/joinForm";
    }

    @PostMapping
    @ResponseBody
    public String join(@ModelAttribute Manager manager){
        Manager joinManager = managerService.join(manager);
        return "ok";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String findById(@PathVariable long managerId, Model model){
        Manager findManager = managerService.findById(managerId);
        model.addAttribute("manager", findManager);
        return "ok";
    }

}
