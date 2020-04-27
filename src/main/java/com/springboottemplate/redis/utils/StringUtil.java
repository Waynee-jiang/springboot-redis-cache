/**
 * Copyright (C), 2018-2020, Sol-c Ltd.
 * FileName: StringUtil
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 19:38
 * Description: StringUtil
 * History:
 * <author>                <time>            <version>          <desc>
 * Wayne.Jiang         2020-04-27 19:38         $(VERSION)          StringUtil
 */
package com.springboottemplate.redis.utils;

import com.alibaba.druid.util.StringUtils;

/**
 * 〈一句话功能简述〉<br> 
 * 〈StringUtil 〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27 19:38
 * @since v1.0.0
 */

public class StringUtil {
    /**
     * 首字母转小写
     *
     * @param str
     * @return
     */
    public static String firstLetterToLowerCase(String str) {
        if (!StringUtils.isEmpty(str)) {
            char[] chars = str.toCharArray();
            chars[0] = (char) (chars[0] >= 65 && chars[0] <= 90 ? chars[0] + 32 : chars[0]);
            return String.valueOf(chars);
        }
        return null;
    }
}