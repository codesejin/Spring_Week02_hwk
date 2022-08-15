package com.sparta.spring_week02_hwk.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class PersonRequestDto {
    private final String name;
    private final int age;
    private final String address;
    private final String job;
}
