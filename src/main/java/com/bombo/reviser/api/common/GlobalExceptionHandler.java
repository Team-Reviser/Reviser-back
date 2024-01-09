package com.bombo.reviser.api.common;

import com.bombo.reviser.api.common.response.ErrorResponse;
import com.bombo.reviser.common.error.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @since 1.0
 * @author bombo
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 입력 값에서 발생 할 수 있는 예외를 처리합니다.
     * @since 1.0
     * @param exception BindException 예외
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBindException(BindException exception) {
        return ErrorResponse.of(ErrorCode.BAD_REQUEST, exception);
    }

    /**
     * 서버에서 예상치 못한 예외가 발생한 경우를 처리합니다.
     * @since 1.0
     * @param exception Exception 예외
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception exception) {
        log.error("server error occurred", exception);

        return ErrorResponse.from(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
