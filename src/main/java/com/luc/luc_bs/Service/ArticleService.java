package com.luc.luc_bs.Service;

import com.luc.luc_bs.Dao.ArticleDao;
import com.luc.luc_bs.Entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author : dell on 2018/6/3.
 * Date :  Created in  19:34.   2018/6/3.
 */
@Service
public class ArticleService {
    @Autowired
     private ArticleDao articleDao;

     public int add (Article article){
         return articleDao.insert(article);
     }
    public List<Map<String,Object>> list(){
        return articleDao.getAllArticle();
    }
}
