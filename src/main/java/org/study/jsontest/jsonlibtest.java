package org.study.jsontest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;

public class jsonlibtest {
    public static void dom1(){
        String s = "{\"d1\":\"c1\",\"d2\":\"c2\",\"d3\":\"c3\"}";
        JSONObject object = new JSONObject();
        JSONObject object1 = object.fromObject(s);
        System.out.println("object1 = " + object1);
    }
    public static void dom2(){
        //字符串转json数组
        String s = "[\n" +
                "{\"姓名\":\"刘洋\",\"age\":\"20\"},\n" +
                "{\"sex\":\"man\",\"tel\":\"110\"},\n" +
                "{\"adress\":\"西安\",\"home\":\"湖北\"}\n" +
                "]";
        JSONArray jsonArray = new JSONArray();
        JSONArray jsonArray1 = jsonArray.fromObject(s);
        System.out.println("jsonArray1 = " + jsonArray1);
    }
    public static void dom3(){
        HashMap<String, String> map = new HashMap<>();
        map.put("d1","c1");
        map.put("d2","c2");
        map.put("d3","c3");
        JSONArray jsonArray = new JSONArray();
        JSONArray jsonArray1 = jsonArray.fromObject(map);
        System.out.println("jsonArray1 = " + jsonArray1);
    }
    public static void main(String[] args) {
//        dom1();
//        dom2();
        dom3();
    }
}
