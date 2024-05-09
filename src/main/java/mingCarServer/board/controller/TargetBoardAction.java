package mingCarServer.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mingCarServer.board.model.BoardDao;
import mingCarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class TargetBoardAction
 */
@WebServlet("/TargetBoardAction")
public class TargetBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TargetBoardAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String boardCode = request.getParameter("boardCode");
		int boardNum = Integer.parseInt(boardCode);
		
		BoardDao boardDao = BoardDao.getInstance();
		BoardResponseDto targetBoard = boardDao.findBoardCode(boardNum);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("targetBoard", targetBoard);
		response.sendRedirect("/targetBoardForm");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
