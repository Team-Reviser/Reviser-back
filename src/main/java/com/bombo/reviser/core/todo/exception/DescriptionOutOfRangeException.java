package com.bombo.reviser.core.todo.exception;

import com.bombo.reviser.common.error.ErrorCode;
import com.bombo.reviser.common.exception.RestApiException;

public class DescriptionOutOfRangeException extends RestApiException {

    public DescriptionOutOfRangeException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public DescriptionOutOfRangeException(ErrorCode errorCode) {
        super(errorCode);
    }
}
