package xyz.liyouxiu.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liyouxiu
 * @date 2022/10/14 15:52
 */
@Controller
public class IndexController {
    /**
     * 访问首页
     * @return
     */
    @RequestMapping("/")
    public String index(){
        //请求转发
        return "index";
    }
}
