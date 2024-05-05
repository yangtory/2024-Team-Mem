package com.example.step13.service;

import com.example.step13.domain.BoardVO;
import com.example.step13.domain.Criteria;

import java.util.List;

public interface BoardService {
    /**
     * CREATE: 게시물을 등록
     *
     * @param board 등록할 게시물의 정보
     */
    void register(BoardVO board);

    /**
     * READ: 게시물을 조회
     *
     * @param id 조회할 게시물의 id
     * @return 조회한 게시물의 정보
     */
    BoardVO get(Long id);

    /**
     * UPDATE: 게시물을 수정
     *
     * @param board 수정할 게시물의 정보
     * @return 정상적으로 게시물을 수정했는지 여부
     */
    boolean update(BoardVO board);

    /**
     * DELETE: 게시물을 삭제
     *
     * @param id 삭제할 게시물의 id
     * @return 정상적으로 게시물을 삭제했는지 여부
     */
    boolean delete(Long id);

    /**
     * 게시물 목록을 조회
     *
     * @return BoardVO 객체들을 담고 있는 List 객체
     */
    List<BoardVO> getList();

    /**
     * 페이징 정보로 게시물 목록을 조회
     *
     * @param criteria 페이징 정보
     * @return BoardVO 객체들을 담고 있는 List 객체
     */
    List<BoardVO> getList(Criteria criteria);

    /**
     * 전체 게시물의 개수를 조회
     *
     * @param criteria 페이징 정보
     * @return 전체 게시물의 개수
     */
    long getTotal(Criteria criteria);
}
