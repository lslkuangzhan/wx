package com.luc.luc_bs.Dao;

import com.luc.luc_bs.Entity.Trade;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @ Author : dell on 2018/4/6.
 * Date :  Created in  22:23.   2018/4/6.
 */
public interface TradeDao extends BaseMapper<Trade> {
    public  int getTradeTotal();
    public  int getPriceTotal();
    public List<Map> getPriceTotalByProduct();
    public List<Map> getOrder();

}
