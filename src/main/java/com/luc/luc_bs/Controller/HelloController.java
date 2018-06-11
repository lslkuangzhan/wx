package com.luc.luc_bs.Controller;

import com.luc.luc_bs.Entity.UserInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @ Author : dell on 2018/3/15.
 * Date :  Created in  10:07.   2018/3/15.
 */

@RestController
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String index() {
        return "Hello World";
    }


    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping(value="")
    public String postUser(@RequestBody UserInfo user) {

        return "success";
    }
}
