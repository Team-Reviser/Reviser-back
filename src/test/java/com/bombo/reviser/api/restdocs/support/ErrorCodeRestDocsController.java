package com.bombo.reviser.api.restdocs.support;

import com.bombo.reviser.api.common.response.ErrorResponse;
import com.bombo.reviser.common.error.ErrorCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * ErrorCode를 restdocs에 반환하기 위한 테스트 컨트롤러
 * @since 1.0
 * @author bombo
 * @see <a href="https://0soo.tistory.com/210">https://0soo.tistory.com/210</a>
 */
@RestController
public class ErrorCodeRestDocsController {

    @GetMapping(value = "/error-code", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, ErrorResponse> errorCodes() {
        Map<String, ErrorResponse> map = new HashMap<>();

        for (ErrorCode errorCode : ErrorCode.values()) {
            map.put(errorCode.name(), ErrorResponse.from(errorCode));
        }

        return map;
    }
}
