package net.hzj.service.impl;

import net.hzj.service.ParseBarrageService;
import net.hzj.util.BilibiliUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class:        ParseBarrageXmlImpl
 * Description:  解析弹幕xml文件的实现类
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
@Service("ParseBarrageService")
public class ParseBarrageServiceImpl implements ParseBarrageService {

    @Override
    public List getUserHash(String cid ,String barrage) throws IOException {
        String baseUri = "http://comment.bilibili.com/";
        String url = baseUri+cid+".xml";
        Document document = Jsoup.parse(new URL(url).openStream(), "GBK", baseUri, Parser.xmlParser());
        BilibiliUtil.writeData(document.html());
        Elements d = document.select("d");
        List<Map<String,Object>> list = new ArrayList<>();
        for(Element e : d){
            String b = e.text();
            String hash = e.attr("p").split(",")[6];
            String date = e.attr("p").split(",")[4];
            if(barrage.equals(b)){
                Map m = new HashMap();
                m.put("Hash",hash);
                m.put("Date",date);
                Document dd = Jsoup.connect("http://biliquery.typcn.com/api/user/hash/"+hash).get();
                String json = dd.outerHtml();
                JSONObject obj = JSONObject.fromObject(json);
                int state = obj.getInt("error");
                if(state == 0){
                    JSONArray arrs = obj.getJSONArray("data");
                    for(int i =0 ;i<arrs.size();++i){
                        String uid = arrs.getJSONObject(i).getString("id");
                        m.put("space","http://space.bilibili.com/"+uid);
                    }
                }else{
                    m.put("space","无法获取用户");
                }
                list.add(m);
            }
        }
        return list;
    }
}
