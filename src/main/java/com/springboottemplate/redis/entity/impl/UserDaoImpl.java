/**
 * Copyright (C), 2018-2020, Sol-c Ltd.
 * FileName: UserDaoImpl
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 18:43
 * Description: UserDaoImpl
 * History:
 * <author>                <time>            <version>          <desc>
 * Wayne.Jiang         2020-04-27 18:43         $(VERSION)          UserDaoImpl
 */
package com.springboottemplate.redis.entity.impl;

import com.springboottemplate.redis.entity.base.IUserDao;
import com.springboottemplate.redis.entity.base.TUser;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈UserDaoImpl 〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27 18:43
 * @since v1.0.0
 */

public class UserDaoImpl extends BaseDaoImpl<TUser> implements IUserDao<TUser> {
    @Override
    public TUser findById(Serializable id) {
        return null;
    }

    /**
     * 功能描述: <br>
     * 〈save entity〉
     *
     * @param entity@return:
     * @since: 1.0.0
     * @Author:Wayne.Jiang
     * @Date: 2020-04-27 19:12
     */
    @Override
    public int save(TUser entity) {
        return 0;
    }

    /**
     * 功能描述: <br>
     * 〈〉
     *
     * @param entity@return:
     * @since: 1.0.0
     * @Author:Wayne.Jiang
     * @Date: 2020-04-27 19:12
     */
    @Override
    public int merge(TUser entity) {
        return 0;
    }

    /**
     * 功能描述: <br>
     * 〈〉
     *
     * @param entityid@return:
     * @since: 1.0.0
     * @Author:Wayne.Jiang
     * @Date: 2020-04-27 19:12
     */
    @Override
    public int delete(Serializable entityid) {
        return 0;
    }

    /**
     * 功能描述: <br>
     * 〈〉
     *
     * @param entity@return:
     * @since: 1.0.0
     * @Author:Wayne.Jiang
     * @Date: 2020-04-27 19:12
     */
    @Override
    public int update(TUser entity) {
        return 0;
    }
}