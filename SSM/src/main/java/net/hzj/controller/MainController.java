package net.hzj.controller;

import net.hzj.entity.User;
import net.hzj.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
* @Description :
* @author : huangzhengjun
* @Date : 2017/6/27
*/
@Controller
@RequestMapping("/Test")
public class MainController {
    
    @Resource(name="UserService")
    private UserService userservice;

    @RequestMapping(value = "/ajax",method = RequestMethod.GET)
    @ResponseBody
    /**
    * @Description :
    * @param : [id]
    * @return : java.util.Map<java.lang.String,java.lang.Object>
    * @author : huangzhengjun
    * @Date : 2017/6/23
    */
    public Map<String,Object> test(String id){
        Map mapJson = new HashMap();
        String person;
        String optValues = id;
        if ("1".equals(optValues)){
            person = "姓名：张三，年龄：24，性别：男，出生地：广西南宁";
            mapJson.put("person",person);
        }
        if ("2".equals(optValues)){
            person = "姓名：李四，年龄：30，性别：男，出生地：广西百色";
            mapJson.put("person",person);
        }
        if ("3".equals(optValues)){
            person = "姓名：王五，年龄29，性别：男，出生地：广西桂林";
            mapJson.put("person",person);
        }
        return mapJson;
    }

    @RequestMapping(value="/user",method = RequestMethod.GET)
    @ResponseBody
    /**
    * @Description :
    * @param : [userId]
    * @return : java.util.Map<java.lang.String,java.lang.Object>
    * @author : huangzhengjun
    * @Date : 2017/6/30
    */
    public Map<String,Object> queryUser(String userId){
        Map<String,Object> result = new HashMap<>();
        User user = userservice.queryUser(userId);
        result.put("UserName",user.getUserName());
        return result;
        
    }

}
