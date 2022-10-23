package xyz.liyouxiu.crm.workbench.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liyouxiu.crm.workbench.domian.Activity;
import xyz.liyouxiu.crm.workbench.mapper.ActivityMapper;
import xyz.liyouxiu.crm.workbench.service.ActivityService;

/**
 * @author liyouxiu
 * @date 2022/10/23 9:56
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public int saveCreateActivity(Activity activity) {
        return activityMapper.insertActivity(activity);
    }
}
