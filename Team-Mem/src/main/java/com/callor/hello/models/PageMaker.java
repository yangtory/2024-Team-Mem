package com.callor.hello.models;

import lombok.Getter;
import lombok.ToString;

/**
 * 페이지 화면 처리를 담당하는 클래스
 */
@Getter
@ToString
public class PageMaker {
    // 페이지 정보
    private Criteria criteria;

    // 전체 게시물의 개수
    private long total;

    // 마지막 페이지 번호
    private int lastPage;

    // 화면에 보여줄 페이지 번호의 개수
    private int pagesPerViewport;

    // 화면에 보여줄 페이지의 시작 번호
    private int startPage;

    // 화면에 보여줄 페이지의 마지막 번호
    private int endPage;

    // 이전으로 이동하는 링크의 표시 여부
    private boolean prev;

    // 다음으로 이동하는 링크의 표시 여부
    private boolean next;

    // 생성자
    public PageMaker(Criteria criteria, long total, int pagesPerViewport) {
        this.criteria = criteria;
        this.total = total;
        this.pagesPerViewport = pagesPerViewport;

        // (마지막 페이지 번호) = (전체 게시물의 개수) / (페이지당 보여줄 게시물의 개수)
        // → Math 클래스의 ceil 메서드로 연산 결과(실수)의 올림을 구한다.
        lastPage = (int)(Math.ceil((double)total / criteria.getRowsPerPage()));

        // (화면에 보여줄 페이지의 마지막 번호)
        // = ((현재 페이지 번호) / (페이지 번호의 개수)) * (페이지 번호의 개수)
        endPage = (int)(Math.ceil((double)criteria.getPage() / pagesPerViewport))
            * pagesPerViewport;

        // (화면에 보여줄 페이지의 시작 번호)
        // = ((페이지의 마지막 번호) - (페이지 번호의 개수)) + 1
        startPage = (endPage - pagesPerViewport) + 1;

        // 화면에 보여줄 페이지의 시작 번호는 반드시 0보다 커야 한다.
        if (startPage <= 0) startPage = 1;

        // 화면에 보여줄 페이지의 마지막 번호는 마지막 페이지 번호보다 클 수 없다.
        if (endPage > lastPage) endPage = lastPage;

        // 화면에 보여줄 페이지의 시작 번호가 1보다 크면 이전으로 이동하는 링크를 표시
        prev = startPage > 1;

        // 화면에 보여줄 페이지의 마지막 번호가 마지막 페이지 번호보다 작으면
        // 다음으로 이동하는 링크를 표시
        next = endPage < lastPage;
    }

    public PageMaker(Criteria criteria, long total) {
        this(criteria, total, 10);
    }
}
