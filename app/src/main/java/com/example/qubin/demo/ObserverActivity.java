package com.example.qubin.demo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;



public class ObserverActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void scan(View view) {


    }

    private void demo1(){
        //被观察者
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("aa");
                e.onNext("bb");
                e.onNext("cc");
                e.onNext("dd");
                e.onComplete();
            }
        });

        //观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                //TODO 初始化数据
                d.dispose();
            }

            @Override
            public void onNext(String value) {
                //TODO 接收被观察者发送的数据
                Log.i("result:",value);

            }

            @Override
            public void onError(Throwable e) {
                //TODO 错误

            }

            @Override
            public void onComplete() {
                //TODO 完成之后回调
            }
        };

        //订阅
        observable.subscribe(observer);
    }

    private void demo2(){
        //链式结构
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("aa");
                e.onNext("bb");
                e.onNext("cc");
                e.onNext("dd");
                e.onComplete();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                Log.i("result:",value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void demo3(){
        //偷懒写法一
        Observable.just("aa","bb","cc","dd")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String value) throws Exception {
                        Log.i("result:",value);
                    }
                });

        //偷懒写法二
        String[] arr = {"aa","bb","cc","dd"};
        Observable.fromArray(arr)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String value) throws Exception {
                        Log.i("result:",value);
                    }
                });
    }









}
