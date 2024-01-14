package com.bombo.reviser.core.todo.exception;

import com.bombo.reviser.common.error.ErrorCode;
import com.bombo.reviser.common.exception.RestApiException;

public class TitleOutOfRangeException extends RestApiException {

    public TitleOutOfRangeException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public TitleOutOfRangeException(ErrorCode errorCode) {
        super(errorCode);
    }
}
