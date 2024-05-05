package com.callor.hello.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {

    // 현재 페이지
    private int page;

    // 페이지당 보여줄 게시물의 개수
    private int rowsPerPage;

    public Criteria() {
        // 기본 생성자에서는 기본 값을 설정한다.
        this(1, 10);
    }

}
