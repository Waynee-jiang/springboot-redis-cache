/**
 * Copyright (C), 2018-2020, Sol-c Ltd.
 * FileName: TMsgServiceImpl
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 16:46
 * Description:
 * History:
 * <author>                <time>            <version>          <desc>
 * Wayne.Jiang         2020-04-27 16:46         $(VERSION)
 */
package com.springboottemplate.redis.service.Impl;

import com.springboottemplate.redis.entity.TMsg;
import com.springboottemplate.redis.mapper.TMsgMapper;
import com.springboottemplate.redis.service.TMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27 16:46
 * @since v1.0.0
 */

@Service
public class TMsgServiceImpl implements TMsgService {

    @Autowired
    private TMsgMapper tMsgMapper;

    @Override
    public TMsg findById(Integer id) {
        return tMsgMapper.findById(id);
    }
}