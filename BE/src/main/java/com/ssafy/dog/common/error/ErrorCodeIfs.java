package com.ssafy.dog.common.error;

public interface ErrorCodeIfs {
    Integer getHttpStatusCode();

    Integer getErrorCode();

    String getDescription();
}

