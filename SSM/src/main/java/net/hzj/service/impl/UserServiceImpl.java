package net.hzj.service.impl;

import net.hzj.dao.UserDao;
import net.hzj.entity.User;
import net.hzj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Class:        UserServiceImpl
 * Description:  用户服务实现类
 * Copyright:    Copyright (c)2017
 * Company:      CSII
 *
 * @author: huangzhengjun
 * @verion: 1.0
 * Create at:    2017/6/30
 * Modification History:
 * Date          Author               Version            Description
 * ----------------------------------------------------------------------------------------
 */
@Service("UserService")
public class UserServiceImpl implements UserService{

    @Resource(name="UserDao")
    private UserDao dao;

    @Override
    public User queryUser(String userId) {
        return dao.queryUserInfo(userId);
    }
}
