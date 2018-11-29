package com.example.qubin.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme: 过滤操作符
 * @Data:2018/11/29
 * @Describe:
 */
public class ObserverFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scan(View view) {



    }

    private void demo5(){
        /**
         * 过滤操作符
         * 此处将小于4的过滤掉，输出5，6，7，8，9
         */
        Observable.just(1,2,3,4,5,6,7,8,9)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer > 4;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i("result:",integer + "");
            }
        });
    }

    private void demo6(){
        /**
         * 过滤掉重复内容
         * 此处将1和3重复的过滤掉，输出1，2，3，4，5
         */
        Observable.just(1,2,3,1,4,5,3)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.i("result:",integer + "");
                    }
                });
    }

    private void demo7(){
        /**
         * 过滤掉连续重复事件
         * 此处将连续重复的5和2过滤掉
         */
        Observable.just(1,2,3,4,5,5,4,2,2,1)
                .distinctUntilChanged()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.i("result:",integer + "");
                    }
                });
    }
}
