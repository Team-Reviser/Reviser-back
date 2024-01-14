package com.bombo.reviser.domain.todo;

import com.bombo.reviser.core.todo.domain.Title;
import com.bombo.reviser.core.todo.exception.TitleIsNotBlankException;
import com.bombo.reviser.core.todo.exception.TitleOutOfRangeException;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TodoTitleTest {

    private final static int MAX_TITLE_LENGTH = 50;

    @DisplayName("Todo Title은 공백이거나 null 이면 생성 시 예외가 발생한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void constructTitleWithIsBlank(String input) {
        // given

        // when & then
        assertThatThrownBy(() -> {
            new Title(input);
        }).isInstanceOf(TitleIsNotBlankException.class)
                .hasMessage("리뷰의 타이틀은 null 이거나 공백 일 수 없습니다.");
    }

    @DisplayName("Todo의 title이 50자를 초과하면 예외가 발생한다.")
    @Test
    void constructTitleWithOutOfRangeTitleLength() {
        // given
        String input = Strings.repeat("a", MAX_TITLE_LENGTH + 1);

        // when & then
        assertThatThrownBy(() -> {
            new Title(input);
        }).isInstanceOf(TitleOutOfRangeException.class)
                .hasMessage("리뷰의 타이틀은 50자 이하여야 합니다.");
    }

    @DisplayName("제목의 길이가 1자에서 50자 사이라면 정상적으로 생성된다.")
    @MethodSource("possibleStringRange")
    @ParameterizedTest
    void constructTitleWithPossibleRange(String input) {
        // when
        Title title = new Title(input);

        // then
        assertThat(title.getTitle()).isEqualTo(input);
    }

    static private Stream<String> possibleStringRange() {
        String input2 = Strings.repeat("a", MAX_TITLE_LENGTH);
        return Stream.of("a", input2);
    }
}
