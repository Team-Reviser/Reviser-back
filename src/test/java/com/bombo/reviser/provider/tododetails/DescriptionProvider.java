package com.bombo.reviser.provider.tododetails;

import com.bombo.reviser.core.todo.domain.Description;

public final class DescriptionProvider {

    private DescriptionProvider() {

    }

    public static Description create() {
        return new Description("Todo의 내용");
    }
}
