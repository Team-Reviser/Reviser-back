package com.bombo.reviser.domain.todo;

import com.bombo.reviser.core.todo.domain.Description;
import com.bombo.reviser.core.todo.domain.Title;
import com.bombo.reviser.core.todo.domain.TodoDetails;
import com.bombo.reviser.core.todo.exception.DescriptionIsNotNullException;
import com.bombo.reviser.core.todo.exception.TitleIsNotBlankException;
import com.bombo.reviser.core.todo.exception.WriteDateTimeIsNotNullException;
import com.bombo.reviser.provider.tododetails.DescriptionProvider;
import com.bombo.reviser.provider.tododetails.TitleProvider;
import com.bombo.reviser.provider.tododetails.TodoDetailsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TodoDetailsTest {

    @DisplayName("TODO Details의 생성 날짜가 없다면 예외가 발생한다.")
    @Test
    void createTodoDetailWithWriteDateTimeIsNull() {
        // given
        Title title = TitleProvider.create();
        Description description = DescriptionProvider.create();

        // when & then
        assertThatThrownBy(() -> new TodoDetails(title, description, null))
                .isInstanceOf(WriteDateTimeIsNotNullException.class)
                .hasMessage("할 일의 생성 날짜는 null 일 수 없습니다.");
    }

    @DisplayName("TODO Details의 Title이 null 이라면 예외가 발생한다.")
    @Test
    void createTodoDetailWithTitleIsNull() {
        // given
        Description description = DescriptionProvider.create();

        // when & then
        assertThatThrownBy(() -> new TodoDetails(null, description, LocalDateTime.now()))
                .isInstanceOf(TitleIsNotBlankException.class)
                .hasMessage("Title은 null 일 수 없습니다.");
    }

    @DisplayName("TODO Details의 Description null 이라면 예외가 발생한다.")
    @Test
    void createTodoDetailWithDescriptionIsNull() {
        // given
        Title title = TitleProvider.create();

        // when & then
        assertThatThrownBy(() -> new TodoDetails(title, null, LocalDateTime.now()))
                .isInstanceOf(DescriptionIsNotNullException.class)
                .hasMessage("Description은 null 일 수 없습니다.");
    }

    @DisplayName("TODO Details를 생성 할 수 있다.")
    @Test
    void createTodoDetails() {
        // given
        Title title = TitleProvider.create();
        Description description = DescriptionProvider.create();
        LocalDateTime writeDateTime = LocalDateTime.now();

        // when
        TodoDetails todoDetails = new TodoDetails(title, description, writeDateTime);

        // then
        assertThat(todoDetails.getTitle()).isEqualTo(title);
        assertThat(todoDetails.getDescription()).isEqualTo(description);
        assertThat(todoDetails.getWriteDateTime()).isEqualTo(writeDateTime);
        assertThat(todoDetails.getModifiedDateTime()).isEqualTo(writeDateTime);
    }

    @DisplayName("TodoDetails의 제목과 내용을 수정 할 수 있다.")
    @Test
    void updateTodoDetails() {
        // given
        LocalDateTime writeDateTime = LocalDateTime.now();
        TodoDetails todoDetails = TodoDetailsProvider.create(writeDateTime);

        TodoDetails updateDetails = new TodoDetails(todoDetails.getTitle(), todoDetails.getDescription(),
                todoDetails.getWriteDateTime());

        LocalDateTime updateDateTime = LocalDateTime.now();

        // when
        todoDetails.updateDetail(updateDetails, updateDateTime);

        // then
        assertThat(todoDetails.getTitle()).isEqualTo(updateDetails.getTitle());
        assertThat(todoDetails.getDescription()).isEqualTo(updateDetails.getDescription());
        assertThat(todoDetails.getModifiedDateTime()).isEqualTo(updateDateTime);
    }
}
