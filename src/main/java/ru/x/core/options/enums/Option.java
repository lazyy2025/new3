package ru.x.core.options.enums;

public interface Option {
    default String getName() {
        return "";
    }  //return "xxxx.yyyyy"
}
