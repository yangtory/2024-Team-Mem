package com.example.step13.persistence;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
public class JDBCTest {
    static {
        try {
            // JDBC 드라이버 로드
            Class.forName("org.h2.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {
        Connection connection = null;

        try {
            // DBMS에 연결해서 Connection 객체 생성
            connection = DriverManager.getConnection(
                "jdbc:h2:~/member;AUTO_SERVER=TRUE",
                "sa",
                ""
            );

            log.info("connection = {}", connection);
        } catch (Exception e) {
            fail(e.getMessage());
        } finally {
            // Connection 객체 해제
            if (connection != null) try { connection.close(); } catch (Exception ignored) {}
        }
    }
}
