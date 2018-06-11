package com.luc.luc_bs.Dao;

import com.luc.luc_bs.Entity.Product;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @ Author : dell on 2018/4/6.
 * Date :  Created in  21:55.   2018/4/6.
 */
public interface ProductDao extends BaseMapper<Product> {
    public  int getProductTotal();

    @Select("SELECT * from product order by id")
    public List<Map<String,Object>> getAllProduct();

    @Select("SELECT id , name from product order by id")
    public List<Map<String,Object>>  getIdAndNameList();

    @Select("SELECT pirce from product  where id =#{id} ")
    public int  getpirceByid(int id);

    @Select("SELECT miaoshu from product  where id =#{id} ")
    public String  getProductById(int id);

}
