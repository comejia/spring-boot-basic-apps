package com.springboot.interceptor.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod controller = (HandlerMethod) handler;
        logger.info("LoadingTimeInterceptor: preHandle() entrando..." + controller.getMethod().getName());

        long start = System.currentTimeMillis();
        request.setAttribute("start", start);

        Random random = new Random();
        Thread.sleep(random.nextInt(500));

        /*Map<String, String> data = new HashMap<>();
        data.put("error", "no tiene acceso a la pagina");
        data.put("date", LocalDateTime.now().toString());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(data);
        response.setContentType("application/json");
        response.setStatus(401);
        response.getWriter().write(json);
        return false;*/

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod controller = (HandlerMethod) handler;

        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        long result = end - start;

        logger.info("Tiempo transcurrido: " + result + " milisegundos!");
        logger.info("LoadingTimeInterceptor: postHandle() saliendo..." + controller.getMethod().getName());
    }
}
