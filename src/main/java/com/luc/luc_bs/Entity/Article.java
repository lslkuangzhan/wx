package com.luc.luc_bs.Entity;

import javax.persistence.*;

/**
 * @ Author : dell on 2018/6/3.
 * Date :  Created in  19:30.   2018/6/3.
 */
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "articleTitle")
    private String articleTitle;
    @Column(name = "articleId")
    private String articleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
}
