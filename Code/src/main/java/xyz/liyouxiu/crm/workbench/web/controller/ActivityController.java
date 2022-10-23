package xyz.liyouxiu.crm.workbench.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.liyouxiu.crm.commons.contants.Contants;
import xyz.liyouxiu.crm.commons.domain.ReturnObject;
import xyz.liyouxiu.crm.commons.utils.DateUtils;
import xyz.liyouxiu.crm.commons.utils.UUIDUtils;
import xyz.liyouxiu.crm.settings.domian.User;
import xyz.liyouxiu.crm.settings.service.UserService;
import xyz.liyouxiu.crm.workbench.domian.Activity;
import xyz.liyouxiu.crm.workbench.service.ActivityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author liyouxiu
 * @date 2022/10/20 13:44
 */
@Controller
public class ActivityController {
    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/workbench/activity/index.do")
    public String index(HttpServletRequest request) {
        //调用service方法
        List<User> userList = userService.queryAllUser();
        //将数据保存到request
        request.setAttribute("userList",userList);
        //请求转发到市场活动的主页面
        return "workbench/activity/index";
    }
    @RequestMapping("/workbench/activity/saveCreateActivity.do")
    @ResponseBody
    public Object saveCreateActivity(Activity activity, HttpSession session){
        User user=(User) session.getAttribute(Contants.SESSION_USER);
        //封装参数
        activity.setId(UUIDUtils.getUUID());
        activity.setCreateTime(DateUtils.formatDateTime(new Date()));
        activity.setCreateBy(user.getId());
        ReturnObject returnObject=new ReturnObject();
        try{
            //调用service层方法保存数据
            int i = activityService.saveCreateActivity(activity);
            if(i>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统忙，请稍后重试~~~~~");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
