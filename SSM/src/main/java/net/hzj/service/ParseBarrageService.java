package net.hzj.service;

import java.io.IOException;
import java.util.List;

/**
 * Interface:    ParseBarrageXml
 * Description:  解析弹幕xml文件
 * Copyright:    Copyright (c)2017
 * Company:      CSII
 *
 * @author: huangzhengjun
 * @verion: 1.0
 * Create at:    2017/6/24
 * Modification History:
 * Date          Author               Version            Description
 * ----------------------------------------------------------------------------------------
 */

public interface ParseBarrageService {

    List getUserHash(String cid, String barrage) throws IOException;

}
