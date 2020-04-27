/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: IBaseDao
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 18:39
 * Description: Interface of base entity
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.springboottemplate.redis.entity.base;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Interface of base entity〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27
 * @since 1.0.0
 */

public interface IBaseDao<T> {
    //根据id查询的方法
    T findById(Serializable id);

    T findById(Integer id);
    /**
     * 功能描述: <br>
     * 〈save entity〉
     *
     * @param null
     * @return:
     * @since: 1.0.0
     * @Author:Wayne.Jiang
     * @Date: 2020-04-27 19:12
     */
    int save(T entity);

    /**
     * 功能描述: <br>
     * 〈〉
     *
     * @param null
     * @return:
     * @since: 1.0.0
     * @Author:Wayne.Jiang
     * @Date: 2020-04-27 19:12
     */
    int merge(T entity);

    /**
     * 功能描述: <br>
     * 〈〉
     *
     * @param null
     * @return:
     * @since: 1.0.0
     * @Author:Wayne.Jiang
     * @Date: 2020-04-27 19:12
     */
    int delete(Serializable entityid);

    /**
     * 功能描述: <br>
     * 〈〉
     *
     * @param null
     * @return:
     * @since: 1.0.0
     * @Author:Wayne.Jiang
     * @Date: 2020-04-27 19:12
     */
    int update(T entity);

}
