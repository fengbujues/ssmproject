package org.study.jsontest;


import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class jsonTest {
    public static void dom1(){
        HashMap<String, String> map = new HashMap<>();
        map.put("d1","c1");
        map.put("d2","c2");
        map.put("d3","c3");
        JSONObject object = new JSONObject(map);
        System.out.println(object);
    }
    public static void  dom2(){
        String s = "{\"d1\":\"c1\",\"d2\":\"c2\",\"d3\":\"c3\"}";
        JSONObject object = new JSONObject(s);
        System.out.println(object);
    }

    public static void dom3() throws IOException {
        String json = FileUtils.readFileToString(new File("C:\\Users\\user\\IdeaProjects\\ssmproject\\src\\main\\resources\\json"));
        JSONObject jsonObject = new JSONObject(json);
        System.out.println("jsonObject = " + jsonObject);
    }

    public static void main(String[] args) throws IOException {
//        dom1();
//        dom2();
        dom3();
    }
}
