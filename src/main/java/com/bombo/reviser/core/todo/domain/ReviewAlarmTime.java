package com.bombo.reviser.core.todo.domain;

import com.bombo.reviser.common.error.ErrorCode;
import com.bombo.reviser.core.todo.exception.InvalidUpdateReviewTimeException;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewAlarmTime {

    private LocalDateTime reviewDateTime;

    public ReviewAlarmTime(LocalDateTime reviewDateTime) {
        this.reviewDateTime = reviewDateTime;
    }

    public void update(LocalDateTime updateTime, LocalDateTime now) {
        if (updateTime.isBefore(now)) {
            throw new InvalidUpdateReviewTimeException(ErrorCode.INVALID_UPDATE_REVIEW_TIME_EXCEPTION);
        }

        reviewDateTime = updateTime;
    }
}
