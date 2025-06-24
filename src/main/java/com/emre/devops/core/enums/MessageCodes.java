package com.emre.devops.core.enums;

import lombok.Getter;

@Getter
public enum MessageCodes {
    SUCCESS("200", "general.success"),
    FAIL("500", "general.fail"),
    BAD_REQUEST("400", "general.badRequest"),
    NOT_FOUND("404", "general.notFound"),
    UNAUTHORIZED("401", "general.unauthorized"),
    ENTITY_NOT_FOUND("404", "general.entityNotFound");

    private final String code;
    private final String message;

    MessageCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
