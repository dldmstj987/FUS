package com.example.fus.service;

import com.example.fus.dao.BoardDAO;
import com.example.fus.dto.BoardDTO;
import com.example.fus.dto.UserDTO;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.util.List;

@Log4j2
public class BoardService {
    private final BoardDAO boardDAO;

    public BoardService(){boardDAO = new BoardDAO();}

    private String getFileName(Part part){
        /*part 객체로 전달된 이미지 파일로부터 파일 이름을 추출하기 위한 메서드*/
        String fileName = null;

        //파일 이름이 들어있는 헤더 영역을 가지고 옴
        String header = part.getHeader("content-disposition");
        log.info("File header : " + header );

        //파일 이름이 들어있는 속성 부분의 시작위치를 가져와 쌍따옴표 사이의 값 부분만 가지고 옴
        int start = header.indexOf("filename=");
        fileName = header.substring(start + 10, header.length() -1);
        log.info("파일명 : " + fileName);
        return fileName;
    }

    // 게시글 추가
    public void addBoard(HttpServletRequest request){
        BoardDTO boardDTO = new BoardDTO();
        try{
            Part part = request.getPart("file");
            String fileName = this.getFileName(part);
            if(fileName != null && !fileName.isEmpty()){
                part.write(fileName);
            }
            BeanUtils.populate(boardDTO,request.getParameterMap());
            boardDTO.setFileName(fileName);
            boardDAO.insertBoard(boardDTO);
        } catch (Exception e){
            log.info(e.getMessage());
            log.info("게시물 추가 과정에서 문제 발생");
            request.setAttribute("error", "게시물이 정상적으로 등록되지 않았습니다.");
        }
    }

    /*게시글 삭제 메서드*/
    public void removeBoard(HttpServletRequest request){
        int boardNum = Integer.parseInt(request.getParameter("boardNum"));
        try{
            boardDAO.deleteBoard(boardNum);
        } catch (Exception e){
            log.info(e.getMessage());
            log.info("게시물 삭제하는 과정에서 문제발생!!!");
            request.setAttribute("error", "게시물을 정상적으로 삭제하지 못했습니다.");
        }
    }


    /*게시글 목록을 가져오는 메서드*/
    public List<BoardDTO> listBoardDTO() {
        List<BoardDTO> boardDTOList = null;
        try{
            boardDTOList = boardDAO.selectAll();
        } catch (Exception e){
            log.info(e.getMessage());
            log.info("게시글 목록 생성 중 문제 발생");
        }
        return boardDTOList;
    }

    // 게시글 상세 정보
    public BoardDTO getBoard(HttpServletRequest req){
        /*특정 게시물을 클릭했을 때 호출하기 위한 요청을 처리하는 메서드*/
        int boardNum = Integer.parseInt(req.getParameter("boardNum"));
        BoardDTO boardDTO = null;
        try{
            boardDTO = boardDAO.selectOne(boardNum);
        } catch (Exception e){
            log.info(e.getMessage());
            log.info("게시글을 가져오는 과정에서 문제 발생!!");
            req.setAttribute("error", "게시글을 정상적으로 가져오지 못했습니다.");
        }
        return boardDTO;
    }

    //글쓰기에서 글을 썼을 때 추가되는 메소드
    public String boardAdd(HttpServletRequest req){
        BoardDTO boardDTO = new BoardDTO();
        UserDTO userDTO = (UserDTO) req.getSession().getAttribute("loginInfo");

        try{
            Part part = req.getPart("file");
            String fileName = this.getFileName(part);
            if(fileName != null && !fileName.isEmpty()){
                part.write(fileName);
            }
            String title = req.getParameter("title");
            String name = req.getParameter("name");
            String content = req.getParameter("content");
            boardDTO.setMemberId(userDTO.getMemberId());
            boardDTO.setTitle(title);
            boardDTO.setName(name);
            boardDTO.setContent(content);
            boardDTO.setFileName(fileName);
            boardDAO.boardAdd(boardDTO);
        } catch (Exception e){
            log.info(e.getMessage());
            log.info("게시글을 올리는데 문제 발생!");
            return "게시글 업데이트 실패";
        }
        return "게시글 업데이트 성공";
    }


}
