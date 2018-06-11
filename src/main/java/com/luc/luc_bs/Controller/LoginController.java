package com.luc.luc_bs.Controller;

import com.luc.luc_bs.Service.ProductService;
import com.luc.luc_bs.Service.TradeService;
import com.luc.luc_bs.Util.MyHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ Author : dell on 2018/3/15.
 * Date :  Created in  14:20.   2018/3/15.
 */
@Controller
public class LoginController {
    @Autowired
    ProductService productService;
    @Autowired
    TradeService tradeService;
    @RequestMapping("/login")
    public String userLogin()
    {

        return "demoSign";
    }
    @RequestMapping("/login-error")
    public String loginError()
    {
        return "login-error";

    }
    @RequestMapping("/success")
    public String success(HttpServletRequest request) throws IOException {
        Map map = MyHttp.MyGetToken();
        Map map1 =MyHttp.MyHttpGet("https://api.weixin.qq.com/cgi-bin/user/get?access_token="+map.get("access_token"));
        request.setAttribute("count",map1.get("count"));
        int commodity =productService.getProductTotal();
        request.setAttribute("commodity",commodity);
        int trade =tradeService.getTradeTotal();
        int price =tradeService.getPriceTotal();
        List<Map> list=  tradeService.getPriceTotalByProduct();
        request.setAttribute("trade",trade);
        request.setAttribute("price",price);
        request.setAttribute("Echarts",list);
        return "index";
    }

    @RequestMapping("/wx/html")
    public String test(HttpServletRequest request)
    {

        request.setAttribute("key", "我有一个储钱罐,是姐姐从她上大学的地方——徐州带回来的,那是姐姐给我的礼物.刚拿到储钱罐时,我甭提多高兴了,一条三尺高呀!\n" +
                "储钱罐的颜色是淡青的,外形是一只兔子,整个看上去像是一只兔子在草丛中尽情的奔跑、跳跃,而后面的尾巴短短的,旋转一下,就可以打开这个储钱罐了.\n" +
                "这段时间,我一直坚持存零钱,准备有用的时候拿出来用.我经常摇摇储钱罐,硬币发出的声音好像兔子欢快的叫声.\n" +
                "每天我放学回家,看见小摊上的东西,我就想用零花钱,那时我似乎看见“小兔子”储钱罐向我生气的瞪眼,好像在说：“零花钱不能乱用,就算买了,也要扔掉的.”我一想,唉,是呀!还是小兔子提醒了我,多亏它了.从此,我再也不迷恋那些小摊上那些吃、喝、玩、乐的东西了.\n" +
                "今天放学回家,我像以前一样,拿起储钱罐摇一下,想听一下硬币发出的那种如同小兔子欢快的叫声,可是我发现储钱罐变轻了,打开盖子：“呀,我的硬币怎么少了这么多,难道家里有小偷来过?”我惊讶得叫起来.这时,妈妈回来了,她对我说硬币是她拿的,因为妈妈上班坐车要用零钱,可是妈妈零钱用完了,所以••••••,我正想说什么,“小兔子”又提醒了我：“没关系,钱是父母的,以后还可以攒的.”听了小兔子的话,我对妈妈说：“没关系的,妈妈,你拿好了.”妈妈听了说：“女儿长大了,变得懂事了.”\n" +
                "我想,我要把我的储钱罐存的满满的,然后捐给一些生活困难的人,让他们享受我们一样的生活,过上美好的日子.\n" +
                "我要感谢储钱罐,让我养成不乱花零钱的好习惯,同时也让我能够合理的花我自己的每一分零花钱.");
        return "product";
    }

    @RequestMapping("/TAB")
    public String TAB()
    {
        return "tab";
    }

    @RequestMapping("/Order")
    public String OrderManage()
    {

        return "OrderManage";
    }

    @RequestMapping("/Buy")
    public String test(HttpServletRequest request,HttpServletResponse response)
    {
        return "article";
    }

    @RequestMapping("/BuyTest")
    public String BuyTest(HttpServletRequest request,HttpServletResponse response)
    {
        request.setAttribute("openid","12547889asdas25");
        request.setAttribute("pId",1);
        request.setAttribute("nickname","LLLLL");
        return "infoTable";
    }
}
