package mingCarServer.car.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mingCarServer.car.model.CarDao;
import mingCarServer.car.model.CarResponseDto;
import mingCarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class TargetCarAction
 */
@WebServlet("/TargetCarAction")
public class TargetCarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TargetCarAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		UserResponseDto user = (UserResponseDto) session.getAttribute("user");

		if(user == null) {
			response.sendRedirect("/login");
		}
		else {
			String targetCarNum = request.getParameter("targetCarNum");
			
			CarDao carDao = CarDao.getInstance();
			CarResponseDto targetCar = carDao.findCarByCarNumber(targetCarNum);
			session.setAttribute("targetCar", targetCar);
			
			response.sendRedirect("/carDetail");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
