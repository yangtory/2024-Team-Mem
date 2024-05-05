package com.example.step13.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Lombok 라이브러리의 @Data 주해는 기본 생성자, 설정자, 접근자, toString 메서드 등을 추가한다.
 * @AllArgsConstructor 주해는 모든 필드들을 초기화하는 생성자를 추가한다.
 * 이때, 기본 생성자는 @Data 주해로 추가한 기본 생성자는 제거된다.
 * @AllArgsConstructor 주해로 생성자를 추가한 경우, 기본 생성자를 추가하려면
 * @NoArgsConstructor 주해를 사용한다.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {
    private boolean success;
    private String action;
    private String message;

    public ResultDTO(boolean success, String action) {
        this(success, action, null);
    }
}
