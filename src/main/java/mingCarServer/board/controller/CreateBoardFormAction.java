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
			response.sendRedirect("/board");
		}
		else {
			BoardDao boardDao = BoardDao.getInstance();
			
			HttpSession session = request.getSession();
			UserResponseDto user = (UserResponseDto) session.getAttribute("user");
			
			String id = user.getId();
			BoardRequestDto boardDto = new BoardRequestDto();
			
			boardDto.setId(id);
			boardDto.setTitle(title);
			boardDto.setContent(content);
			
			boardDao.createBoard(boardDto);
			
			response.sendRedirect("/board");
		}
	}

}
