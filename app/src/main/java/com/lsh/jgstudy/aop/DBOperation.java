package com.lsh.jgstudy.aop;

/**
 * @Author: liusihui
 * @CreateDate: 2020-06-05 17:55
 */
public interface DBOperation {
    void insert();

    void delete();

    void updata();

    //数据备份
    void save();
}
