package com.example.step13.service;

import com.example.step13.domain.BoardVO;
import com.example.step13.domain.Criteria;
import com.example.step13.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

// 스프링 MVC의 @Service 주해는 계층 구조상 비즈니스 계층을 담당하는 클래스임을 명시한다.
// 스프링 컨테이너에 의해 빈(bean)으로 생성돼 관리된다.
@Service
@AllArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {
    // 생성자가 하나이면 @Autowired 주해를 생략해도 스프링 컨테이너가 빈(bean)을 주입한다.
    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info("register = {}", board);

        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long id) {
        log.info("get = {}", id);

        return mapper.read(id);
    }

    @Override
    public boolean update(BoardVO board) {
        log.info("update = {}", board);

        // BoardMapper 인터페이스의 update 메서드의 반환 값은 갱신한 레코드의 개수이다.
        // 따라서 정상적으로 수정되면 1이 반환될 것이고, 그럼 BoardServiceImpl 클래스의
        // update 메서드는 true를 반환한다.
        return mapper.update(board) == 1;
    }

    @Override
    public boolean delete(Long id) {
        log.info("delete = {}", id);

        return mapper.delete(id) == 1;
    }

    @Override
    public List<BoardVO> getList() {
        log.info("getList");

        return mapper.getList();
    }

    @Override
    public List<BoardVO> getList(Criteria criteria) {
        log.info("getList");

        // return mapper.getList();
        return mapper.getListWithPaging(criteria);
    }

    @Override
    public long getTotal(Criteria criteria) {
        log.info("getTotal = {}", criteria);

        // 전체 게시물의 개수를 조회해서 반환
        return mapper.getTotal(criteria);
    }
}
