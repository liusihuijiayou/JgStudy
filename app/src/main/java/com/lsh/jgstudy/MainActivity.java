package com.lsh.jgstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lsh.jgstudy.activity.OrderActivity;
import com.lsh.jgstudy.aop.DBOperation;
import com.lsh.jgstudy.factory.SampleFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 工厂模式
 * 核心：提供一个创建对象的功能，不需要关心具体实现
 *
 * */
public class MainActivity extends AppCompatActivity implements DBOperation {


    private DBOperation db;
    private final static String TAG="netease >>>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //常规编码
//        Api api=new ApiImpl();
//        api.create();

        //简单工厂：降低了模块间的耦合度
        Api api= SampleFactory.creatApi();
        api.create();

        //拓展：根据参数产生不同的实现

      //  db=this;


        //运行时动态代理 做了一个切面
        db= (DBOperation) Proxy.newProxyInstance(DBOperation.class.getClassLoader(),new Class[]{DBOperation.class},new DBHander(this));



    }


    //点击事件
    public void jump(View view) {
      //  startActivity(new Intent(this, OrderActivity.class));
/*
//常规写法
        db.save();
        db.delete();

        db.save();
        db.insert();
*/

db.delete();

    }

    @Override
    public void insert() {
        Log.e(TAG,"插入数据");

    }

    @Override
    public void delete() {
        Log.e(TAG,"删除数据");
    }

    @Override
    public void updata() {
        Log.e(TAG,"更新数据.");
    }

    @Override
    public void save() {
        Log.e(TAG,"保存数据");
    }

   class DBHander implements InvocationHandler {

       private DBOperation db;

       public DBHander(DBOperation db) {
           this.db = db;
       }

       //切面本面
       @Override
       public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
           if (db!=null){
               Log.e(TAG,"操作数据库之前，开始备份...");
               save(); //查询数据库后备份
               Log.e(TAG,"数据备份完成，等待操作");
               return method.invoke(db,args);

           }
           return null;
       }
   }
}
