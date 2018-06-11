package com.luc.luc_bs.Dao;

import com.luc.luc_bs.Entity.Article;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @ Author : dell on 2018/6/3.
 * Date :  Created in  19:35.   2018/6/3.
 */
public interface ArticleDao extends BaseMapper<Article>  {

    @Select("SELECT * from article order by id")
    public List<Map<String,Object>> getAllArticle();
}
