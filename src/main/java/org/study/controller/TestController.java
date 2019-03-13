package org.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.SessionScope;
import org.study.entity.Student;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @ResponseBody//告诉mvc此时返回的不是一个页面
    @RequestMapping(value = "testAjax",method = RequestMethod.GET)
    public String testAjax(@RequestParam("mobile") String phone, Map<String,String> map, HttpSession HttpSession){
        System.out.println(phone);
        HttpSession.setAttribute("message","true");
        String message;
        if("110".equals(phone)){
            message = "{\"message\":\"true\"}";//{"message","true"}
        }else{
            message = "{\"message\":\"false\"}";
        }
        System.out.println(message);
        return message;
    }

    @ResponseBody
    @RequestMapping(value = "jsonajax",method = RequestMethod.POST)
    public List<Student> jsonajax(){
        Student student = new Student(1, "刘洋", 20);
        Student student1 = new Student(2, "王五", 23);
        Student student2 = new Student(3, "李四", 22);
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        return students;
    }

}
