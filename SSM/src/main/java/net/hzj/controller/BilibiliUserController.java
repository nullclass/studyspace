package net.hzj.controller;

import net.hzj.service.ParseBarrageService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class:        BilibiliUserController
 * Description:  b站用户功能
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
@Controller
@RequestMapping("biliUser")
public class BilibiliUserController {

    @Resource(name="ParseBarrageService")
    private ParseBarrageService parseBarrageService;

    @RequestMapping(value = "nameQry",method = RequestMethod.GET)
    @ResponseBody
    /**
    * @Description :根据弹幕查询用户
    * @param : [av, barrage]
    * @return : java.util.Map<java.lang.String,java.lang.Object>
    * @author : huangzhengjun
    * @Date : 2017/6/24
    */
    public Map<String,Object> nameQry(String av, String barrage) throws IOException {
        Map<String,Object> map = new HashMap<>();
        List<String> userList = new ArrayList<>();
        String videoUrl = av;
        Document document = Jsoup.connect(videoUrl).get();
        String data = document.outerHtml();
        Pattern pattern = Pattern.compile("cid=\\d+&");
        Matcher matcher = pattern.matcher(data);
        String cid = null;
        while(matcher.find()){
            Pattern pa = Pattern.compile("\\d+");
            Matcher ma = pa.matcher(matcher.group());
            while(ma.find()){
                cid = ma.group();
            }

        }

        if(cid == null){
            map.put("error","1");
            map.put("data","该视频无法识别弹幕");
            return map;
        }


        List<Map<String,Object>> resultList = parseBarrageService.getUserHash(cid,barrage);

        map.put("state","0");
        map.put("barrage",barrage);
        map.put("userList",resultList);
        return map;
    }



}
