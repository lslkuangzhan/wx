package com.luc.luc_bs.Util;

/**
 * @ Author : dell on 2018/4/14.
 * Date :  Created in  21:41.   2018/4/14.
 */
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import java.util.Map;

public class ImageArticleUpload {
    public static String upload(String access_token,String a ,String b,String c, String e,String f,String ImageId,Integer id){
        String http = "https://d61781ef.ngrok.io/wx/auth?id="+id;
        String url = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token="+access_token;//ACCESS_TOKEN是获取到的access_token
        String data1 = "{\"articles\":[{\"author\":\""+a+"\",\"content\":\""+e+"\",\"content_source_url\":\""+http+"\",\"digest\":\""+c+"\",\"show_cover_pic\":1,\"thumb_media_id\":\""+ImageId+"\",\"title\":\""+b+"\"}]}";
        JSONObject json = CommUtil.httpRequest(url, "POST", data1);
        Map map = JSON.parseObject(json.toString());
        return map.get("media_id").toString();
    }
}