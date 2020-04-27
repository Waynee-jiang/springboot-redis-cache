/**
 * Copyright (C), 2018-2020, Sol-c Ltd.
 * FileName: TMsg
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 16:42
 * Description: TMsg
 * History:
 * <author>                <time>            <version>          <desc>
 * Wayne.Jiang         2020-04-27 16:42         $(VERSION)          TMsg
 */
package com.springboottemplate.redis.entity;

import lombok.Data;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈TMsg〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27 16:42
 * @since v1.0.0
 */

//@Data
@Table(name = "tb_MessageInfo")
public class TMsg implements Serializable {

    @Id
    @Column(name = "id")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private String id;

    private String message;

    public TMsg() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}