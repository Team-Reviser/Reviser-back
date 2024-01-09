package com.bombo.reviser.api.common.response;

import com.bombo.reviser.common.error.ErrorCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @since 1.0
 * @author bombo
 * @param errorCode ErrorCode명 입니다.
 * @param message errorCode에 담긴 메시지입니다.
 * @param fieldErrors BindException 이 발생했을 때 보낼 수 있는 에러입니다.
 * @param serverTime
 * @see com.bombo.reviser.common.error.ErrorCode
 */
@Builder
public record ErrorResponse(
        String errorCode,

        String message,

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<FieldValidationError> fieldErrors,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        LocalDateTime serverTime
) {
    public static ErrorResponse from(final ErrorCode errorCode) {
        return ErrorResponse.builder()
                .errorCode(errorCode.getErrorCode())
                .message(errorCode.getMessage())
                .serverTime(LocalDateTime.now())
                .build();
    }

    public static ErrorResponse of(final ErrorCode errorCode, final BindException e) {
        return ErrorResponse.builder()
                .errorCode(errorCode.getErrorCode())
                .message(errorCode.getMessage())
                .fieldErrors(FieldValidationError.of(e.getFieldErrors()))
                .serverTime(LocalDateTime.now())
                .build();
    }

    /**
     * @since 1.0
     * @author bombo
     * @param field 필드명입니다.
     * @param message 필드명 처리에 담긴 검증 메시지입니다.
     */
    @Builder
    public record FieldValidationError(
            String field,
            String message
    ) {
        private static FieldValidationError from(final FieldError fieldError) {
            return FieldValidationError.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();
        }

        private static List<FieldValidationError> of(final List<FieldError> fieldErrors) {
            return fieldErrors.stream()
                    .map(FieldValidationError::from)
                    .toList();
        }
    }
}
