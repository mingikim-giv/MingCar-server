package mingCarServer.reservation.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mingCarServer.car.model.CarDao;
import mingCarServer.car.model.CarResponseDto;
import mingCarServer.reservation.model.ReservationDao;
import mingCarServer.reservation.model.ReservationResponseDto;

/**
 * Servlet implementation class UpdateReservationAction
 */
public class UpdateReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReservationAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String temp = request.getParameter("reCode");
	
		int reCode = Integer.parseInt(temp);
		
		ReservationDao reservationDao = ReservationDao.getInstance();
		ReservationResponseDto reservation = reservationDao.findReservationCode(reCode);
		
		String resevDt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(reservation.getStartDate());
		String returnDt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(reservation.getEndDate());
		
		String resevDate = resevDt.substring(0,10);
		String resevTime = resevDt.substring(11,resevDt.length());
		
		String returnDate = returnDt.substring(0,10);
		String returnTime = returnDt.substring(11,resevDt.length());
		
		int carCode = reservation.getCarCode();
		
		CarDao carDao = CarDao.getInstance();
//		CarResponseDto targetCar = carDao.findCarByCarNumber(carCode);
		
		HttpSession session = request.getSession();
		
//		session.setAttribute("targetCar", targetCar);
		session.setAttribute("resevDate", resevDate);
		session.setAttribute("returnDate", returnDate);
		session.setAttribute("resevTime", resevTime);
		session.setAttribute("returnTime", returnTime);
		session.setAttribute("targetReservation", reCode);
		
		response.sendRedirect("/carDetail");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
