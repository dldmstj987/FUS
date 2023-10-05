package dao;

import com.example.fus.dao.RippleDAO;
import com.example.fus.dto.RippleDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

@Log4j2
public class RippleDAOTests {
    private RippleDAO rippleDAO;

    @BeforeEach
    public void ready() {rippleDAO = new RippleDAO();}

    //테스트 댓글이 10번 게시글에 입력되는지 확인하는 테스트 코드(완)
    @Test
    public void testInsertRipple() throws Exception{
        RippleDTO rippleDTO = RippleDTO.builder()
                .boardNum(10)
                .name("테스트")
                .memberId("user0010")
                .content("ripple test")
                .ip("1.1.1.1.")
                .build();
        rippleDAO.insertRipple(rippleDTO);

    }

}
