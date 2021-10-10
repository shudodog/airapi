package com.airconditon.airapi.v1.application;

import com.airconditon.airapi.v1.interfaces.api.dto.AirQualityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class AirQualityService {
    private final KoreaAirQualityServiceFactory koreaAirQualityServiceFactory;

    @Cacheable(value="Sigu", key = "'KeyIs' + #si + #gu")
    public AirQualityDto.AirQualityResult getAirQualityInfo(Si si, String gu) {
        KoreaAirQualityService service = koreaAirQualityServiceFactory.getService(si);

        var airQualityInfo = service.getAirQualityInfo(gu);
        return airQualityInfo;
    }
}
