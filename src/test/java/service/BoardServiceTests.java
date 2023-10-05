package service;

import com.example.fus.dto.BoardDTO;
import com.example.fus.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class BoardServiceTests {
    private BoardService boardService;

    @Test
    public void testGetFileName() throws Exception{
        BoardDTO boardDTO = BoardDTO.builder()
                .title("java")
                .name("test009")
                .content("java")
                .fileName("java.jsp")
                .build();
    }

    @Test
    public void testBoardAdd() throws Exception{
        BoardDTO boardDTO = BoardDTO.builder()
                .title("항저우 아시안 게임")
                .name("강인아 가자")
                .content("이번 항정우 좀 괜찮았음")
                .fileName("이강인.jpg")
                .build();

    }

}
