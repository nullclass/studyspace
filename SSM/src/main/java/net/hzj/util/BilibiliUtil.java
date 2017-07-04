package net.hzj.util;

import java.io.*;

/**
 * Class:        WriteDataToFile
 * Description:  将数据写入文件
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

public final class BilibiliUtil {

    private BilibiliUtil(){};

    public static void writeData (Object data) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("/Users/admin/Documents/data.txt"),"UTF-8"));
        pw.println(data);
        pw.flush();
        pw.close();
    }


}
