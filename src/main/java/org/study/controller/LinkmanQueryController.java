package org.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.study.entity.Linkman;
import org.study.service.LinkmanService;

import java.util.List;
import java.util.Map;

@Controller
public class LinkmanQueryController {
    @Autowired
    @Qualifier("linkmanService")
    private LinkmanService service;

    @RequestMapping("QueryLinkmanById")
    public String QueryLinkmanById(@RequestParam("id") int id, Map<String,Object> map){
        Linkman linkman = service.queryLinkmanById(id);
        System.out.println("linkman = " + linkman);
        map.put("linkman",linkman);
        return "result";
    }

    @RequestMapping("AddLinkman")
    public String AddLinkman(Linkman linkman){
        service.AddLinkman(linkman);
        return "result";
    }

    @RequestMapping("queryAllLinkman")
    public String queryAllLinkman(Map<String,Object> map){
        List<Linkman> linkmanList = service.queryAllLinkman();
        map.put("linkmans",linkmanList);
        System.out.println(linkmanList);
        return "result";
    }

    @RequestMapping("deleteLinkmanByid")
    public String deleteLinkmanByid(int id,Map<String,String> map){
        if (service.deleteLinkmanByid(id)){
            map.put("message","删除成功");
        }else {
            map.put("message","查无此人！");
        }
        return "result";
    }

    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String username,String psw){
        System.out.println(username+"----"+psw);
        boolean login = service.login(username, psw);
        String message;
        if(login)
            message="登陆成功!";
        else
            message="账户或密码错误!";
        return message;
    }

    public LinkmanService getService() {
        return service;
    }

    public void setService(LinkmanService service) {
        this.service = service;
    }
}
