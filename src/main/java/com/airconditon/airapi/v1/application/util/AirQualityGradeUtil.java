package com.airconditon.airapi.v1.application.util;

public class AirQualityGradeUtil {
    private AirQualityGradeUtil() {
    }

    public static String pm25_grade(Double pm25) {
        if (pm25 <= 15){
            return "좋음";
        }else if (pm25 <= 35){
            return "보통";
        }else if (pm25 <= 75){
            return "나쁨";
        }else{
            return "매우나쁨";
        }
    }

    public static String pm10_grade(Double pm10){
        if (pm10 <= 30){
            return "좋음";
        }else if (pm10 <= 80){
            return "보통";
        }else if (pm10 <= 150){
            return "나쁨";
        }else{
            return "매우나쁨";
        }
    }



    public static String o3_grade(Double o3) {
        if (o3 <= 0.030){
            return "좋음";
        }else if (o3 <= 0.090){
            return "보통";
        }else if (o3 <= 0.150){
            return "나쁨";
        }else{
            return "매우나쁨";
        }
    }

    public static String no2_grade(Double no2) {
        if (no2 <= 0.030){
            return "좋음";
        }else if (no2 <= 0.060){
            return "보통";
        }else if (no2 <= 0.200){
            return "나쁨";
        }else{
            return "매우나쁨";
        }
    }

    public static String co_grade(Double co) {
        if (co <= 2){
            return "좋음";
        }else if (co <= 9){
            return "보통";
        }else if (co <= 15){
            return "나쁨";
        }else{
            return "매우나쁨";
        }
    }

    public static String so2_grade(Double so2) {
        if (so2 <= 0.020){
            return "좋음";
        }else if (so2 <= 0.050){
            return "보통";
        }else if (so2 <= 0.150){
            return "나쁨";
        }else{
            return "매우나쁨";
        }
    }
}


