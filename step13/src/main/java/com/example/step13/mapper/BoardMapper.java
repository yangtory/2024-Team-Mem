package com.example.step13.mapper;

import com.example.step13.domain.BoardVO;
import com.example.step13.domain.Criteria;
import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    // board 테이블에서 모든 레코드를 조회
    // @Select("SELECT * FROM board WHERE id > 0")
    List<BoardVO> getList();

    // 페이징 정보를 담고 있는 Criteria 객체를 전달 받아, 해당 페이지의 게시물 목록을 조회
    List<BoardVO> getListWithPaging(Criteria criteria);

    // CREATE: 새로운 게시물을 등록(추가한 게시물의 id를 알 필요가 없는 경우)
    void insert(BoardVO board);

    // CREATE: 새로운 게시물을 등록(추가한 게시물의 id를 알아야 하는 경우)
    void insertSelectKey(BoardVO board);

    // READ: PK인 id 컬럼으로 특정 게시물을 조회
    BoardVO read(Long id);

    // UPDATE: PK인 id 컬럼으로 특정 게시물을 갱신
    // → 반환 값 자료형을 int로 지정하면, 갱신한 레코드의 개수를 반환한다.
    int update(BoardVO board);

    // DELETE: PK인 id 컬럼으로 특정 게시물을 삭제
    // → 반환 값 자료형을 int로 지정하면, 삭제한 레코드의 개수를 반환한다.
    int delete(Long id);

    // 전체 게시물의 개수를 조회
    long getTotal(Criteria criteria);
}
