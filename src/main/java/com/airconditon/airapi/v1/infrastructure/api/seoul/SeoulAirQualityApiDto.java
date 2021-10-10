package com.airconditon.airapi.v1.infrastructure.api.seoul;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

public class SeoulAirQualityApiDto {
    @Getter
    @Setter
    @ToString
    public static class GetAirQualityResponse {
        @JsonProperty("DailyAverageCityAir")
        private SeoulAirQualityApiDto.DailyAverageCityAir dailyAverageCityAir;

    }

    @Getter
    @Setter
    @ToString
    public static class DailyAverageCityAir {
        private Integer list_total_count;
        @JsonProperty("RESULT")
        private SeoulAirQualityApiDto.Result result;
        @JsonProperty("row")
        private List<SeoulAirQualityApiDto.Row> row;


        public boolean isSuccess() {
            if (Objects.equals(result.getCode(), "INFO-000")) {
                return true;
            }
            else{

            }
            return false;
        }
    }


    @Getter
    @Setter
    @ToString
    public static class Result {
        @JsonProperty("CODE")
        private String code;
        @JsonProperty("MESSAGE")
        private String message;
    }

    @Getter
    @Setter
    @ToString
    public static class Row {
        @JsonProperty("MSRSTE_NM")
        private String gu_name;
        @JsonProperty("PM10")
        private Double pm10;
        @JsonProperty("PM25")
        private Double pm25;
        @JsonProperty("O3")
        private Double o3;
        @JsonProperty("NO2")
        private Double no2;
        @JsonProperty("CO")
        private Double co;
        @JsonProperty("SO2")
        private Double so2;

    }



}
