/**
 * Copyright (C), 2018-2020, Sol-c Ltd.
 * FileName: BaseDaoUtil
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 19:04
 * Description: BaseDaoUtil
 * History:
 * <author>                <time>            <version>          <desc>
 * Wayne.Jiang         2020-04-27 19:04         $(VERSION)          BaseDaoUtil
 */
package com.springboottemplate.redis.entity.impl;

import com.springboottemplate.redis.utils.DataSourceUtil;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈BaseDaoUtil〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27 19:04
 * @since v1.0.0
 */

public abstract class BaseDaoUtil<T> {
    /**获取当前类的类型，实际上获取的是BaseDaoUtil<T>子类中的<T>这个类型的实际类型 */
    private Class<T> type;

    {
        /**思路：获取当前BaseDaoUtil的子类继承的父类中泛型 <T> 的实际类型*/

        /**
         *1、返回当前类的直接继承的父类（包含泛型参数），也就是BaseDaoUtil这个类。这个 this 指的不是BaseDaoUtil这个对象，
         * 而是BaseDaoUtil这个类的子类的实例化对象
         * */
        Type sType = this.getClass().getGenericSuperclass();

        /**
         /2、将sType的类型强转为ParameterizedType类型，因为Type类中没有任何方法，ParameterizedType类是这个类中有一个
         * getActualTypeArguments方法，可以获取到当前BaseDaoUtil的子类继承的父类中所有泛型的实际类型的参数列表，返回
         * 值是一个数组。此时父类中只有一个 <T> ，那么该数组中只有一个参数，也就是第0个位置就是 <T> 的实际类型。
         */
        ParameterizedType pType = (ParameterizedType) sType;

        /**3、获取泛型的实际参数的参数列表*/
        Type[] types = pType.getActualTypeArguments();

        /**4、将第一个参数的实际类型赋值给type*/
        type = (Class<T>) types[0];
    }



    /**通用查询*/
    protected T getBean(String sql,Object... objects) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        //获取数据库连接
        Connection connection = DataSourceUtil.getConnection();
        try {
            ps = connection.prepareStatement(sql);
            if(objects != null && objects.length != 0){
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i+1,objects[i]);
                }
            }

            /**获取结果集*/
            rs = ps.executeQuery();

            /***
             * 思路：
             * 反射如何为任意对象的任意属性赋值？
             * 需要借助元数据来完成
             * 步骤：
             * 1、通过newInstance方法实例化一个 <T> 对象
             * 2、获取属性对象
             * 3、设置属性可访问
             * 4、设置属性值
             */


            /**
             * 元数据：
             * 获取结果集的元数据对象（元数据：描述数据的数据，描述结果集中的数据的数据）
             * 例如：结果集记录的列数
             *       结果集的字段列表
             *       相当于SQLyog查询了结果的标题行
             */
            ResultSetMetaData metaData = rs.getMetaData();
            /**通过元数据获取当前列的列数*/
            int columnCounts = metaData.getColumnCount();

            //1、实例化一个 <T> 对象
            T result = type.newInstance();

            if (rs.next()){
                for (int i = 0; i < columnCounts; i++) {
                    //2、通过元数据对象获取当前列的列名，注意：列名的下标从 1 开始，不是从 0 开始
                    String columnName = metaData.getColumnName(i + 1);
                    //3、通过列名获得属性对象：忽略属性的访问修饰符
                    Field field = type.getDeclaredField(columnName);
                    //4、设置属性无论是否受保护都能被访问
                    field.setAccessible(true);
                    //5、为type类中的该属性赋值：ResultSet的getxxx方法的下标也是从 1 开始
                    field.set(result,rs.getObject(i+1));
                }

            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}