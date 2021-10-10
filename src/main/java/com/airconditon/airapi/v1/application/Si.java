package com.airconditon.airapi.v1.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Si {
    seoul("서울시"),
    busan("부산시"),
    ;

    private final String description;
}
