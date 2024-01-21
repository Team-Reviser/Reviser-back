package com.bombo.reviser.core.todo.exception;

import com.bombo.reviser.common.error.ErrorCode;
import com.bombo.reviser.common.exception.RestApiException;

public class InvalidUpdateReviewTimeException extends RestApiException {

    public InvalidUpdateReviewTimeException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public InvalidUpdateReviewTimeException(ErrorCode errorCode) {
        super(errorCode);
    }
}
