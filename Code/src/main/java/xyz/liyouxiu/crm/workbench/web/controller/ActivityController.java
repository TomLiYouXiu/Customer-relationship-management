package xyz.liyouxiu.crm.workbench.web.controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xyz.liyouxiu.crm.commons.contants.Contants;
import xyz.liyouxiu.crm.commons.domain.ReturnObject;
import xyz.liyouxiu.crm.commons.utils.DateUtils;
import xyz.liyouxiu.crm.commons.utils.HSSFUtils;
import xyz.liyouxiu.crm.commons.utils.UUIDUtils;
import xyz.liyouxiu.crm.settings.domian.User;
import xyz.liyouxiu.crm.settings.service.UserService;
import xyz.liyouxiu.crm.workbench.domian.Activity;
import xyz.liyouxiu.crm.workbench.domian.ActivityRemark;
import xyz.liyouxiu.crm.workbench.service.ActivityRemarkService;
import xyz.liyouxiu.crm.workbench.service.ActivityService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
    @Autowired
    private ActivityRemarkService activityRemarkService;

    @RequestMapping("/workbench/activity/index.do")
    public String index(HttpServletRequest request) {
        //调用service方法
        List<User> userList = userService.queryAllUser();
        //将数据保存到request
        request.setAttribute("userList", userList);
        //请求转发到市场活动的主页面
        return "workbench/activity/index";
    }

    @RequestMapping("/workbench/activity/saveCreateActivity.do")
    @ResponseBody
    public Object saveCreateActivity(Activity activity, HttpSession session) {
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        //封装参数
        activity.setId(UUIDUtils.getUUID());
        activity.setCreateTime(DateUtils.formatDateTime(new Date()));
        activity.setCreateBy(user.getId());
        ReturnObject returnObject = new ReturnObject();
        try {
            //调用service层方法保存数据
            int i = activityService.saveCreateActivity(activity);
            if (i > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统忙，请稍后重试~~~~~");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnObject;
    }

    @RequestMapping("/workbench/activity/queryActivityByConditionForPage.do")
    @ResponseBody
    public Object queryActivityByConditionForPage(String name, String owner, String startDate, String endDate,
                                                  int pageNo, int pageSize) {
        //封装参数
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("owner", owner);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("beginNO", (pageNo - 1) * pageSize);
        map.put("pageSize", pageSize);

        //调用service方法查询数据
        List<Activity> activityList = activityService.queryActivityByConditionForPage(map);
        int totalRows = activityService.queryCountOfActivityByCondition(map);
        //根据查询结果，生成响应信息
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("activityList", activityList);
        retMap.put("totalRows", totalRows);
        return retMap;
    }

    @RequestMapping("/workbench/activity/deleteActivityIds.do")
    @ResponseBody
    public Object deleteActivityIds(String[] id) {
        ReturnObject returnObject = new ReturnObject();
        try {
            //调用service方法删除市场活动
            int ret = activityService.deleteActivityByIDs(id);
            if (ret > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统忙请稍后~~~~");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnObject;
    }

    @RequestMapping("/workbench/activity/queryActivityById.do")
    @ResponseBody
    public Object queryActivityById(String id) {
        //调用service方法，查询市场活动
        Activity activity = activityService.queryActivityById(id);
        //根据查询结果，返回响应信息
        return activity;
    }

    @RequestMapping("/workbench/activity/saveEditActivity.do")
    @ResponseBody
    public Object saveEditActivity(Activity activity, HttpSession session) {
        //封装参数
        activity.setEditTime(DateUtils.formatDateTime(new Date()));
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        activity.setEditBy(user.getId());
        ReturnObject returnObject = new ReturnObject();
        try {
            //调用service方法保存修改市场活动
            int ret = activityService.saveEditActivity(activity);
            if (ret > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统忙请稍后~~~~~");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统忙请稍后~~~~~");
        }
        return returnObject;
    }

    @RequestMapping("/workbench/activity/exportAllActivity.do")
    public void exportAllActivity(HttpServletResponse response) throws Exception {
        //调用service方法，查询所有的市场活动
        List<Activity> activities = activityService.queryActivity();
        //创建excel文件，并且把activities写入到Excel文件中
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("市场活动列表");
        HSSFRow row = sheet.createRow(0);

        HSSFCell cell = row.createCell(0);
        cell.setCellValue("ID");
        cell = row.createCell(1);
        cell.setCellValue("所有者");
        cell = row.createCell(2);
        cell.setCellValue("名称");
        cell = row.createCell(3);
        cell.setCellValue("开始日期");
        cell = row.createCell(4);
        cell.setCellValue("结束日期");
        cell = row.createCell(5);
        cell.setCellValue("成本");
        cell = row.createCell(6);
        cell.setCellValue("描述");
        cell = row.createCell(7);
        cell.setCellValue("创建时间");
        cell = row.createCell(8);
        cell.setCellValue("创建者");
        cell = row.createCell(9);
        cell.setCellValue("修改时间");
        cell = row.createCell(10);
        cell.setCellValue("修改者");

        //遍历，创建行
        if (activities != null && activities.size() > 0) {
            Activity activity = null;
            for (int i = 0; i < activities.size(); i++) {
                activity = activities.get(i);
                row = sheet.createRow(i + 1);
                //每一行有11列，每一列的数据从遍历的书中获取
                cell = row.createCell(0);
                cell.setCellValue(activity.getId());
                cell = row.createCell(1);
                cell.setCellValue(activity.getOwner());
                cell = row.createCell(2);
                cell.setCellValue(activity.getName());
                cell = row.createCell(3);
                cell.setCellValue(activity.getStartDate());
                cell = row.createCell(4);
                cell.setCellValue(activity.getEndDate());
                cell = row.createCell(5);
                cell.setCellValue(activity.getCost());
                cell = row.createCell(6);
                cell.setCellValue(activity.getDescription());
                cell = row.createCell(7);
                cell.setCellValue(activity.getCreateTime());
                cell = row.createCell(8);
                cell.setCellValue(activity.getCreateBy());
                cell = row.createCell(9);
                cell.setCellValue(activity.getEditTime());
                cell = row.createCell(10);
                cell.setCellValue(activity.getEditBy());
            }
        }
        //根据wb生成Excel文件
        //生成的文件下载到客户端
        //设置响应信息
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.addHeader("Content-Disposition", "attachmenta;filename=activity.xls");
        OutputStream out = response.getOutputStream();
//        InputStream is = new FileInputStream(wb);
//        byte[] buff=new byte[1024];
//        int len=0;
//        while((len=is.read(buff))!=-1){
//            out.write(buff,0,len);
//        }
//        //关闭资源
//        is.close();
        wb.write(out);
        wb.close();
        out.flush();
    }

    @RequestMapping("/workbench/activity/importActivity.do")
    @ResponseBody
    public Object importActivity(MultipartFile activityFile, HttpSession session, String userName) {
        System.out.println(userName);
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        ReturnObject returnObject = new ReturnObject();
        try {
//            String originalFilename = System.currentTimeMillis()+activityFile.getOriginalFilename();
//            File file = new File("E:\\Customer-relationship-management\\file",originalFilename);
//            activityFile.transferTo(file);

            //解析Excel文件，获取文件的数据，并且封装为activityList
//            InputStream is = new FileInputStream("E:\\Customer-relationship-management\\file\\" + originalFilename);

            InputStream is = activityFile.getInputStream();

            HSSFWorkbook wb = new HSSFWorkbook(is);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row = null;
            HSSFCell cell = null;
            Activity activity = null;
            List<Activity> activityList = new ArrayList<Activity>();
            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                activity = new Activity();
                activity.setId(UUIDUtils.getUUID());
                activity.setOwner(user.getId());
                activity.setCreateTime(DateUtils.formatDateTime(new Date()));
                activity.setCreateBy(user.getId());
                for (int j = 0; j < row.getFirstCellNum(); j++) {
                    cell = row.getCell(j);
                    String cellValue = HSSFUtils.getCellValueForStr(cell);
                    if (j == 0) {
                        activity.setName(cellValue);
                    } else if (j == 1) {
                        activity.setStartDate(cellValue);
                    } else if (j == 2) {
                        activity.setEndDate(cellValue);
                    } else if (j == 3) {
                        activity.setCost(cellValue);
                    } else if (j == 4) {
                        activity.setDescription(cellValue);
                    }
                }
                //所有的列都疯转完之后放入List表中
                activityList.add(activity);
            }
            //调用service层方法，保存市场活动
            int ret = activityService.saveCreateActivityByList(activityList);
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setReData(ret);
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统忙，请稍后~~~~");
        }
        return returnObject;
    }

    @RequestMapping("/workbench/activity/detailActivity.do")
    public String detailActivity(String id, HttpServletRequest request) {
        //调用service方法查询数据
        Activity activity = activityService.queryActivityForDetailById(id);
        List<ActivityRemark> remarkList = activityRemarkService.queryActivityForDetailByActivityId(activity.getId());

        //把数据保存到作用域request中
        request.setAttribute("activity", activity);
        request.setAttribute("remarkList", remarkList);

        //请求转发
        return "workbench/activity/detail";
    }
}