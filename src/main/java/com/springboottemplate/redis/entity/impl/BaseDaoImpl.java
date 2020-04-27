/**
 * Copyright (C), 2018-2020, Sol-c Ltd.
 * FileName: BaseDaoImpl
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 18:41
 * Description: BaseDaoImpl
 * History:
 * <author>                <time>            <version>          <desc>
 * Wayne.Jiang         2020-04-27 18:41         $(VERSION)          BaseDaoImpl
 */
package com.springboottemplate.redis.entity.impl;

import com.springboottemplate.redis.entity.base.IBaseDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br>
 * 〈BaseDaoImpl〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27 18:41
 * @since v1.0.0
 */

//设置为抽象的, 不让他实例化, 让其子类实例化就行了
//通过泛型设计通用方法的关键就是利用反射拿到泛型的具体类型
public abstract class BaseDaoImpl<T> implements IBaseDao<T> {
    private String tableName; //表名
    private Class<T> actualType;//真实类型

    /**
     * findById(Integer id)这个方法被子类继承了, 假设我们在UserDaoImpl中操作, 此时参数化类型T为User
     * 下面的讲解都假设是在UserDaoImpl中进行的
     */
    //把公共部分可以放到构造方法中
    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        //返回类型是Type 是 Java 编程语言中所有类型的公共高级接口. 它们包括原始类型、参数化类型、数组类型、类型变量和基本类型.
        //Type的已知子接口: ParameterizedType 表示参数化类型, 如 Collection<String>.
        //getClass()得到UserDaoImpl的Class, 得到Class一般有3中方式: getClass(),  类名.class,  Class.forName()
        Type type = getClass().getGenericSuperclass();//获取UserDaoImpl<User>的参数化类型的父类BaseDaoImpl<User>
        //由于我们得到的是一个参数化类型, 所以转成ParameterizedType, 因为需要使用里面的方法
        ParameterizedType pt = (ParameterizedType) type;//强转
        Type[] actualTypeArr = pt.getActualTypeArguments();//获取真实参数类型数组[User.class], 可以调试看到这里的值
        actualType = (Class<T>) actualTypeArr[0];//数组只有一个元素
        tableName = actualType.getSimpleName();
    }

    @Override
    public T findById(Integer id) {
        String sql = "select * from " + tableName + " where id = ?";
//        try {
//            return null;
//            return QRUtils.getQueryRunner().query(sql, new BeanHandler<T>(actualType), id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
//
//class A {
//    private String name;
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String toString() {
//        return "A{'name':" + this.name + "}";
//    }
//}
//
//class B<T, PK extends Serializable> {
//    Class<T> ref;
//
//    public B() {
//        Class c = getClass();
//        Type type = c.getGenericSuperclass();
//        if (type instanceof ParameterizedType) {
//            Type[] paramsType = ((ParameterizedType) type).getActualTypeArguments();
//            ref = (Class<T>) paramsType[0];
//        }
//    }
//
//    public String getRefType() {
//        return ref.getName();
//    }
//}
