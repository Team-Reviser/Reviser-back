package com.bombo.reviser.provider.tododetails;

import com.bombo.reviser.core.todo.domain.Description;
import com.bombo.reviser.core.todo.domain.Title;
import com.bombo.reviser.core.todo.domain.TodoDetails;

import java.time.LocalDateTime;

public final class TodoDetailsProvider {

    private TodoDetailsProvider() {

    }

    public static TodoDetails create(LocalDateTime writeDateTime) {
        Title title = TitleProvider.create();
        Description description = DescriptionProvider.create();
        return new TodoDetails(title, description, writeDateTime);
    }
}
