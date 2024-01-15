package com.bombo.reviser.core.todo.domain;

import com.bombo.reviser.common.error.ErrorCode;
import com.bombo.reviser.core.todo.exception.DescriptionIsNotNullException;
import com.bombo.reviser.core.todo.exception.TitleIsNotBlankException;
import com.bombo.reviser.core.todo.exception.WriteDateTimeIsNotNullException;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoDetails {

    private static final String TITLE_NULL_EXCEPTION_MSG = "Title은 null 일 수 없습니다.";
    private static final String DESCRIPTION_NULL_EXCEPTION_MSG = "Description은 null 일 수 없습니다.";

    private Title title;
    private Description description;
    private final LocalDateTime writeDateTime;
    private LocalDateTime modifiedDateTime;

    public TodoDetails(Title title, Description description, LocalDateTime writeDateTime) {
        validConstructor(title, description, writeDateTime);
        this.title = title;
        this.description = description;
        this.writeDateTime = writeDateTime;
        this.modifiedDateTime = writeDateTime;
    }

    public void updateDetail(TodoDetails updateDetails, LocalDateTime now) {
        this.title = updateDetails.title;
        this.description = updateDetails.description;
        this.modifiedDateTime = now;
    }

    private void validConstructor(Title title, Description description, LocalDateTime writeDateTime) {
        if (title == null) {
            throw new TitleIsNotBlankException(
                    TITLE_NULL_EXCEPTION_MSG,
                    ErrorCode.TODO_TITLE_IS_NOT_BLANK_EXCEPTION
            );
        }

        if (description == null) {
            throw new DescriptionIsNotNullException(
                    DESCRIPTION_NULL_EXCEPTION_MSG,
                    ErrorCode.TODO_DESCRIPTION_IS_NOT_NULL_EXCEPTION
            );
        }

        if (writeDateTime == null) {
            throw new WriteDateTimeIsNotNullException(ErrorCode.TODO_DETAILS_WRITE_DATETIME_IS_NOT_NULL_EXCEPTION);
        }
    }
}