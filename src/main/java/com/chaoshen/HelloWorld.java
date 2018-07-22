package com.chaoshen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by Administrator on 2018/7/16.
 */
@Controller
public class HelloWorld {
    @Autowired
    private Environment environment;
    @RequestMapping("/hello")
    @ResponseBody
    public  String getProfile(){
        Properties prop = new Properties();
        String returnStr = "";
        try {
            URL url = this.getClass().getClassLoader().getResource("config.properties");
            System.out.println(url.getPath());
            InputStream in = new BufferedInputStream (new FileInputStream(url.getPath()));
            prop.load(in);     ///加载属性列表
            Iterator<String> it=prop.stringPropertyNames().iterator();
            System.out.println("chaoshen");
            while(it.hasNext()){
                String key=it.next();
                 returnStr = prop.getProperty(key+"!!!!");
            }
            in.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return returnStr+"***************";
    }
}
