package com.example.step13.controller;

import com.example.step13.domain.BoardVO;
import com.example.step13.domain.Criteria;
import com.example.step13.domain.PageMaker;
import com.example.step13.domain.ResultDTO;
import com.example.step13.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/")
@Slf4j
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    /*
    // "/board/"와 "/board/list"로 들어온 GET 방식의 요청에 매핑
    // @RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
    // @GetMapping(value = { "", "/list" })
    @GetMapping({ "", "/list" })
    public String list(Model model) {
        log.info("list");

        // 게시물 목록을 Model 객체에 추가
        model.addAttribute("list", boardService.getList());

        // /WEB-INF/views/board/list.jsp 파일을 뷰로 지정
        return "/board/list";
    }
    */

    // "/board/"와 "/board/list"로 들어온 GET 방식의 요청에 매핑
    // @RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
    // @GetMapping(value = { "", "/list" })
    @GetMapping({ "", "/list" })
    public String list(Criteria criteria, Model model) {
        log.info("list");

        // 전체 게시물의 개수를 조회
        long total = boardService.getTotal(criteria);

        log.info("total = {}", total);

        // 게시물 목록을 Model 객체에 추가
        model.addAttribute("list", boardService.getList(criteria));

        // 페이징 정보를 Model 객체에 추가해서 뷰(View)에 전달
        model.addAttribute("pageMaker", new PageMaker(criteria, total));

        // /WEB-INF/views/board/list.jsp 파일을 뷰로 지정
        return "/board/list";
    }

    // "/board/write"로 들어온 POST 방식의 요청에 매핑
    // @RequestMapping(value = "/write", method = RequestMethod.POST)
    @PostMapping("/write")
    public String write(BoardVO board, RedirectAttributes redirectAttributes) {
        log.info("write = {}", board);

        // 요청 매개 변수로 전달된 게시물 정보를 등록
        boardService.register(board);

        // URL 재지정할 때 전달할 값을 설정
        redirectAttributes.addAttribute("id", board.getId());
        redirectAttributes.addFlashAttribute("result", new ResultDTO(true, "write"));

        // URL 재지정(redirect)
        return "redirect:/board/read";
    }

    // "/board/write"로 들어온 GET 방식의 요청에 매핑
    @GetMapping("/write")
    public void write() { }

    // "/board/read"로 들어온 GET 방식의 요청에 매핑
    /*
    @GetMapping("/read")
    public void read(@RequestParam Long id, Model model) {
        log.info("read = {}", id);

        // 게시물을 조회해서 Model 객체에 추가
        model.addAttribute("board", boardService.get(id));
    }
    */
    /*
    @GetMapping("/read")
    public BoardVO read(@RequestParam Long id) {
        log.info("read = {}", id);

        // 게시물을 조회해서 반환
        // → 컨트롤러 메서드에서 객체를 반환하면, 그 객체를 Model 객체에 추가한다.
        //   이때, Model 객체에 추가되는 속성의 이름은 반환하는 객체의 클래스 식별자에서
        //   첫 글자를 소문자로 바꾼 이름이 된다. 즉, "boardVO"라는 속성으로 추가된다.
        return boardService.get(id);
    }
    */
    @GetMapping("/read")
    public BoardVO read(@RequestParam Long id, @ModelAttribute Criteria criteria) {
        log.info("read = {}", id);

        // 게시물을 조회해서 반환
        // → 컨트롤러 메서드에서 객체를 반환하면, 그 객체를 Model 객체에 추가한다.
        //   이때, Model 객체에 추가되는 속성의 이름은 반환하는 객체의 클래스 식별자에서
        //   첫 글자를 소문자로 바꾼 이름이 된다. 즉, "boardVO"라는 속성으로 추가된다.
        return boardService.get(id);
    }

    // "/board/update"로 들어온 POST 방식의 요청에 매핑
    /*
    @PostMapping("/update")
    public String update(BoardVO board, RedirectAttributes redirectAttributes) {
        log.info("update = {}", board);

        // 게시물을 수정하고, 세션(session)에 성공 여부를 저장
        if (boardService.update(board))
            redirectAttributes.addFlashAttribute("result", new ResultDTO(true, "update"));

        // "/board/read"로 재지정하기 위해 요청 매개 변수를 설정
        redirectAttributes.addAttribute("id", board.getId());

        // "/board/read"로 재지정
        return "redirect:/board/read";
    }
    */
    @PostMapping("/update")
    public String update(BoardVO board, Criteria criteria, RedirectAttributes redirectAttributes) {
        log.info("update = {}", board);

        // 게시물을 수정하고, 세션(session)에 성공 여부를 저장
        if (boardService.update(board))
            redirectAttributes.addFlashAttribute("result", new ResultDTO(true, "update"));

        // "/board/read"로 재지정하기 위해 요청 매개 변수를 설정
        redirectAttributes.addAttribute("id", board.getId());
        redirectAttributes.addAttribute("page", criteria.getPage());

        // "/board/read"로 재지정
        return "redirect:/board/read";
    }

    // "/board/update"로 들어온 GET 방식의 요청에 매핑
    /*
    @GetMapping("/update")
    public String update(@RequestParam Long id, Model model) {
        log.info("update = {}", id);

        // 게시물을 조회해서 Model 객체에 추가
        model.addAttribute("board", boardService.get(id));

        // /WEB-INF/views/board/write.jsp 파일을 뷰로 지정
        return "/board/write";
    }
    */
    @GetMapping("/update")
    public String update(@RequestParam Long id, Criteria criteria, Model model) {
        log.info("update = {}", id);

        // 게시물을 조회해서 Model 객체에 추가
        model.addAttribute("board", boardService.get(id));
        model.addAttribute("criteria", criteria);

        // /WEB-INF/views/board/write.jsp 파일을 뷰로 지정
        return "/board/write";
    }

    // "/board/delete"로 들어온 GET 방식의 요청에 매핑
    /*
    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        log.info("delete = {}", id);

        // 게시물을 삭제하고, 세션(session)에 성공 여부를 저장
        if (boardService.delete(id))
            redirectAttributes.addFlashAttribute("result", new ResultDTO(true, "delete"));

        // "/board/list"로 재지정
        return "redirect:/board/list";
    }
    */
    @GetMapping("/delete")
    public String delete(@RequestParam Long id, Criteria criteria, RedirectAttributes redirectAttributes) {
        log.info("delete = {}", id);

        // 게시물을 삭제하고, 세션(session)에 성공 여부를 저장
        if (boardService.delete(id))
            redirectAttributes.addFlashAttribute("result", new ResultDTO(true, "delete"));

        redirectAttributes.addAttribute("page", criteria.getPage());

        // "/board/list"로 재지정
        return "redirect:/board/list";
    }
}
