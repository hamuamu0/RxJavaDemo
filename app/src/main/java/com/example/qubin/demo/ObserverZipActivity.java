package com.example.qubin.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme: 合并操作符
 * @Data:2018/11/29
 * @Describe:
 */
public class ObserverZipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scan(View view) {



    }


    private void demo6(){
        //组合操作符，将被观察者的数据合并之后按照顺序依次发送出去（最多组合四个）
        Observable.concat(Observable.just(1,2,3,4),Observable.just(5,6,7,8),Observable.just(9,10,11,12),Observable.just(13,14,15,16))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.i("result:",integer + "");
                    }
                });

        //组合数组，可以大于四个
        Observable.concatArray(Observable.just(1,2,3,4),Observable.just(5,6,7,8),Observable.just(9,10,11,12),Observable.just(13,14,15,16)
                ,Observable.just(17,18,19,20))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.i("result:",integer + "");
                    }
                });
    }

    private void demo7(){
        /**
         * zip为合并操作符
         * 将多个被观察者发送的数据合并在一起发送给观察者
         * 如果一个被观察者数据多于另一个被观察者，那么合并发送数据的数量以最少的那个为主
         * 在同一个线程中执行，则按照优先顺序发送，在不同线程执行，则同时发送
         */
        Observable.zip(Observable.just(1, 2, 3, 4,5), Observable.just(5, 6, 7, 8), new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i("result:",integer + "");
            }
        });
    }



}
