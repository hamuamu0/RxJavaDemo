package com.example.qubin.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme: 延时操作符
 * @Data:2018/11/29
 * @Describe:
 */
public class ObserverTimeActivity extends AppCompatActivity {

    Button btn;
    int time = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);
        

    }

    public void scan(View view) {



    }

    /**
     * 定时器，轮询
     * 发送验证码倒数计时
     *
     * 默认在子线程进行轮询，可自行切换到主线程
     *
     */

    private void demo(){

        final Disposable[] disposable = {null};
        Observable.interval(0,1,TimeUnit.SECONDS,AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable[0] = d;
                    }

                    @Override
                    public void onNext(Long value) {
                        Log.i("result:",value + "");

                        btn.setText(time-- + "s");
                        if (value == 10){
                            disposable[0].dispose();
                            btn.setText("发送验证码");
                            time = 10;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    private void demo1(){
        /**
         * 范围之内轮询
         * 参数一：开始点
         * 参数二：总共轮询数量
         * 参数三：第一次开始点时时间
         * 参数四：以后每次间隔时间
         * 参数五：时间单位
         *
         * 默认是在子线程启动，如果想更新UI操作则切换到主线程
         */
        Observable.intervalRange(1,10,0,1,TimeUnit.SECONDS,AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.i("result:",aLong + "");
                        btn.setText(time-- + "s");
                        if (aLong == 10){
                            btn.setText("发送验证码");
                            time = 10;
                        }
                    }
                });

    }

    private void demo2(){
        /**
         * 范围取值
         * 参数为开始和结束范围，包含两者。
         */

        Observable.range(1,10)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.i("result:",integer + "");
                    }
                });
    }

    private void demo3(){
        /**
         * 延时操作
         * 参数一：延迟时间
         * 参数二：单位时间
         */
        Observable.timer(5,TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.i("result:",aLong + "");
                    }
                });
    }

    private void demo4(){
        /**
         * 在被观察者发送数据之前添加一个额外的数据
         *
         */
        Observable.just(1,2,3,4)
                .startWith(5)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.i("result:",integer + "");
                    }
                });

        /**
         * 在被观察者发送数据之前添加多个额外的数据
         */
        Observable.just(1,2,3,4,5)
                .startWithArray(5,6,7,8)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.i("result:",integer + "");
                    }
                });
    }





}
