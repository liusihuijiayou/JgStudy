package com.lsh.jgstudy.factory;

import com.lsh.jgstudy.Api;
import com.lsh.jgstudy.ApiImpl;

/**
 * @Author: liusihui
 * @CreateDate: 2020-06-05 15:45
 */
public class SampleFactory {

    public static Api creatApi(){
        return new ApiImpl();
    }

}
