package com.airconditon.airapi.v1.infrastructure.api.seoul;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SeoulAirQualityApi {


    String serviceKey = "536c58687267757531334b46554b41";

    @GET( serviceKey + "/json/DailyAverageCityAir/1/25/{date}?START_INDEX=1&END_INDEX=25")
    Call<SeoulAirQualityApiDto.GetAirQualityResponse> getAirQuality(@Path("date") String date);


}
