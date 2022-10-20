package xyz.liyouxiu.crm.workbench.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.liyouxiu.crm.settings.domian.User;
import xyz.liyouxiu.crm.settings.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/10/20 13:44
 */
@Controller
public class ActivityController {
    @Autowired
    private UserService userService;

    @RequestMapping("/workbench/activity/index.do")
    public String index(HttpServletRequest request) {
        //调用service方法
        List<User> userList = userService.queryAllUser();
        //将数据保存到request
        request.setAttribute("userList",userList);
        //请求转发到市场活动的主页面
        return "workbench/activity/index";
    }
}
