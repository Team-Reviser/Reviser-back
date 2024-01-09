package com.bombo.reviser.api.restdocs.support;

import org.springframework.http.MediaType;
import org.springframework.restdocs.operation.Operation;
import org.springframework.restdocs.payload.AbstractFieldsSnippet;
import org.springframework.restdocs.payload.FieldDescriptor;

import java.io.IOException;
import java.util.List;

/**
 * Enum을 반환 할 수 있도록 만들어진 커스텀 Snippet입니다.
 * @since 1.0
 * @author bombo
 */
public class CustomResponseFieldSnippet extends AbstractFieldsSnippet {

    public CustomResponseFieldSnippet(String type, List<FieldDescriptor> descriptors,
                                      boolean ignoreUndocumentedFields) {
        super(type, descriptors, null, ignoreUndocumentedFields);
    }

    @Override
    protected MediaType getContentType(Operation operation) {
        return operation.getResponse().getHeaders().getContentType();
    }

    @Override
    protected byte[] getContent(Operation operation) throws IOException {
        return operation.getResponse().getContent();
    }
}
