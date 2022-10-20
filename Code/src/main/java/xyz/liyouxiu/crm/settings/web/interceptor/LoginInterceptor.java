package xyz.liyouxiu.crm.settings.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import xyz.liyouxiu.crm.commons.contants.Contants;
import xyz.liyouxiu.crm.settings.domian.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author liyouxiu
 * @date 2022/10/19 13:55
 * 拦截器进行登录验证
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //登录验证
        //如果没有登录成功，则跳转到登录页面
        HttpSession session = httpServletRequest.getSession();
        User user = (User)session.getAttribute(Contants.SESSION_USER);
        if(user==null){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath());//自己手动重定向时，url必须手动添加项目名称
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
