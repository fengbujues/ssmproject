package org.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.study.entity.Linkman;
import org.study.service.LinkmanService;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
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

    @ResponseBody
    @RequestMapping("AddLinkman")
    public void AddLinkman(String name,int age,String tel,String address){
        Linkman linkman = new Linkman(name,age,tel,address);
        System.out.println(linkman);
        System.out.println("没东西？？？");
        service.AddLinkman(linkman);
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
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String username, String psw){
        System.out.println(username+"----"+psw);
        boolean login = service.login(username, psw);
        String message;
        if(login){
            message="登陆成功!";
        }
        else{
            message="账户或密码错误!";
        }
        return message;
    }

    /**
     * 判断账户是否存在
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "testusername",method = RequestMethod.POST)
    public String testusername(@RequestParam String username,HttpSession session){
        String message=null;
        Linkman linkman = service.queryLinkmanbyname(username);
//        System.out.println("linkman = " + linkman);
        if(linkman==null){
            message = "false";
        }else{
            message = "true";
            session.setAttribute("user",linkman);
        }
        return message;
    }

    /**
     * 获取数据库中其他的数据，以list的方式返回到前端
     * @return
     */
    @ResponseBody
    @RequestMapping("lists")
    public List<Linkman> lists(HttpSession session){
        List<Linkman> linkmen = service.queryAllLinkman();
        Linkman user = (Linkman)session.getAttribute("user");
        linkmen.remove(session.getAttribute("user"));
        Iterator<Linkman> iterator = linkmen.iterator();

        //删除list中的当前用户
        while (iterator.hasNext()){
            Linkman next = iterator.next();
            if(user.getId() == next.getId()){
                iterator.remove();
            }
        }
        linkmen.add(0,user);
        return linkmen;
    }

    /**
     * 分页查询
     * 不知道是什么原因 总是会犯一些奇怪的bug，如ajax传不了值，，可能是缓存的原因
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "limitquery")
    public List<Linkman> limitquery(int page,HttpSession session){
        Linkman user = (Linkman)session.getAttribute("user");
        System.out.println(page);

        List<Linkman> list = service.limitQueryByPage(page);
//        System.out.println(list);
        return list;
    }

    /**
     * 返回数据数目
     * @return
     */
    @ResponseBody
    @RequestMapping("count")
    public int count(){
        List<Linkman> linkmen = service.queryAllLinkman();
        return linkmen.size();
    }

    /**
     * 编辑联系人
     */
    @RequestMapping("updateLinkman")
    public String updateLinkman(Linkman linkman){
        System.out.println(linkman);
        service.updateLinkman(linkman);
        return "success";
    }

    public LinkmanService getService() {
        return service;
    }

    public void setService(LinkmanService service) {
        this.service = service;
    }
}
