package com.chr.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MustLoginInterceptor implements HandlerInterceptor {
    /**
     * 请求到达先执行
     * @param request 当前请求对象
     * @param response 当前响应对象
     * @param o 当前请求的方法对象
     * @return true 放行  false 拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if(user==null){
            //跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/ems/login.jsp");
            return false;
        }
        return true;
    }

    /**
     * 过程中执行 Controller正常执行才会执行
     * @param request 当前请求对象
     * @param response 当前响应对象
     * @param o 当前请求的方法对象
     * @param modelAndView 当前访问控制器方法的modelAndView 可以用来加入额外的值
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 最后处理 无论Controller是否异常 都会执行
     * @param request 当前请求对象
     * @param response 当前响应对象
     * @param o 当前请求的方法对象
     * @param e 当前访问控制器出现异常的异常对象
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        if(e!=null){
            System.out.println("异常信息："+e.getMessage());
        }
    }
}
