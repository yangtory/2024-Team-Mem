package com.example.step13.persistence;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Slf4j
public class DataSourceTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testConnection() {
        // try-with-resource 구문
        // → try 키워드 다음에 나오는 괄호 안에서 생성된 자원은 try 블록이 끝나면 자동으로 해제된다.
        try (Connection connection = dataSource.getConnection()) {
            log.info("connection = {}", connection);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testSqlSessionFactory() {
        try (SqlSession session = sqlSessionFactory.openSession();
             Connection connection = session.getConnection()) {
            log.info("session = {}", session);
            log.info("connection = {}", connection);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
