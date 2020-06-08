package com.lsh.jgstudy;

import android.util.Log;

import com.lsh.jgstudy.bean.UserInfo;

/**
 * @Author: liusihui
 * @CreateDate: 2020-06-05 15:40
 */
public class ApiImpl implements Api {
    @Override
    public UserInfo create() {
        UserInfo info=new UserInfo();
        Log.e("netease >>>",info.toString());
        return null;
    }
}
