package com.luc.luc_bs.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author : dell on 2018/3/17.
 * Date :  Created in  13:14.   2018/3/17.
 */
@RestController()
public class WeChatController {
    @RequestMapping("/wx/test")
    public String userLogin()
    {
        return "hello WeChat  !    begin   WeChat ";
    }
}
