package com.bombo.reviser.core.todo.domain;

import com.bombo.reviser.core.todo.exception.InvalidUpdateReviewTimeException;
import com.bombo.reviser.provider.reviewAlarm.ReviewAlarmProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ReviewAlarmTimeTest {

    @DisplayName("리뷰의 알람을 만들어 낼 수 있다.")
    @Test
    void createReviewAlarm() {
        // given
        LocalDateTime now = LocalDateTime.now();

        // when
        ReviewAlarmTime reviewAlarmTime = new ReviewAlarmTime(now);

        // then
        assertThat(reviewAlarmTime.getReviewDateTime()).isEqualTo(now);
    }

    @DisplayName("리뷰의 알람 시간을 업데이트 할 때 현재 시간보다 이전이면 예외가 발생한다.")
    @Test
    void updateReviewAlarmWithPastUpdate() {
        // given
        ReviewAlarmTime reviewAlarmTime = ReviewAlarmProvider.create();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime updateTime = now.minusMinutes(1);

        // when & then
        Assertions.assertThatThrownBy(() -> reviewAlarmTime.update(updateTime, now))
                .isInstanceOf(InvalidUpdateReviewTimeException.class)
                .hasMessage("리뷰 알람 시간이 현재 시간 이전 일 수 없습니다.");
    }

    @DisplayName("리뷰의 알람은 업데이트 될 수 있다.")
    @Test
    void updateReviewAlarm() {
        // given
        ReviewAlarmTime reviewAlarmTime = ReviewAlarmProvider.create();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime updateTime = now.plusMinutes(1);

        // when
        reviewAlarmTime.update(updateTime, now);

        // then
        assertThat(reviewAlarmTime.getReviewDateTime()).isEqualTo(updateTime);
    }
}