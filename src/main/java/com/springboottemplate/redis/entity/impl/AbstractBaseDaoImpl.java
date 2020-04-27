/**
 * Copyright (C), 2018-2020, Sol-c Ltd.
 * FileName: AbstractBaseDaoImpl
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 19:25
 * Description:
 * History:
 * <author>                <time>            <version>          <desc>
 * Wayne.Jiang         2020-04-27 19:25         $(VERSION)
 */
package com.springboottemplate.redis.entity.impl;

import com.springboottemplate.redis.entity.base.IBaseDao;

import java.lang.reflect.ParameterizedType;

/**
 * 〈一句话功能简述〉<br> 
 * 〈AbstractBaseDaoImpl〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27 19:25
 * @since v1.0.0
 */

public abstract class AbstractBaseDaoImpl<T> /*extends HibernateDaoSupport*/ implements IBaseDao<T> {
    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public AbstractBaseDaoImpl()
    {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) type.getActualTypeArguments()[0];
    }
}