package com.bombo.reviser.api.restdocs;

import com.bombo.reviser.api.restdocs.support.CustomResponseFieldSnippet;
import com.bombo.reviser.api.restdocs.support.ErrorCodeRestDocsController;
import com.bombo.reviser.api.restdocs.support.RestDocsSupport;
import com.bombo.reviser.common.error.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class ErrorCodeRestDocsControllerTest extends RestDocsSupport {

    private static final String ERROR_CODE_SNIPPET = "errorcode-response";

    @Override
    protected Object setController() {
        return new ErrorCodeRestDocsController();
    }

    @DisplayName("REST-DOCS에 ErrorCode 종류를 반환한다.")
    @Test
    void errorCodes() throws Exception {
        // when & then
        mockMvc.perform(get("/error-code")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(document(ERROR_CODE_SNIPPET,
                        customResponseFields(ERROR_CODE_SNIPPET, fieldDescriptors()))
                );
    }

    private List<FieldDescriptor> fieldDescriptors() {
        List<FieldDescriptor> fieldDescriptors = new ArrayList<>();

        for (ErrorCode errorCode : ErrorCode.values()) {
            FieldDescriptor attributes =
                    fieldWithPath(errorCode.name()).type(JsonFieldType.OBJECT)
                    .attributes(
                            key("errorCode").value(errorCode.getErrorCode()),
                            key("message").value(errorCode.getMessage())
                    );

            fieldDescriptors.add(attributes);
        }

        return fieldDescriptors;
    }

    private CustomResponseFieldSnippet customResponseFields(
            String snippetPrefix,
            List<FieldDescriptor> fieldDescriptors) {
        return new CustomResponseFieldSnippet(snippetPrefix, fieldDescriptors, true);
    }
}
