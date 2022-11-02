package xyz.liyouxiu.crm.workbench.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.liyouxiu.crm.commons.contants.Contants;
import xyz.liyouxiu.crm.commons.domain.ReturnObject;
import xyz.liyouxiu.crm.commons.utils.DateUtils;
import xyz.liyouxiu.crm.commons.utils.UUIDUtils;
import xyz.liyouxiu.crm.settings.domian.DicValue;
import xyz.liyouxiu.crm.settings.domian.User;
import xyz.liyouxiu.crm.settings.service.DicValueService;
import xyz.liyouxiu.crm.settings.service.UserService;
import xyz.liyouxiu.crm.workbench.domian.Activity;
import xyz.liyouxiu.crm.workbench.domian.Clue;
import xyz.liyouxiu.crm.workbench.domian.ClueRemark;
import xyz.liyouxiu.crm.workbench.service.ActivityService;
import xyz.liyouxiu.crm.workbench.service.ClueRemarkService;
import xyz.liyouxiu.crm.workbench.service.ClueService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/10/26 10:21
 */
@Controller
public class ClueController {
    @Autowired
    private ClueService clueService;
    @Autowired
    private UserService userService;
    @Autowired
    private DicValueService dicValueService;
    @Autowired
    private ClueRemarkService clueRemarkService;
    @Autowired
    private ActivityService activityService;

    //跳转到线索主页面
    @RequestMapping("/workbench/clue/index.do")
    public String index(HttpServletRequest request) {
        //下拉页面里的创建者
        //调用service方法
        List<User> userList = userService.queryAllUser();
        List<DicValue> appellationList = dicValueService.queryDicValueByTypeCode("appellation");
        List<DicValue> clueStateList = dicValueService.queryDicValueByTypeCode("clueState");
        List<DicValue> sourceList = dicValueService.queryDicValueByTypeCode("source");
        //将数据保存到request
        request.setAttribute("userList",userList);
        request.setAttribute("appellationList",appellationList);
        request.setAttribute("clueStateList",clueStateList);
        request.setAttribute("sourceList",sourceList);

        return "workbench/clue/index";
    }

    //创建一个新线索
    @RequestMapping("/workbench/clue/saveCreateClue.do")
    @ResponseBody
    public Object saveCreateClue(Clue clue,HttpSession session){
        //封装参数
        clue.setId(UUIDUtils.getUUID());
        User user=(User) session.getAttribute(Contants.SESSION_USER);
        clue.setCreateBy(user.getId());
        clue.setCreateTime(DateUtils.formatDateTime(new Date()));
        ReturnObject returnObject = new ReturnObject();
        try {
            int i = clueService.saveCreateClue(clue);
            if(i>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统忙，请稍后重试~~~~~");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统忙，请稍后重试~~~~~");
        }
        return returnObject;
    }

    @RequestMapping("/workbench/clue/detailClue.do")
    public String detailClue(String clueId,HttpServletRequest request) {
        //调用service层方法，查询数据
        Clue clue = clueService.queryClueForDetailById(clueId);
        List<ClueRemark> remarkList = clueRemarkService.queryClueRemarkForDetailByClueId(clueId);
        List<Activity> activityList = activityService.queryActivityForDetailByClueId(clueId);

        //把数据保存到request中
        request.setAttribute("clue",clue);
        request.setAttribute("remarkList",remarkList);
        request.setAttribute("activityList",activityList);
        System.out.println(clue);
        //请求转发
        return "workbench/clue/detail";
    }

    //分页显示并在前台显示数据
//    @RequestMapping("/workbench/clue/queryClueByConditionForPage.do")
//    public Object queryClueByConditionForPage(){
//
//    }
}
