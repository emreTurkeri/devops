package com.emre.devops.core.rest;

import com.emre.devops.core.enums.MessageCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MetaResponse {

    private String code;
    private String description;

    public static MetaResponse of(String code, String description) {
        return new MetaResponse(code, description);
    }

    public static MetaResponse success() {
        return new MetaResponse(MessageCodes.SUCCESS.getCode(), "Success");
    }

    public static MetaResponse fail(String description) {
        return new MetaResponse(MessageCodes.FAIL.getCode(), description);
    }


}
