package com.bombo.reviser.provider.reviewAlarm;

import com.bombo.reviser.core.todo.domain.ReviewAlarmTime;

import java.time.LocalDateTime;

public final class ReviewAlarmProvider {

    private ReviewAlarmProvider() {

    }

    public static ReviewAlarmTime create() {
        return new ReviewAlarmTime(LocalDateTime.now());
    }
}
