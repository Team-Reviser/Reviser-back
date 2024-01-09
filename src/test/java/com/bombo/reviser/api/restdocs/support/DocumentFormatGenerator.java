package com.bombo.reviser.api.restdocs.support;

import static org.springframework.restdocs.snippet.Attributes.*;

/**
 * restdocs 에서 사용 될 keyFormat 들의 모음입니다.
 * @since 1.0
 * @author bombo
 */
public final class DocumentFormatGenerator {

    private DocumentFormatGenerator() {

    }

    public static Attribute getDateTimeFormat() {
        return key("format").value("yyyy-MM-dd'T'HH:mm:ss");
    }
}
