package com.example.qubin.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme: 线程之间的切换
 * @Data:2018/11/29
 * @Describe:
 */
public class ObserverThreadtChangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void scan(View view) {



    }

    private void demo1(){
        //线程之间的切换
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

                Log.i("currentThread111:",Thread.currentThread().getName());
                e.onNext("abcdefg");

            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String value) throws Exception {
                        Log.i("currentThread222:",Thread.currentThread().getName());

                    }
                });
    }
}
