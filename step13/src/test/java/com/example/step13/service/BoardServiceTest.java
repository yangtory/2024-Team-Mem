package com.example.step13.service;

import com.example.step13.domain.BoardVO;
import com.example.step13.domain.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    @Test
    public void testExist() {
        // BoardService 객체가 제대로 생성돼서 주입됐는지 검증
        assertNotNull(boardService);

        log.info("boardService = {}", boardService);
    }

    @Test
    public void testRegister() {
        BoardVO board = new BoardVO();

        board.setTitle("[TEST] BoardServiceTest#testRegister");
        board.setContent("[TEST] BoardServiceTest#testRegister");
        board.setWriter("JUnit");

        // 새로운 게시물 등록
        boardService.register(board);

        // 등록한 게시물의 id 확인
        log.info("registered id = {}", board.getId());
    }

    @Test
    public void testGet() {
        // 게시물 조회
        log.info("boardService.get = {}", boardService.get(33L));
    }

    @Test
    public void testUpdate() {
        // 수정할 게시물을 조회
        BoardVO board = boardService.get(100L);

        // 게시물이 없으면 테스트 종료
        if (board == null) return;

        // 게시물의 제목을 수정
        board.setTitle("[TEST] BoardServiceTest#testUpdate");

        // 게시물을 수정
        log.info("boardService.update = {}", boardService.update(board));
    }

    @Test
    public void testDelete() {
        // 게시물 삭제
        log.info("boardService.delete = {}", boardService.delete(93L));
    }

    @Test
    public void testGetList() {
        // 게시물 목록 조회
        List<BoardVO> list = boardService.getList();

        for (BoardVO item : list)
            log.info("item = {}", item);
    }

    @Test
    public void testGetListWithPaging() {
        // 게시물 목록 조회
        List<BoardVO> list = boardService.getList(new Criteria(3, 10));

        for (BoardVO item : list)
            log.info("item = {}", item);
    }
}
