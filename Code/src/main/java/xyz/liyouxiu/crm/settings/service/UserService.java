package xyz.liyouxiu.crm.settings.service;

import xyz.liyouxiu.crm.settings.domian.User;

import java.util.List;
import java.util.Map;

/**
 * @author liyouxiu
 * @date 2022/10/15 16:13
 */
public interface UserService {
    User queryUserByLoginActAndPwd(Map<String,Object> map);

    List<User> queryAllUser();
}
