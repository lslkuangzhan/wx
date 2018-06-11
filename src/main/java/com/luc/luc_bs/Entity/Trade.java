package com.luc.luc_bs.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @ Author : dell on 2018/6/2.
 * Date :  Created in  16:54.   2018/6/2.
 */
@Table(name = "trade")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "producId")
    private String producId;
    @Column(name = "OpenID")
    private String OpenID;
    @Column(name = "price")
    private String price;
    @Column(name = "state")
    private String state;
    @Column(name = "time")
    private Date time;
    @Column(name = "name")
    private String  name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducId() {
        return producId;
    }

    public void setProducId(String producId) {
        this.producId = producId;
    }

    public String getOpenID() {
        return OpenID;
    }

    public void setOpenID(String openID) {
        OpenID = openID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
