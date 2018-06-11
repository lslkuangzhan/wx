package com.luc.luc_bs.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @ Author : dell on 2018/3/18.
 * Date :  Created in  21:27.   2018/3/18.
 */
@RestController
public class WxLoginController {
    private  String appid ="********************";
    private  String appsecret="***************";

    //private String  redirect_uri = "http%3A%2F%2F120.79.54.72%3A8090%2Fwx%2FInfo";
    //private String  redirect_uri ="http://006764a3.ngrok.io/wx/Info";
    private String  redirect_uri ="https%3a%2f%2fd61781ef.ngrok.io%2Fwx%2FInfo";
    @RequestMapping("/wx/auth")
    public void weixinLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       // redirect_uri = URLEncoder.encode(redirect_uri, "UTF-8");
        Map<String, String[]> params = req.getParameterMap();//针对get获取get参数
        String[] ids = params.get("id");//拿到的code的值
        String id = ids[0];
        //这一步就是拼写微信api请求地址并 通过微信的appid 和 微信公众号的AppSecret 以及我们获取到的针对用户授权回调的code 拿到 这个用户的 openid和access_token
        String requestUrl = "http://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri="+redirect_uri+"&response_type=code&scope=snsapi_userinfo&state="+id+"&connect_redirect=1#wechat_redirect";
        resp.sendRedirect(requestUrl);
    }
}
