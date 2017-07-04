package net.hzj.service;

import net.hzj.entity.User;

/**
 * Interface:    UserService
 * Description:  用户服务
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
public interface UserService {

    User queryUser(String userId);

}
