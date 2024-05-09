package mingCarServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mingCarServer.board.model.BoardDao;
import mingCarServer.board.model.BoardRequestDto;
import mingCarServer.board.model.BoardResponseDto;
import mingCarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class CreateBoardFormAction
 */
@WebServlet("/CreateBoardFormAction")
public class CreateBoardFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBoardFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		if(title==null||title.equals("")||content==null||content.equals("")) {
			response.sendRedirect("/boardFormAction");
		}
		else {
			BoardDao boardDao = BoardDao.getInstance();
			int code = boardDao.createCode();
			
			HttpSession session = request.getSession();
			UserResponseDto user = (UserResponseDto) session.getAttribute("user");
			
			String id = user.getId();
			boolean category = id.equals("admin") ? true : false;
			
			BoardRequestDto boardDto = new BoardRequestDto(code, id, title, content, id, category);
			
			BoardResponseDto board = boardDao.createBoard(boardDto);
			
			if(board == null)
				response.sendRedirect("/");
			else 
				response.sendRedirect("/boardFormAction");
		}
	}

}
