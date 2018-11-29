package com.example.qubin.demo;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2018/11/29
 * @Describe:
 */
public class ObserverFlatMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scan(View view) {

        demo();
    }

    /**
     * flatMap:被观察中发射一个数据之后，再用被观察者发送一次
     */
    private void demo(){
        try {
            Observable.just(getFromAssets("weather.json"))
                    .map(new Function<String, WeatherBean>() {
                        @Override
                        public WeatherBean apply(String s) throws Exception {
                            Gson gson = new Gson();
                            WeatherBean weatherBean = gson.fromJson(s, WeatherBean.class);
                            return weatherBean;
                        }
                    })
                    .flatMap(new Function<WeatherBean, ObservableSource<String>>() {
                        @Override
                        public ObservableSource<String> apply(WeatherBean weatherBean) throws Exception {
                            return Observable.just(weatherBean.getData().getCity());
                        }
                    })
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            Log.i("result:" , s);
                        }
                    });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFromAssets(String fileName) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = this.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


}
