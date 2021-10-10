package com.airconditon.airapi.v1.interfaces.api.dto;

import com.airconditon.airapi.v1.application.util.AirQualityGradeUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


public class AirQualityDto {

    @Getter
    @Setter
    @ToString
    public static class AirQualityResult implements Serializable {
        private Double pm10_average;
        private String pm10_average_grade;
        private Integer list_total_count;
        private Gu_list[] gu_list;
    }


    @Getter
    @ToString
    public static class Gu_list implements Serializable{
        private final String gu_name;
        private final Double pm10;
        private final Double pm25;
        private final Double o3;
        private final Double no2;
        private final Double co;
        private final Double so2;

        private final String pm10_grade;
        private final String pm25_grade;
        private final String o3_grade;
        private final String no2_grade;
        private final String co_grade;
        private final String so2_grade;

        public Gu_list(String gu_name, Double pm10, Double pm25, Double o3, Double no2, Double co, Double so2) {
            this.gu_name = gu_name;
            this.pm10 =  pm10;
            this.pm25 = pm25;
            this.o3 = o3;
            this.no2 = no2;
            this.co = co;
            this.so2 = so2;

            this.pm10_grade = AirQualityGradeUtil.pm10_grade(pm10);
            this.pm25_grade = AirQualityGradeUtil.pm25_grade(pm25);
            this.o3_grade = AirQualityGradeUtil.o3_grade(o3);
            this.no2_grade = AirQualityGradeUtil.no2_grade(no2);
            this.co_grade = AirQualityGradeUtil.co_grade(co);
            this.so2_grade = AirQualityGradeUtil.so2_grade(so2);
        }




    }



}