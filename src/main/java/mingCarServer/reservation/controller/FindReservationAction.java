package mingCarServer.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mingCarServer.car.model.CarDao;
import mingCarServer.reservation.model.ReservationDao;
import mingCarServer.reservation.model.ReservationResponseDto;
import mingCarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class FindReservationAction
 */
public class FindReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindReservationAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		ReservationDao reservationDao = ReservationDao.getInstance();

		if(session.getAttribute("user") == null)
			response.sendRedirect("/login");
		else {
			UserResponseDto user = (UserResponseDto) session.getAttribute("user");
			
			String id = (String) user.getId();
			
			List<ReservationResponseDto> reserveList = reservationDao.findReservationId(id);
			System.out.println("reserveList : "+reserveList);
			
			request.setAttribute("reserveList", reserveList);
			
			request.getRequestDispatcher("/mypage").forward(request, response);
			
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
