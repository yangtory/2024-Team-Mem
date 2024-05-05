package com.example.step13.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.ModelMap;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest             // 테스트에서 스프링 컨테이너를 사용
@AutoConfigureMockMvc       // MockMvc 객체를 생성
@Slf4j
class BoardControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testList() throws Exception {
        // MockMvc 객체의 perform 메서드로 요청을 수행
        mockMvc.perform(get("/board/list"))
            .andExpect(status().isOk())         // 응답 상태 코드 검증
            .andDo(print());                    // 요청과 응답 결과를 출력
    }

    @Test
    public void testList2() throws Exception {
        // GET 방식의 요청 생성
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/board/list");

        // 요청을 수행하고, 응답 결과에서 ModelMap 객체를 생성
        /*
        ModelMap modelMap = mockMvc.perform(builder)
            .andReturn()
            .getModelAndView().getModelMap();
        */

        ModelMap modelMap = Objects.requireNonNull(mockMvc.perform(builder)
            .andReturn()
            .getModelAndView()).getModelMap();

        log.info("modelMap = {}", modelMap);
    }

    @Test
    public void testListWithPaging() throws Exception {
        // GET 방식의 요청 생성
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/board/list")
            .param("page", "3")
            .param("rowsPerPage", "10");

        // 요청을 수행하고, 요청과 응답 결과 확인
        mockMvc.perform(builder)                    // 요청을 수행
            .andExpect(status().isOk())             // 응답 상태 코드(200) 검증
            .andDo(print());                        // 요청과 응답 결과를 출력
    }

    @Test
    public void testWrite() throws Exception {
        // POST 방식의 요청 생성
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/board/write")
            .param("title", "[TEST] BoardControllerTest#testWrite")
            .param("content", "[TEST] BoardControllerTest#testWrite")
            .param("writer", "JUnit");

        // 요청을 수행하고, 요청과 응답 결과 확인
        mockMvc.perform(builder)                        // 요청을 수행
            .andExpect(status().is3xxRedirection())     // 응답 상태 코드(302) 검증
            .andDo(print());                            // 요청과 응답 결과를 출력
    }

    @Test
    public void testRead() throws Exception {
        // 요청을 수행하고, 요청과 응답 결과 확인
        mockMvc.perform(get("/board/read").param("id", "99"))
            .andExpect(status().isOk())         // 응답 상태 코드(200) 검증
            .andDo(print());                    // 요청과 응답 결과를 출력
    }

    @Test
    public void testUpdate() throws Exception {
        // POST 방식의 요청 생성
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/board/update")
            .param("id", "96")
            .param("title", "[TEST] BoardControllerTest#testUpdate")
            .param("content", "[TEST] BoardControllerTest#testUpdate")
            .param("writer", "JUnit");

        // 요청을 수행하고, 요청과 응답 결과 확인
        mockMvc.perform(builder)                        // 요청을 수행
            .andExpect(status().is3xxRedirection())     // 응답 상태 코드(302) 검증
            .andDo(print());                            // 요청과 응답 결과를 출력
    }

    @Test
    public void testDelete() throws Exception {
        // 요청을 수행하고, 요청과 응답 결과 확인
        mockMvc.perform(get("/board/delete").param("id", "91"))
            .andExpect(status().is3xxRedirection())     // 응답 상태 코드(302) 검증
            .andDo(print());                            // 요청과 응답 결과를 출력
    }
}
