package ru.x.core.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeZone {

    @PostConstruct
    public void init() {
        java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Europe/Moscow"));
        log.info("Set time zone Europe/Moscow on server");
    }
}
