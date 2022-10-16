package xyz.liyouxiu.crm.settings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liyouxiu.crm.settings.domian.User;
import xyz.liyouxiu.crm.settings.mapper.UserMapper;
import xyz.liyouxiu.crm.settings.service.UserService;

import java.util.Map;

/**
 * @author liyouxiu
 * @date 2022/10/15 16:15
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User queryUserByLoginActAndPwd(Map<String, Object> map) {
        return userMapper.selectUserByLoginActAndPwd(map);
    }
}
