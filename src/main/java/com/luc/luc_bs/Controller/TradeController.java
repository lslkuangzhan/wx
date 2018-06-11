package com.luc.luc_bs.Controller;

import com.luc.luc_bs.Entity.Trade;
import com.luc.luc_bs.Service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ Author : dell on 2018/4/11.
 * Date :  Created in  15:39.   2018/4/11.
 */
@RestController
public class TradeController {
    @Autowired
    TradeService  tradeService;

    @RequestMapping("/getPriceTotalByProduct")
    @ResponseBody
    public List<Map> index() {
        List<Map> list=  tradeService.getPriceTotalByProduct();
        return list;
    }

    @RequestMapping("/order/get")
    @ResponseBody
    public List<Map> getOrder() {
        List<Map> list=  tradeService.getOrder();
        return list;
    }
    @RequestMapping("/Order/updateState")
    @ResponseBody
    public String  updateState(String s) {
         tradeService.updateState(s);
        return "true";
    }
    @RequestMapping("/wx/Order/add")
    @ResponseBody
    public String  add(String name ,String producId ,String OpenID ) {
        Trade trade = new Trade() ;
        trade.setName(name);
        trade.setProducId(producId);
        trade.setOpenID(OpenID);
        trade.setState("0");
        trade.setTime(new Date());
        tradeService.add(trade);
        return "true";
    }
}
