package mingCarServer.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mingCarServer.user.model.UserDao;
import mingCarServer.user.model.UserRequestDto;
import mingCarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class JoinFormAction
 */
@WebServlet("/JoinFormAction")
public class JoinFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinFormAction() {
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
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		
		// Backend 에서 전달받은 데이터에 대한 유효성 검증
		boolean isValid = true;
		if(id == null || id.equals(""))
			isValid = false;
		else if(password == null || password.equals(""))
			isValid = false;
		else if(name == null || name.equals(""))
			isValid = false;
		else if(birth == null || birth.equals(""))
			isValid = false;
		else if(phone == null || phone.equals(""))
			isValid = false;
		else if(gender == null || gender.equals(""))
			isValid = false;
		
		if(isValid) {
			UserRequestDto userDto = new UserRequestDto(id, password, email, name, birth, phone, gender);
			
			UserDao userDao = UserDao.getInstance();
			UserResponseDto user = userDao.createUser(userDto);
			
			if(user == null) {
				// 실패
				response.sendRedirect("/join");			
			}
			else {
				// 성공
				response.sendRedirect("/login");		
			}
		}
		else {
			response.sendRedirect("/join");
		}
	}

}
