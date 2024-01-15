package com.bombo.reviser.core.todo.exception;

import com.bombo.reviser.common.error.ErrorCode;
import com.bombo.reviser.common.exception.RestApiException;

public class DescriptionIsNotNullException extends RestApiException {

    public DescriptionIsNotNullException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public DescriptionIsNotNullException(ErrorCode errorCode) {
        super(errorCode);
    }
}
