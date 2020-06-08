package com.lsh.jgstudy.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @Author: liusihui
 * @CreateDate: 2020-06-05 17:32
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //监听该应用所以的生命周期
        //谷歌工程师已经做了Aop的思想
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                Log.e("netwase >>>",activity.getComponentName().getClassName()+"Created");
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                Log.e("netwase >>>",activity.getComponentName().getClassName()+"Destroyed");

            }
        });
    }
}
