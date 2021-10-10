package com.airconditon.airapi.v1.interfaces.api;


import com.airconditon.airapi.v1.application.AirQualityService;
import com.airconditon.airapi.v1.application.Si;
import com.airconditon.airapi.v1.interfaces.api.dto.AirQualityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
public class AirQualityApiControllerV1 {


    private final AirQualityService airQualityService;

    @GetMapping("/api/v1/{si}")
    public AirQualityDto.AirQualityResult getsi(@PathVariable Si si) {
        return airQualityService.getAirQualityInfo(si, "none");
    }

    @GetMapping("/api/v1/{si}/{gu}")
    public AirQualityDto.AirQualityResult getsigu(@PathVariable Si si, @PathVariable String gu) {
        return airQualityService.getAirQualityInfo(si, gu);
    }
}
