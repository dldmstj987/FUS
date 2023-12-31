package com.example.fus.controller;

import com.example.fus.dto.BoardDTO;
import com.example.fus.service.BoardService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet("/board/*")
@MultipartConfig(maxFileSize = 2 * 1024 * 1024, location ="/Users/ieunseo/Desktop/dev/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/upload" )
public class BoardController extends HttpServlet {
    private BoardService boardService = null;
    private String path = null;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boardService = new BoardService();

        path = req.getPathInfo();


        if (path == null) {
            path = "/all";
        }

        switch (path) {
            case "/all":
                List<BoardDTO> boardDTOList = boardService.listBoardDTO();
                req.setAttribute("boardDTOList", boardDTOList);
                req.getRequestDispatcher("/WEB-INF/board/boardList.jsp").forward(req, resp);
                break;

            case "/add":
                req.getRequestDispatcher("/WEB-INF/board/boardAdd.jsp").forward(req, resp);
                break;

            case "/remove":
                boardService.removeBoard(req);
//                resp.sendRedirect("list.board?action=list");
                break;

            case "/view":
                BoardDTO boardDTO = boardService.getBoard(req);
                req.setAttribute("boardDTO", boardDTO);
                req.getRequestDispatcher("/WEB-INF/board/boardView.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boardService = new BoardService();

        path = req.getPathInfo();


        if (path == null) {
            path = "/all";
        }

        switch (path) {
            case "/all":
                List<BoardDTO> boardDTOList = boardService.listBoardDTO();
                req.setAttribute("boardDTOList", boardDTOList);
                req.getRequestDispatcher("/WEB-INF/board/boardList.jsp").forward(req, resp);
                break;

            case "/add":
                boardService.boardAdd(req);
                resp.sendRedirect("/board/all");
                break;

            case "/remove":
                boardService.removeBoard(req);
                resp.sendRedirect("list.board?action=list");
                break;

            case "/view":
                boardService.getBoard(req);
                req.getRequestDispatcher("/WEB-INF/board/boardView.jsp").forward(req, resp);
                break;


        }


    }

}
