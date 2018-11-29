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
import java.io.InputStream;
import java.io.InputStreamReader;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme: Map转换操作符
 * @Data:2018/11/29
 * @Describe:
 */
public class ObserverMapActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scan(View view) {
        demo();
    }

    /**
     * Map操作符
     * 将一种类型转换为另外一种类型
     * 这里将json转为bean
     */
    private void demo(){
        try {
            String fromAssets = getFromAssets("weather.json");
            Observable.just(fromAssets)
                    .map(new Function<String, WeatherBean>() {
                        @Override
                        public WeatherBean apply(String s) throws Exception {
                            Gson gson = new Gson();
                            WeatherBean weatherBean = gson.fromJson(s, WeatherBean.class);
                            return weatherBean;
                        }
                    }).subscribe(new Consumer<WeatherBean>() {
                @Override
                public void accept(WeatherBean weatherBean) throws Exception {

                    Log.i("result:",weatherBean.getData().getCity());
                    Log.i("result:",weatherBean.getData().getAqi());
                    Log.i("result:",weatherBean.getData().getForecast()+"");

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
