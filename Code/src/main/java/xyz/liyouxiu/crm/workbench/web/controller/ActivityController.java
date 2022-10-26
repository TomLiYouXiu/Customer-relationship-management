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
import java.util.*;

/**
 * @author liyouxiu
 * @date 2022/10/20 13:44
 */
@Controller
public class ActivityController {


    @Autowired
    private ActivityService activityService;
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
        return returnObject;
    }
    @RequestMapping("/workbench/activity/queryActivityByConditionForPage.do")
    @ResponseBody
    public Object queryActivityByConditionForPage(String name,String owner,String startDate,String endDate,
                                                  int pageNo,int pageSize){
        //封装参数
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name",name);
        map.put("owner",owner);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        map.put("beginNO",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);

        //调用service方法查询数据
        List<Activity> activityList = activityService.queryActivityByConditionForPage(map);
        int totalRows = activityService.queryCountOfActivityByCondition(map);
        //根据查询结果，生成响应信息
        Map<String,Object> retMap=new HashMap<>();
        retMap.put("activityList",activityList);
        retMap.put("totalRows",totalRows);
        return retMap;
    }
    @RequestMapping("/workbench/activity/deleteActivityIds.do")
    @ResponseBody
    public Object deleteActivityIds(String[] id){
        ReturnObject returnObject = new ReturnObject();
       try{
           //调用service方法删除市场活动
           int ret = activityService.deleteActivityByIDs(id);
           if(ret>0){
               returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
           }else{
               returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
               returnObject.setMessage("系统忙请稍后~~~~");
           }
       }catch (Exception e){
           e.printStackTrace();
       }

        return returnObject;
    }

    @RequestMapping("/workbench/activity/queryActivityById.do")
    @ResponseBody
    public Object queryActivityById(String id){
        //调用service方法，查询市场活动
        Activity activity=activityService.queryActivityById(id);
        //根据查询结果，返回响应信息
        return activity;
    }
    @RequestMapping("/workbench/activity/saveEditActivity.do")
    @ResponseBody
    public Object saveEditActivity(Activity activity,HttpSession session){
        //封装参数
        activity.setEditTime(DateUtils.formatDateTime(new Date()));
        User user = (User)session.getAttribute(Contants.SESSION_USER);
        activity.setEditBy(user.getId());
        ReturnObject returnObject=new ReturnObject();
       try {
           //调用service方法保存修改市场活动
           int ret = activityService.saveEditActivity(activity);
            if (ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统忙请稍后~~~~~");
            }
       }catch (Exception e){
           e.printStackTrace();
           returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
           returnObject.setMessage("系统忙请稍后~~~~~");
       }
       return returnObject;
    }
}
