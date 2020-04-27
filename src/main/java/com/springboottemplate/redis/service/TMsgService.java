/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TMsgService
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 16:45
 * Description: TMsgService
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.springboottemplate.redis.service;

import com.springboottemplate.redis.entity.TMsg;

/**
 * 〈一句话功能简述〉<br> 
 * 〈TMsgService 〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27
 * @since 1.0.0
 */

public interface TMsgService {

    public TMsg findById(Integer id);

}
