package com.bombo.reviser.provider.tododetails;

import com.bombo.reviser.core.todo.domain.Title;

public final class TitleProvider {

    private TitleProvider() {

    }

    public static Title create() {
        return new Title("Todo의 제목");
    }
}
