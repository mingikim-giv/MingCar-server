package mingCarServer.reservation.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mingCarServer.car.model.CarResponseDto;
import mingCarServer.reservation.model.ReservationDao;
import mingCarServer.reservation.model.ReservationRequestDto;
import mingCarServer.reservation.model.ReservationResponseDto;
import mingCarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class ReservationAction
 */
@WebServlet("/ReservationAction")
public class ReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationAction() {
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

		CarResponseDto targetCar = (CarResponseDto)session.getAttribute("targetCar");
		int targetCarCode = targetCar.getCarCode();
		
		String startDate = (String) session.getAttribute("startDate");
		String endDate = (String) session.getAttribute("endDate");
		
		Date start = Date.valueOf(startDate);
		Date end = Date.valueOf(endDate);
		
		String id = user.getId();
		
		ReservationRequestDto reservationDto = new ReservationRequestDto();
		reservationDto.setCarCode(targetCarCode);
		reservationDto.setId(id);
		reservationDto.setStartDate(start);
		reservationDto.setEndDate(end);

		ReservationDao reservationDao = ReservationDao.getInstance();
		ReservationResponseDto result = reservationDao.createReservation(reservationDto);
		
		if (result == null) {
			request.setAttribute("isReservation", false);
		} 
		else {
			request.setAttribute("isReservation", true);
		}
		
		request.getRequestDispatcher("/reservationForm").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
