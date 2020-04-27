/**
 * Copyright (C), 2018-2020, Sol-c Ltd.
 * FileName: DataSourceUtil
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 19:06
 * Description: DataSourceUtil
 * History:
 * <author>                <time>            <version>          <desc>
 * Wayne.Jiang         2020-04-27 19:06         $(VERSION)          DataSourceUtil
 */
package com.springboottemplate.redis.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈DataSourceUtil 〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27 19:06
 * @since v1.0.0
 */

public class DataSourceUtil {

    private static String driver = "com.mysql.jdbc.Driver";

    private static String url = "jdbc:mysql://localhost:3306/test";

    private static String userName = "wayne";

    private static String password = "wayne";

    /**获取数据源连接*/
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, userName, password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


}
