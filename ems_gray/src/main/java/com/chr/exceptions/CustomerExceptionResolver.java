package com.chr.exceptions;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

public class CustomerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();


        if(e instanceof  RuntimeException){
            try {
                modelAndView.setViewName("redirect:/ems/500.jsp?msg="+URLEncoder.encode(e.getMessage(),"UTF-8"));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }else{
            modelAndView.setViewName("redirect:/ems/index.jsp");
        }

        return modelAndView;
    }
}
