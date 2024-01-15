package com.bombo.reviser.core.todo.exception;

import com.bombo.reviser.common.error.ErrorCode;
import com.bombo.reviser.common.exception.RestApiException;

public class WriteDateTimeIsNotNullException extends RestApiException {

    public WriteDateTimeIsNotNullException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public WriteDateTimeIsNotNullException(ErrorCode errorCode) {
        super(errorCode);
    }
}
