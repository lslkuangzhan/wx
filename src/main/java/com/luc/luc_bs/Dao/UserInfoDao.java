package com.luc.luc_bs.Dao;

import com.luc.luc_bs.Entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ Author : dell on 2018/3/15.
 * Date :  Created in  22:04.   2018/3/15.
 */

public interface UserInfoDao {
    public  UserInfo findUserInfoByUsername(String username);
}
