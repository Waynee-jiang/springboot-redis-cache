/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TMsgMapper
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 16:43
 * Description: TMsgMapper
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.springboottemplate.redis.mapper;

import com.springboottemplate.redis.entity.TMsg;
import tk.mybatis.mapper.common.Mapper;


/**
 * 〈一句话功能简述〉<br> 
 * 〈TMsgMapper 〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27
 * @since 1.0.0
 */

//@Mapper
public interface TMsgMapper  extends Mapper<TMsg> {
    TMsg findById(Integer id);
}