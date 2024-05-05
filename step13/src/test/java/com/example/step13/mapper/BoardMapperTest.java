package com.example.step13.mapper;

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
class BoardMapperTest {
    // BoardMapper 객체 주입
    @Autowired
    private BoardMapper mapper;

    @Test
    public void testGetList() {
        List<BoardVO> list = mapper.getList();

        for (BoardVO item : list)
            log.info("item = {}", item);
    }

    @Test
    public void testGetListWithPaging() {
        // 페이지당 게시물 10개씩, 3페이지의 게시물 목록을 조회
        Criteria criteria = new Criteria(3, 10);

        List<BoardVO> list = mapper.getListWithPaging(criteria);

        for (BoardVO item : list)
            log.info("item = {}", item);
    }

    @Test
    public void testInsert() {
        BoardVO board = new BoardVO();

        board.setTitle("[TEST] BoardMapperTest#testInsert");
        board.setContent("[TEST] BoardMapperTest#testInsert");
        board.setWriter("JUnit");

        mapper.insert(board);

        log.info("board = {}", board);
    }

    @Test
    public void testInsertSelectKey() {
        BoardVO board = new BoardVO();

        board.setTitle("[TEST] BoardMapperTest#testInsertSelectKey");
        board.setContent("[TEST] BoardMapperTest#testInsertSelectKey");
        board.setWriter("JUnit");

        mapper.insertSelectKey(board);

        log.info("board = {}", board);
    }

    @Test
    public void testRead() {
        BoardVO board = mapper.read(95L);

        log.info("board = {}", board);
    }

    @Test
    public void testUpdate() {
        BoardVO board = new BoardVO();

        board.setId(98L);
        board.setTitle("[TEST] BoardMapperTest#testUpdate");
        board.setContent("[TEST] BoardMapperTest#testUpdate");
        board.setWriter("JUnit");

        log.info("Updated record = {}", mapper.update(board));
    }

    @Test
    public void testDelete() {
        log.info("Deleted record = {}", mapper.delete(13L));
    }
}
