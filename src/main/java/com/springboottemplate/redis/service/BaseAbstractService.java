/**
 * Copyright (C), 2018-2020, Sol-c Ltd.
 * FileName: BaseAbstractService
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 19:41
 * Description: BaseAbstractService
 * History:
 * <author>                <time>            <version>          <desc>
 * Wayne.Jiang         2020-04-27 19:41         $(VERSION)          BaseAbstractService
 */
package com.springboottemplate.redis.service;

import com.github.pagehelper.Page;
import com.springboottemplate.redis.utils.SpringContextUtil;
import com.springboottemplate.redis.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 〈一句话功能简述〉<br> 
 * 〈BaseAbstractService〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27 19:41
 * @since v1.0.0
 */

public abstract class BaseAbstractService/*<T extends BaseEntity> implements BaseService<T>*/ {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseAbstractService.class);

    /**
     * 在Spring容器中repository对象名称的后缀
     */
    private static final String REPOSITORY_SUFFIX = "Repository";


//    @Override
//    public T saveOrUpdate(T t) {
//        return getRepository(t).save(t);
//    }
//
//    @Override
//    public Iterable<T> saveOrUpdateBatch(List<T> list) {
//        return null;
//    }
//
//    @Override
//    public void delete(T t) {
//        getRepository(t).delete(t);
//    }
//
//    @Override
//    public void deleteBatch(List<T> list) {
//
//    }
//
//    @Override
//    public T findById(T t) {
//        return getRepository(t).findOne(t.getId());
//    }
//
//    @Override
//    public T findOne(T t) {
//        Iterable<T> byEntity = findByEntity(t);
//        if (byEntity != null) {
//            return byEntity.iterator().next();
//        }
//        return null;
//    }
//
//    @Override
//    public Iterable<T> findByEntity(T t) {
//        return null;
//    }
//
//    @Override
//    public Iterable<T> queryAll(T t) {
//        return getRepository(t).findAll();
//    }
//
//    @Override
//    public Page<T> queryByPage(T t) {
//        return null;
//    }
//
//    /**
//     * 从Spring容器中获取对应泛型类的repository
//     *
//     * @param t
//     * @return
//     */
//    private BaseRepository<T> getRepository(T t) {
//        String simpleName = t.getClass().getSimpleName();
//        String prefix = StringUtil.firstLetterToLowerCase(simpleName);
//        String beanName = prefix + REPOSITORY_SUFFIX;
//        return (BaseRepository) SpringContextUtil.getBean(beanName);
//    }
}

/**
 * @author Kxh
 * @2018.08.02
 * @利用反射实现对数据库增删改查的泛型类
 * javabean 中属性名，类名必须与数据库表中的字段名，表明相同
 */
//public class BaseDao<T> {
//
//    /**
//     * 对数据库进行插入数据操作
//     * @param t1 t1为javabean中的类型
//     */
//    public void add(T t1) {
//        Class c = t1.getClass();
//        String Simplename = c.getSimpleName();
//        StringBuilder stb = new StringBuilder("insert into  " + Simplename+ " ");
//        StringBuilder stbColName = new StringBuilder("(");
//        StringBuilder stbValue = new StringBuilder("values(");
//        Field[] f = c.getDeclaredFields();
//        try {
//            int i = f.length - 1;
//            for (Field ff : f) {
//                String name = ff.getName();
//                Class type = ff.getType();
//                stbColName.append(name);
//                stbValue.append("?");
//                if (i > 0) {
//                    stbColName.append(",");
//                    stbValue.append(",");
//                }
//                i--;
//            }
//            stbColName.append(")");
//            stbValue.append(")");
//            stb.append(stbColName + " " + stbValue);
//            Connection conn = DButil.getConn();
//            PreparedStatement pstm = null;
//            pstm = conn.prepareStatement(new String(stb));
//            int result = 0;
//            for (i = 0; i < f.length; i++) {
//                Object value=null;
//                String name  = f[i].getName();
//                f[i].setAccessible(true);
//                Class type = f[i].getType();
//                if (type == String.class) {
//                    if (f[i].get(t1) == null) {
//                        pstm.setNull(i + 1, Types.VARCHAR);
//                    } else {
//                        pstm.setObject(i + 1, f[i].get(t1));
//                    }
//                } else if (type == Date.class) {
//                    if (f[i].get(t1) == null) {
//                        pstm.setNull(i + 1,Types.DATE);
//                    } else {
//                        pstm.setObject(i + 1, f[i].get(t1));
//                    }
//                }else{
//                    if (f[i].get(t1) == null) {
//                        pstm.setNull(i + 1,Types.INTEGER);
//                    } else {
//                        pstm.setObject(i + 1, f[i].get(t1));
//                    }
//                }
//            }
//            result = pstm.executeUpdate();
//            System.out.println(result);
//
//        } catch (SecurityException e) {
//
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IllegalArgumentException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//    /**
//     * 对数据库做修改
//     * 只需传入一个javabean
//     * @param T t1
//     * 暂时还没有办法在javabean中标志出主键，所以默认Field[]数组中的一个元素为主键
//     */
//    public void update(T t1) {
//        Class c = t1.getClass();
//        String Simplename = c.getSimpleName();
//        StringBuilder stb = new StringBuilder("update  " + Simplename + " set ");
//        Field[] f = c.getDeclaredFields();
//        int i = 0;
//        try {
//            for (i = 1; i < f.length; i++) {
//                String name = f[i].getName();
//                Class type = f[i].getType();
//                f[i].setAccessible(true);
//                System.out.println(name);
//                stb.append(name + "=? ");
//                if (i + 1 < f.length) {
//                    stb.append(",");
//                }
//            }
//            stb.append(" where " + f[0].getName() + " =?");
//            System.out.println(stb);
//            Connection conn = DButil.getConn();
//            PreparedStatement pstm = null;
//            pstm = conn.prepareStatement(new String(stb));
//            f[0].setAccessible(true);
//            pstm.setObject(f.length, f[0].get(t1));
//            int result = 0;
//            for (i = 1; i < f.length; i++) {
//                pstm.setObject(i, f[i].get(t1));
//            }
//            pstm.setObject(f.length, f[0].get(t1));
//
//            result = pstm.executeUpdate();
//            System.out.println(result);
//
//        } catch (SecurityException e) {
//
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IllegalArgumentException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//}
