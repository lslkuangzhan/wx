package com.luc.luc_bs.Controller;

import com.luc.luc_bs.Entity.Product;
import com.luc.luc_bs.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ Author : dell on 2018/4/11.
 * Date :  Created in  15:33.   2018/4/11.
 */
@Controller
public class ProductController {


    @Autowired
    ProductService productService;
    @RequestMapping("/getPriceTotal")
    @ResponseBody
    public String index() {
        return "Hello World";
    }
    @RequestMapping("/addProduct")
    public String addProduct() {
        return "addProduct";
    }
    @RequestMapping("/product/add")
    @ResponseBody
    public String add(Product product) {
        productService.add(product);
        return "添加成功";
    }
    @RequestMapping("/product/update")
    @ResponseBody
    public String update(Product product) {
        productService.update(product);
        return "更新成功";
    }
    @RequestMapping("/product/get")
    @ResponseBody
    public  List<Map<String,Object>> list() {
        List<Map<String,Object>> list =productService.list();
        return list;
    }
    @RequestMapping("/product/getIdAndName")
    @ResponseBody
    public  List<Map<String,Object>> getIdAndNameList() {
        List<Map<String,Object>> list =productService.getIdAndNameList();
        return list;
    }
}
