package com.luc.luc_bs.Service;

import com.luc.luc_bs.Dao.ProductDao;
import com.luc.luc_bs.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author : dell on 2018/4/6.
 * Date :  Created in  21:54.   2018/4/6.
 */
@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public  int getProductTotal(){
        return productDao.getProductTotal();
    }

    public  int add(Product product){
        return productDao.insert(product);
    }
    public  int update(Product product){
        return productDao.updateByPrimaryKeySelective(product);
    }
    public List<Map<String,Object>> list(){
       return productDao.getAllProduct();
    }
    public List<Map<String,Object>> getIdAndNameList(){
        return productDao.getIdAndNameList();
    }
    public  String getProductById(Integer id){
        return productDao.getProductById(id);
    }
}
