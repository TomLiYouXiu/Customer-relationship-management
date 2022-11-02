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
import xyz.liyouxiu.crm.workbench.domian.ActivityRemark;
import xyz.liyouxiu.crm.workbench.service.ActivityRemarkService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author liyouxiu
 * @date 2022/10/31 15:53
 */
@Controller
public class ActivityRemarkController {
    @Autowired
    private ActivityRemarkService activityRemarkService;
    @RequestMapping("/workbench/activity/saveCreateActivityRemark.do")
    @ResponseBody
    public Object saveCreateActivityRemark(ActivityRemark activityRemark, HttpSession session){
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        //封装参数
        activityRemark.setId(UUIDUtils.getUUID());
        activityRemark.setCreateTime(DateUtils.formatDateTime(new Date()));
        activityRemark.setCreateBy(user.getId());
        activityRemark.setEditFlag(Contants.REMARK_EDIT_FLAG_NO_EDITED);
        ReturnObject returnObject = new ReturnObject();
        try{
            //调用service方法，保存创建的市场活动备注
            int i = activityRemarkService.saveCreateActivityRemark(activityRemark);
            if(i>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setReData(activityRemark);
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统忙，请稍后重试~~~~~");
            }
        }catch(Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统忙，请稍后重试~~~~~");
        }
        return returnObject;
    }

    @RequestMapping("/workbench/activity/deleteActivityRemarkById.do")
    @ResponseBody
    public Object deleteActivityRemarkById(String id){
        ReturnObject returnObject = new ReturnObject();
       try{
           //调用service方法删除数据
           int i = activityRemarkService.deleteActivityRemarkById(id);
           if(i>0){
               returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
           }else{
               returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
               returnObject.setMessage("系统忙请稍后~~~");
           }
       }catch (Exception e){
           e.printStackTrace();
           returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
           returnObject.setMessage("系统忙请稍后~~~");
       }
       return returnObject;
    }

    @RequestMapping("/workbench/activity/saveEditActivityRemark.do")
    @ResponseBody
    public Object saveEditActivityRemark(ActivityRemark activityRemark,HttpSession session){
        User user =(User)session.getAttribute(Contants.SESSION_USER);
        //封装参数
        activityRemark.setEditTime(DateUtils.formatDateTime(new Date()));
        activityRemark.setEditBy(user.getId());
        activityRemark.setEditFlag(Contants.REMARK_EDIT_FLAG_YES_EDITED);
        ReturnObject returnObject = new ReturnObject();
        try {
            //调用service
            int i = activityRemarkService.saveEditActivityRemark(activityRemark);
            if(i>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setReData(activityRemark);
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统忙,请稍后");
            }
        }catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统忙,请稍后");
        }
        return returnObject;
    }
}
