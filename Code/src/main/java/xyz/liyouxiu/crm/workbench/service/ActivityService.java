package xyz.liyouxiu.crm.workbench.service;

import xyz.liyouxiu.crm.workbench.domian.Activity;

import java.util.List;
import java.util.Map;

/**
 * @author liyouxiu
 * @date 2022/10/23 9:54
 */
public interface ActivityService {
    int saveCreateActivity(Activity activity);

    List<Activity> queryActivityByConditionForPage(Map<String,Object> map);

    int queryCountOfActivityByCondition(Map<String, Object> map);

    int deleteActivityByIDs(String[] ids);

    Activity queryActivityById(String id);

    int saveEditActivity(Activity activity);

    List<Activity> queryActivity();

    int saveCreateActivityByList(List<Activity> activityList);

    Activity queryActivityForDetailById(String id);
}
