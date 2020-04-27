/**
 * Copyright (C), 2018-2020, Sol-c Ltd.
 * FileName: PageBean
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 19:22
 * Description: PageBean
 * History:
 * <author>                <time>            <version>          <desc>
 * Wayne.Jiang         2020-04-27 19:22         $(VERSION)          PageBean
 */
package com.springboottemplate.redis.entity.base;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈PageBean〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27 19:22
 * @since v1.0.0
 */

public class PageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private  int count = 0;
    private int pageSize = 20;
    private  int pageCount = 0;
    private int page = 1;
    private boolean pagging = true; //

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isPagging() {
        return pagging;
    }

    public void setPagging(boolean pagging) {
        this.pagging = pagging;
    }
}