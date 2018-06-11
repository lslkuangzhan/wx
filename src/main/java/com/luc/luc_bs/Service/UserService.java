package com.luc.luc_bs.Service;

import com.luc.luc_bs.Dao.UserInfoDao;
import com.luc.luc_bs.Entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @ Author : dell on 2018/3/15.
 * Date :  Created in  21:05.   2018/3/15.
 */
@Component
public class UserService  implements UserDetailsService {

    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        //这里可以可以通过username（登录时输入的用户名）然后到数据库中找到对应的用户信息，并构建成我们自己的UserInfo来返回。
       /* if(username.equals("admin"))
        {
            //假设返回的用户信息如下;
            UserInfo userInfo=new UserInfo("admin", "123456", "ROLE_ADMIN", true,true,true, true);
            return userInfo;

        }*/

        return userInfoDao.findUserInfoByUsername(username);
    }
}
