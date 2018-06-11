package com.luc.luc_bs.Entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ Author : dell on 2018/3/18.
 * Date :  Created in  12:15.   2018/3/18.
 */
@Table(name = "wxUserInfo")
public class WxUserInfo {
    // 用户标识
    @Column(name = "openId")
    private String openId;
    // 性别（1是男性，2是女性，0是未知）
    @Column(name = "sex")
    private int sex;
    // 省份
    @Column(name = "province")
    private String province;
}
