package xyz.liyouxiu.crm.workbench.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liyouxiu
 * @date 2022/10/20 13:23
 */
@Controller
public class MainController {
    @RequestMapping("/workbench/main/index.do")
    public String index() {
        //跳转到main/index
        return "workbench/main/index";
    }

}
