package com.bombo.reviser.common.error;

import lombok.Getter;

/**
 * @since 1.0
 * @author bombo
 * @see com.bombo.reviser.api.common.GlobalExceptionHandler
 * @see com.bombo.reviser.api.common.response.ErrorResponse
 */
@Getter
public enum ErrorCode {
    // SERVER
    INTERNAL_SERVER_ERROR("S_001", "서버에서 에러가 발생하였습니다."),

    // BAD_REQUEST
    BAD_REQUEST("C_001", "입력 값에서 오류가 발생하였습니다.");

    private final String errorCode;
    private final String message;

    /**
     * @since 1.0
     * @param errorCode 응답 할 에러 코드
     * @param message 에러 메시지
     */
    ErrorCode(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

}
