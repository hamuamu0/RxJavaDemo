package com.example.qubin.demo;

import java.util.List;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme: 天气bean
 * @Data:2018/11/29
 * @Describe:
 */
public class WeatherBean {


    /**
     * status : 200
     * data : {"wendu":"29","ganmao":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","forecast":[{"fengxiang":"南风","fengli":"3-4级","high":"高温 32℃","type":"多云","low":"低温 17℃","date":"16日星期二"},{"fengxiang":"南风","fengli":"微风级","high":"高温 34℃","type":"晴","low":"低温 19℃","date":"17日星期三"},{"fengxiang":"南风","fengli":"微风级","high":"高温 35℃","type":"晴","low":"低温 22℃","date":"18日星期四"},{"fengxiang":"南风","fengli":"微风级","high":"高温 35℃","type":"多云","low":"低温 22℃","date":"19日星期五"},{"fengxiang":"南风","fengli":"3-4级","high":"高温 34℃","type":"晴","low":"低温 21℃","date":"20日星期六"}],"yesterday":{"fl":"微风","fx":"南风","high":"高温 28℃","type":"晴","low":"低温 15℃","date":"15日星期一"},"aqi":"72","city":"北京"}
     * message : OK
     */

    private int status;
    private DataBean data;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * wendu : 29
         * ganmao : 各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。
         * forecast : [{"fengxiang":"南风","fengli":"3-4级","high":"高温 32℃","type":"多云","low":"低温 17℃","date":"16日星期二"},{"fengxiang":"南风","fengli":"微风级","high":"高温 34℃","type":"晴","low":"低温 19℃","date":"17日星期三"},{"fengxiang":"南风","fengli":"微风级","high":"高温 35℃","type":"晴","low":"低温 22℃","date":"18日星期四"},{"fengxiang":"南风","fengli":"微风级","high":"高温 35℃","type":"多云","low":"低温 22℃","date":"19日星期五"},{"fengxiang":"南风","fengli":"3-4级","high":"高温 34℃","type":"晴","low":"低温 21℃","date":"20日星期六"}]
         * yesterday : {"fl":"微风","fx":"南风","high":"高温 28℃","type":"晴","low":"低温 15℃","date":"15日星期一"}
         * aqi : 72
         * city : 北京
         */

        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private String aqi;
        private String city;
        private List<ForecastBean> forecast;

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * fl : 微风
             * fx : 南风
             * high : 高温 28℃
             * type : 晴
             * low : 低温 15℃
             * date : 15日星期一
             */

            private String fl;
            private String fx;
            private String high;
            private String type;
            private String low;
            private String date;

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }

        public static class ForecastBean {
            /**
             * fengxiang : 南风
             * fengli : 3-4级
             * high : 高温 32℃
             * type : 多云
             * low : 低温 17℃
             * date : 16日星期二
             */

            private String fengxiang;
            private String fengli;
            private String high;
            private String type;
            private String low;
            private String date;

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }
    }
}
