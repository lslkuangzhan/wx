package com.luc.luc_bs.Entity;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.Table;

/**
 * @ Author : dell on 2018/4/18.
 * Date :  Created in  13:47.   2018/4/18.
 */
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "pirce")
    private Integer pirce;
    @Column(name = "miaoshu")
    private String miaoshu;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getPirce() {
        return pirce;
    }

    public void setPirce(Integer pirce) {
        this.pirce = pirce;
    }

    public String getMiaoshu() {
        return miaoshu;
    }

    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu;
    }

    public void setName(String name) {
        this.name = name;
    }

}
