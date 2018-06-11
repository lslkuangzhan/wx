package com.luc.luc_bs.Service;

import com.luc.luc_bs.Dao.ProductDao;
import com.luc.luc_bs.Dao.TradeDao;
import com.luc.luc_bs.Entity.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ Author : dell on 2018/4/6.
 * Date :  Created in  22:22.   2018/4/6.
 */
@Service
public class TradeService {
    @Autowired
    TradeDao tradeDao;
    @Autowired
    ProductDao productDao;

    public  int getPriceTotal(){
        return tradeDao.getPriceTotal();
    }

    public  int getTradeTotal(){
        return tradeDao.getTradeTotal();
    }
    public List<Map> getPriceTotalByProduct(){
        return tradeDao.getPriceTotalByProduct();
    }

    public List<Map> getOrder (){
        return tradeDao.getOrder();
    }

    public  int  updateState(String s ){
        String str[] =s.split(",");
        for (int i= 0 ;i<str.length ;i++) {
            Trade trade = new Trade();
            trade.setState("1");
            trade.setId(Integer.parseInt(str[i]));
            tradeDao.updateByPrimaryKeySelective(trade);
        }
        return 0;
    }

    public  int  add(Trade trade ){

        trade.setPrice(productDao.getpirceByid(Integer.parseInt(trade.getProducId()))+"");
        return tradeDao.insert(trade);
    }
}
