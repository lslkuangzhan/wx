package com.luc.luc_bs.Dao;


import com.luc.luc_bs.Entity.Permission;


import java.util.List;
/**
 * @ Author : dell on 2018/3/15.
 * Date :  Created in  11:12.   2018/3/15.
 */
public interface  PermissionDao {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(int userId);
}
