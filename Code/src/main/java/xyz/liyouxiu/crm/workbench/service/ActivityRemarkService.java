package xyz.liyouxiu.crm.workbench.service;

import xyz.liyouxiu.crm.workbench.domian.ActivityRemark;

import java.util.List;

/**
 * @author liyouxiu
 * @date 2022/10/31 10:50
 */
public interface ActivityRemarkService {
    List<ActivityRemark> queryActivityForDetailByActivityId(String activityId);

    int saveCreateActivityRemark(ActivityRemark activityRemark);

    int deleteActivityRemarkById(String id);

    int saveEditActivityRemark(ActivityRemark activityRemark);
}
