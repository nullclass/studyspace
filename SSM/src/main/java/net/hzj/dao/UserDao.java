package net.hzj.dao;

import net.hzj.entity.User;
import org.springframework.stereotype.Component;

/**
 * Interface:    UserDao
 * Description:  用户数据库操作接口
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
@Component("UserDao")
public interface UserDao {

    User queryUserInfo(String userId);

}
