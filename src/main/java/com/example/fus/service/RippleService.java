package com.example.fus.service;


import com.example.fus.dao.RippleDAO;
import com.example.fus.dto.RippleDTO;
import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Log4j2
public class RippleService {
    private final RippleDAO rippleDAO;

    public RippleService(){rippleDAO = new RippleDAO();}

    //댓글 추가 메서드
    public boolean addRipple(HttpServletRequest request) throws Exception{
        log.info("addRipple()...");

        RippleDTO rippleDTO = RippleDTO.builder()
                .boardNum(Integer.valueOf(request.getParameter("num")))
                .memberId((String) request.getSession().getAttribute("sessoionMemberId"))
                .name(request.getParameter("name"))
                .content(request.getParameter("content"))
                .ip(request.getRemoteAddr())
                .build();
        return rippleDAO.insertRipple(rippleDTO);

    }

    //댓글 리스트 블러오기
    public List<RippleDTO> getRipples(HttpServletRequest request) throws Exception{
        RippleDAO rippleDAO = null;
        int num = Integer.parseInt(request.getParameter("num"));
        List<RippleDTO> rippleDTOS = rippleDAO.selectRipples(num);

        //댓글 중 로그인한 사용자가 작성한 댓글이면 isLogin 값을 true로 변경
        for (RippleDTO rippleDTO : rippleDTOS){
            log.info(rippleDTO.getMemberId());
            log.info(request.getSession().getAttribute("sessionMemberId"));

            if(rippleDTO.getMemberId().equals(request.getSession().getAttribute("sessionMemberId"))){
                //댓글 사용자와 로그인한 사용자가 같은 경우
                rippleDTO.setLogin(true);
            }
        }
        return rippleDTOS;
    }

    public boolean removeRipple(HttpServletRequest request) throws Exception{
        RippleDAO rippleDAO = null;
        int rippleId = Integer.parseInt(request.getParameter("rippleId"));
        return rippleDAO.deleteRipple(rippleId);
    }
}