package com.luc.luc_bs.Util;

import com.alibaba.fastjson.JSON;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * @ Author : dell on 2018/4/5.
 * Date :  Created in  21:06.   2018/4/5.
 */
public class MyHttp {
    static String TOKEN ="";

    static public Map MyHttpGet(String url) throws IOException {
        // 创建一个url
        URL reqURL = new URL(url);
        // 拿取链接
        HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL.openConnection();
        // 取得该连接的输入流，以读取响应内容
        InputStreamReader isr = new InputStreamReader(
                httpsConn.getInputStream());
        // 读取服务器的响应内容并显示
        char[] chars = new char[1024];
        String reslut = "";
        int len;
        while ((len = isr.read(chars)) != -1) {
            reslut += new String(chars, 0, len);
        }
        isr.close();
        Map map1 = JSON.parseObject(reslut);
        return map1;
    }



    static public Map MyGetToken() throws IOException {
        // 创建一个url
        URL reqURL = new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=*********&secret=*****************");
        // 拿取链接
        HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL.openConnection();
        // 取得该连接的输入流，以读取响应内容
        InputStreamReader isr = new InputStreamReader(
                httpsConn.getInputStream());
        // 读取服务器的响应内容并显示
        char[] chars = new char[1024];
        String reslut = "";
        int len;
        while ((len = isr.read(chars)) != -1) {
            reslut += new String(chars, 0, len);
        }
        isr.close();
        Map map1 = JSON.parseObject(reslut);
        return map1;
    }
}
