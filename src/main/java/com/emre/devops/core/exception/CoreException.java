package com.emre.devops.core.exception;

import com.emre.devops.core.enums.MessageCodes;
import lombok.Getter;

@Getter
public class CoreException extends RuntimeException {

    private final MessageCodes code;
    private final String message;
    private final Object[] args;

    public CoreException(MessageCodes code, Object... args) {
        this.code = code;
        this.args = args;
        this.message = null;
    }

    public CoreException(MessageCodes code, String message) {
        this.code = code;
        this.args = null;
        this.message = message;
    }
}
