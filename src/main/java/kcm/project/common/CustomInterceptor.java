package kcm.project.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Slf4j
@Component
public class CustomInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 컨트롤러 보내기전
        System.out.println("CustomInterceptor.preHandle Start >>>>>>>>>>>>");

        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();
        log.info("requestURI : {}",requestURI);

        HttpSession session = request.getSession();
        session.setAttribute("userUUid", uuid);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 컨트롤러의 핸들러 처리 후
        System.out.println("CustomInterceptor.postHandle End <<<<<<<<<<<<<");
    }

}
