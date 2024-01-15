package com.bombo.reviser.core.todo.domain;

import com.bombo.reviser.common.error.ErrorCode;
import com.bombo.reviser.core.todo.exception.DescriptionIsNotNullException;
import com.bombo.reviser.core.todo.exception.DescriptionOutOfRangeException;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

/**
 * @since 1.0
 * @author bombo
 * description은 null 일 수 없다.
 * description은 500자 이하여야만 한다.
 */

@Getter
public class Description {

    private static final int DESCRIPTION_MAX_LENGTH = 300;

    private String description;

    public Description(String description) {
        validConstructor(description);
        this.description = description;
    }

    private void validConstructor(String description) {
        if (description == null) {
            throw new DescriptionIsNotNullException(ErrorCode.TODO_DESCRIPTION_IS_NOT_NULL_EXCEPTION);
        }

        if (description.length() > DESCRIPTION_MAX_LENGTH) {
            throw new DescriptionOutOfRangeException(ErrorCode.TODO_DESCRIPTION_IS_OUT_OF_RANGE_EXCEPTION);
        }
    }
}
