package com.bombo.reviser.domain.todo;

import com.bombo.reviser.core.todo.domain.Description;
import com.bombo.reviser.core.todo.exception.DescriptionIsNotNullException;
import com.bombo.reviser.core.todo.exception.DescriptionOutOfRangeException;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TodoDescriptionTest {

    private static final int DESCRIPTION_MAX_LENGTH = 300;

    @DisplayName("Todo의 Description은 null이면 예외가 발생한다.")
    @Test
    void todoDescriptionWithIsNull() {
        // when & then
        assertThatThrownBy(() -> new Description(null))
                .isInstanceOf(DescriptionIsNotNullException.class)
                .hasMessage("리뷰의 내용은 null 일 수 없습니다.");
    }

    @DisplayName("TODO의 description이 500자를 초과하면 예외가 발생한다.")
    @Test
    void todoDescriptionWithIsOutOfRange() {
        // given
        String input = Strings.repeat("a", DESCRIPTION_MAX_LENGTH + 1);

        // when & then
        assertThatThrownBy(() -> new Description(input))
                .isInstanceOf(DescriptionOutOfRangeException.class)
                .hasMessage("리뷰의 내용은 300자 이하여야 합니다.");
    }

    @DisplayName("TODO의 description이 300자 이내라면 정상적으로 생성된다.")
    @MethodSource("possibleDescription")
    @ParameterizedTest
    void todoDescriptionWithNormal(String input) {
        // when
        Description description = new Description(input);

        // then
        assertThat(description.getDescription()).isEqualTo(input);
    }

    static Stream<String> possibleDescription() {
        String input = Strings.repeat("a", DESCRIPTION_MAX_LENGTH);
        return Stream.of("", "a", input);
    }
}
