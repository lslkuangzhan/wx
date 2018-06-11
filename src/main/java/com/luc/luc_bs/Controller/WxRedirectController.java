package com.luc.luc_bs.Controller;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author : dell on 2018/3/18.
 * Date :  Created in  22:09.   2018/3/18.
 */
@Controller
public class WxRedirectController {
    private  String appid ="**************";

    private  String appsecret="**************";

    @RequestMapping("/wx/Info")
    public String info (HttpServletRequest request,HttpServletResponse response) throws IOException {
        Map<String, String[]> params = request.getParameterMap();//针对get获取get参数
        String[] codes = params.get("code");//拿到的code的值
        String code = codes[0];//code

        String[] ids = params.get("state");//拿到的id的值
        String id = ids[0];
        // 拼接api要求的httpsurl链接
       String  url ="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+appsecret+"&code="+code+"&grant_type=authorization_code";

    /*    RestTemplate restTemplate = new RestTemplate();
        String GetOpenIDresult = restTemplate.getForObject(url, String.class);*/
  //      request.setAttribute("nickname",GetOpenIDresult);

        // 创建一个url
        URL reqURL = new URL(url);
        // 拿取链接
        HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL
                .openConnection();
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

       String infourl ="https://api.weixin.qq.com/sns/userinfo?access_token="+map1.get("access_token")+"&openid="+map1.get("openid")+"&lang=zh_CN";
        URL reqinfourl = new URL(infourl);
        // 拿取链接
        httpsConn = (HttpsURLConnection) reqinfourl
                .openConnection();
        // 取得该连接的输入流，以读取响应内容
         isr = new InputStreamReader(
                httpsConn.getInputStream());
        // 读取服务器的响应内容并显示
        chars = new char[1024];
         reslut = "";
        while ((len = isr.read(chars)) != -1) {
            reslut += new String(chars, 0, len);
        }
        isr.close();
        map1 = JSON.parseObject(reslut);
        request.setAttribute("city",map1.get("city"));
        request.setAttribute("country",map1.get("country"));
        request.setAttribute("headimgurl",map1.get("headimgurl"));
        request.setAttribute("language",map1.get("language"));
        request.setAttribute("nickname",map1.get("nickname"));
        request.setAttribute("openid",map1.get("openid"));
        request.setAttribute("privilege",map1.get("privilege"));
        request.setAttribute("province",map1.get("province"));
        request.setAttribute("sex",map1.get("sex"));
        request.setAttribute("pId",id);
        return "infoTable";
    }



}
