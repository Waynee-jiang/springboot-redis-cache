/**
 * Copyright (C), 2018-2020, Sol-c Ltd.
 * FileName: BaseAbstractController
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 19:51
 * Description: BaseAbstractController
 * History:
 * <author>                <time>            <version>          <desc>
 * Wayne.Jiang         2020-04-27 19:51         $(VERSION)          BaseAbstractController
 */
package com.springboottemplate.redis.controller;

import com.springboottemplate.redis.utils.SpringContextUtil;
import com.springboottemplate.redis.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈BaseAbstractController〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27 19:51
 * @since v1.0.0
 */

public abstract class BaseAbstractController/*<T extends BaseEntity> extends BaseController<T>*/ {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseAbstractController.class);

    /**
     * 在Spring容器中service对象名称的后缀
     */
    private static final String SERVICE_SUFFIX = "Service";

//    @PostMapping("/saveOrUpdate")
//    public RespDto saveOrUpdate(T t) {
//        try {
//            T t1 = getService(t).saveOrUpdate(t);
//            return success(t1);
//        } catch (Exception e) {
//            LOGGER.error("saveOrUpdate error!", e);
//            return error("操作异常!");
//        }
//    }
//
//    @PostMapping("/saveOrUpdateBatch")
//    public RespDto saveOrUpdateBatch(List<T> list) {
//        return null;
//    }
//
//    @PostMapping("/delete")
//    public RespDto delete(T t) {
//        try {
//            getService(t).delete(t);
//            return success();
//        } catch (Exception e) {
//            LOGGER.error("saveOrUpdate error!", e);
//            return error("操作异常!");
//        }
//    }
//
//    @PostMapping("/deleteBatch")
//    public RespDto deleteBatch(List<T> t) {
//        return null;
//    }
//
//    @PostMapping("/findById")
//    public RespDto findById(T t) {
//        try {
//            T t1 = getService(t).findById(t);
//            return success(t1);
//        } catch (Exception e) {
//            LOGGER.error("saveOrUpdate error!", e);
//            return error("操作异常!");
//        }
//    }
//
//    @PostMapping("/findOne")
//    public RespDto findOne(T t) {
//        try {
//            T t1 = getService(t).findOne(t);
//            return success(t1);
//        } catch (Exception e) {
//            LOGGER.error("saveOrUpdate error!", e);
//            return error("操作异常!");
//        }
//    }
//
//    @PostMapping("/findByEntity")
//    public RespDto findByEntity(T t) {
//        return null;
//    }
//
//    @PostMapping("/queryAll")
//    public RespDto queryAll(T t) {
//        try {
//            Iterable<T> ts = getService(t).queryAll(t);
//            return success(ts);
//        } catch (Exception e) {
//            LOGGER.error("saveOrUpdate error!", e);
//            return error("操作异常!");
//        }
//    }
//
//    @PostMapping("/queryByPage")
//    public RespDto queryByPage(T t) {
//        return null;
//    }
//
//    /**
//     * 从Spring容器中获取对应泛型类的service
//     *
//     * @param t
//     * @return
//     */
//    private BaseService<T> getService(T t) {
//        String simpleName = t.getClass().getSimpleName();
//        String prefix = StringUtil.firstLetterToLowerCase(simpleName);
//        String beanName = prefix + SERVICE_SUFFIX;
//        return (BaseService) SpringContextUtil.getBean(beanName);
//    }
}