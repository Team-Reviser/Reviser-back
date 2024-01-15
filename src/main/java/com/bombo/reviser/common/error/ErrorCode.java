package com.bombo.reviser.common.error;

import lombok.Getter;

/**
 * @since 1.0
 * @author bombo
 * @see com.bombo.reviser.api.common.GlobalExceptionHandler
 * @see com.bombo.reviser.api.common.response.ErrorResponse
 */
@Getter
public enum ErrorCode {
    // SERVER
    INTERNAL_SERVER_ERROR("S_001", "서버에서 에러가 발생하였습니다."),

    // BAD_REQUEST
    BAD_REQUEST("C_001", "입력 값에서 오류가 발생하였습니다."),

    //== BUSINESS ==//

    // TODO

    // TODO DETAILS
    TODO_TITLE_IS_NOT_BLANK_EXCEPTION("BTD_001", "할 일의 타이틀은 null 이거나 공백 일 수 없습니다."),
    TODO_TITLE_IS_OUT_OF_RANGE_EXCEPTION("BTD_002", "할 일의 타이틀은 50자 이하여야 합니다."),
    TODO_DESCRIPTION_IS_NOT_NULL_EXCEPTION("BTD_003", "할 일의 내용은 null 일 수 없습니다."),
    TODO_DESCRIPTION_IS_OUT_OF_RANGE_EXCEPTION("BTD_004", "할 일의 내용은 300자 이하여야 합니다."),
    TODO_DETAILS_WRITE_DATETIME_IS_NOT_NULL_EXCEPTION("BTD_005", "할 일의 생성 날짜는 null 일 수 없습니다."),

    // REVIEW
    EXCEED_REVIEW_COUNT_EXCEPTION("BR_001", "복습 횟수를 초과 할 수 없습니다."),
    INVALID_TRY_REVIEW_EXCEPTION("BR_002", "복습 날짜를 업데이트 할 수 없는 상태입니다."),
    INVALID_CHANGE_REVIEW_STRATEGY_EXCEPTION("BR_003", "리뷰 전략을 변경 할 수 없는 상태입니다."),

    // ALARM
    INVALID_UPDATE_REVIEW_TIME_EXCEPTION("BA_001", "리뷰 알람 시간이 현재 시간 이전 일 수 없습니다.");


    private final String errorCode;
    private final String message;

    /**
     * @since 1.0
     * @param errorCode 응답 할 에러 코드
     * @param message 에러 메시지
     */
    ErrorCode(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

}
