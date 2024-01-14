package com.bombo.reviser.core.todo.domain;

import com.bombo.reviser.common.error.ErrorCode;
import com.bombo.reviser.core.todo.exception.TitleIsNotBlankException;
import com.bombo.reviser.core.todo.exception.TitleOutOfRangeException;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Getter
public class Title {

    private static final int MAX_TITLE_LENGTH = 50;

    private String title;

    public Title(String title) {
        validConstructor(title);
        this.title = title;
    }

    private void validConstructor(String title) {
        if (Strings.isBlank(title)) {
            throw new TitleIsNotBlankException(ErrorCode.TODO_TITLE_IS_NOT_BLANK_EXCEPTION);
        }

        if (title.length() > MAX_TITLE_LENGTH) {
            throw new TitleOutOfRangeException(ErrorCode.TODO_TITLE_IS_OUT_OF_RANGE_EXCEPTION);
        }
    }
}
