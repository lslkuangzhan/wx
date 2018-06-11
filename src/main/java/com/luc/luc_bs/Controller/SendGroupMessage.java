package com.luc.luc_bs.Controller;


import com.luc.luc_bs.Entity.Article;
import com.luc.luc_bs.Service.ArticleService;
import com.luc.luc_bs.Service.ProductService;
import com.luc.luc_bs.Util.CommUtil;
import com.luc.luc_bs.Util.FileUpload;
import com.luc.luc_bs.Util.ImageArticleUpload;
import com.luc.luc_bs.Util.MyHttp;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @ Author : dell on 2018/4/14.
 * Date :  Created in  20:57.   2018/4/14.
 */
/*public class SendGroupMessage {


}*/
@Controller
@RequestMapping("/Test")
public class SendGroupMessage {
    @Autowired
    private ArticleService articleServer;
    @Autowired
    private ProductService productService;
    public  static String sendGroupMessage(String token ,String mediaId) throws IOException {
        String groupUrl1 = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+ token;//根据openid发群发消息地址
        String openid4data = "{\"touser\":\"ozGCg0oj7_MLko7NI0ZsrSHOYgCc\", \"msgtype\":\"mpnews\",\"mpnews\": {\"media_id\":\""+mediaId+"\"}}";
        JSONObject json = CommUtil.httpRequest(groupUrl1, "POST", openid4data);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping("/sendByOpenid")
    public String sendGroupMessage(String a ,String b,String c, String e,String f) throws IOException {
        String token = MyHttp.MyGetToken().get("access_token").toString();
        String filePath ="C:/Users/dell/Desktop/1.jpg";//本地或服务器文件路径
        String sendUrl = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="+token+"&type=image";//ACCESS_TOKEN是获取到的access_token
        String ImageID = FileUpload.send(sendUrl, filePath);
        String imageArticleId =ImageArticleUpload.upload(token,a,b,c,e,f,ImageID,0);
        Article article = new Article();
        article.setArticleId(imageArticleId);
        article.setArticleTitle(c);
        articleServer.add(article);
        sendGroupMessage(token,imageArticleId);
        return a;
    }
    @ResponseBody
    @RequestMapping("/sendProductId")
    public String  sendProductId(String a ,String b,String c, String e,String f) throws IOException {
        String token = MyHttp.MyGetToken().get("access_token").toString();
        String filePath ="C:/Users/dell/Desktop/1.jpg";//本地或服务器文件路径
        String sendUrl = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="+token+"&type=image";//ACCESS_TOKEN是获取到的access_token
        String ImageID = FileUpload.send(sendUrl, filePath);
        String articleNei = productService.getProductById(Integer.parseInt(e));
        String imageArticleId =ImageArticleUpload.upload(token,a,b,c,articleNei,f,ImageID,Integer.parseInt(e));
        Article article = new Article();
        article.setArticleId(imageArticleId);
        article.setArticleTitle(c);
        articleServer.add(article);
        sendGroupMessage(token,imageArticleId);
        return a;
    }
    /*public static void main(String[] args) throws IOException {
        System.out.println(new SendGroupMessage().sendGroupMessage());
    }*/
}
