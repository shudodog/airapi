package com.airconditon.airapi.v1.application;

import com.airconditon.airapi.v1.interfaces.api.dto.AirQualityDto;

public interface KoreaAirQualityService {
    Si getSi();

    AirQualityDto.AirQualityResult getAirQualityInfo(String gu);
}

