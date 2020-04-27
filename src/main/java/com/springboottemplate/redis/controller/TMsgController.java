/**
 * Copyright (C), 2018-2020, Sol-c Ltd.
 * FileName: TMsgController
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 16:47
 * Description: TMsgController
 * History:
 * <author>                <time>            <version>          <desc>
 * Wayne.Jiang         2020-04-27 16:47         $(VERSION)          TMsgController
 */
package com.springboottemplate.redis.controller;

import com.springboottemplate.redis.entity.TMsg;
import com.springboottemplate.redis.entity.TbItem;
import com.springboottemplate.redis.result.ResponseResult;
import com.springboottemplate.redis.service.TMsgService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈TMsgController 〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27 16:47
 * @since v1.0.0
 */

@RestController
@RequestMapping("/msg")
public class TMsgController {

    @Autowired
    private TMsgService tMsgService;

    @GetMapping("/getMsg")
    public String getMsg(@Param("id") Integer id){
        TMsg tMsg = tMsgService.findById(id);
//        List<TbItem> result = tMsgService.findById(id);
//        return new ResponseResult(200, "查询成功，size = " + result.size(), result).getMessage();
        return tMsg.toString();
    }

}