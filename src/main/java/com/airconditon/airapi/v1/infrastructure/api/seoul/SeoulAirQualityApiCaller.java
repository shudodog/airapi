package com.airconditon.airapi.v1.infrastructure.api.seoul;

import com.airconditon.airapi.v1.application.KoreaAirQualityService;
import com.airconditon.airapi.v1.application.Si;
import com.airconditon.airapi.v1.application.util.AirQualityGradeUtil;
import com.airconditon.airapi.v1.interfaces.api.dto.AirQualityDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

@Slf4j
@Component
public class SeoulAirQualityApiCaller implements KoreaAirQualityService {
    private final  SeoulAirQualityApi seoulAirQualityApi;
    private final AirQualityDto.AirQualityResult airQualityApiDto;

    public SeoulAirQualityApiCaller(@Value("${api.seoul.base-url}") String baseUrl) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();

        this.seoulAirQualityApi = retrofit.create(SeoulAirQualityApi.class);
        this.airQualityApiDto = new AirQualityDto.AirQualityResult();
    }

    @Override
    public Si getSi() {
        return Si.seoul;
    }

    public AirQualityDto.AirQualityResult getAirQualityInfo(String gu) {
        try {
            var call = seoulAirQualityApi.getAirQuality(TodayDate.now());
            var response = call.execute().body();

            if (response == null || response.getDailyAverageCityAir() == null) {
                throw new RuntimeException("getAirQuality 응답값이 존재하지 않습니다.");
            }

            if (response.getDailyAverageCityAir().isSuccess()) {
                log.info(response.toString());
                Integer n = response.getDailyAverageCityAir().getList_total_count();
                Double si_pm10_sum = 0.0;
                airQualityApiDto.setList_total_count(n);
                AirQualityDto.Gu_list[] gu_list = new AirQualityDto.Gu_list[n];
                int i = 0;
                Integer gu_name_num = -1;
                for(SeoulAirQualityApiDto.Row row : response.getDailyAverageCityAir().getRow()){
                    AirQualityDto.Gu_list gu_list1 = new AirQualityDto.Gu_list(row.getGu_name(), row.getPm10(),
                            row.getPm25(), row.getO3(),row.getNo2(), row.getCo(), row.getSo2() );
                    si_pm10_sum += row.getPm10();
                    if(gu.equals(row.getGu_name())){
                        gu_name_num = i;
                    }
                    gu_list[i++] = gu_list1;
                }
                airQualityApiDto.setGu_list(gu_list);
                airQualityApiDto.setPm10_average(si_pm10_sum/n);
                airQualityApiDto.setPm10_average_grade(AirQualityGradeUtil.pm10_grade(si_pm10_sum/n));
                if(gu_name_num != -1){
                    AirQualityDto.Gu_list[] gu_list1 = new AirQualityDto.Gu_list[1];
                    gu_list1[0] = airQualityApiDto.getGu_list()[gu_name_num];
                    airQualityApiDto.setGu_list(gu_list1);
                    airQualityApiDto.setList_total_count(1);
                }

                return airQualityApiDto;
            }

            throw new RuntimeException("getAirQuality 응답이 올바르지 않습니다. header=" + response.getDailyAverageCityAir().getResult());

        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("getAirQuality API error 발생! errorMessage=" + e.getMessage());
        }

    }
}



