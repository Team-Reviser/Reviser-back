package com.bombo.reviser.core.todo.exception;

import com.bombo.reviser.common.error.ErrorCode;
import com.bombo.reviser.common.exception.RestApiException;

public class TitleIsNotBlankException extends RestApiException {

    public TitleIsNotBlankException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public TitleIsNotBlankException(ErrorCode errorCode) {
        super(errorCode);
    }
}
