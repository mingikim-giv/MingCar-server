package mingCarServer.reservation.controller;

import java.io.IOException;
import java.sql.Timestamp;
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
import mingCarServer.reservation.model.ReservationRequestDto;
import mingCarServer.reservation.model.ReservationResponseDto;

/**
 * Servlet implementation class UpdateFormAction
 */
public class UpdateFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		Object temp = session.getAttribute("targetReservation");
		int reCode = Integer.parseInt(temp.toString());
		
		ReservationDao reservationDao = ReservationDao.getInstance();
		
		String resevDate = request.getParameter("resevDate");
		String resevTime = request.getParameter("resevTime");
		
		String returnDate = request.getParameter("returnDate");
		String returnTime = request.getParameter("returnTime");
		
		String resevDtTemp = resevDate + " " + resevTime;
		String returnDtTemp = returnDate + " " + returnTime;
		
		Timestamp resevDt = Timestamp.valueOf(resevDtTemp);
		Timestamp returnDt = Timestamp.valueOf(returnDtTemp);
		
		boolean isValid = true;
		
		if(temp == null || temp.equals(""))
			isValid = false;
		else if(resevDate == null || resevDate.equals(""))
			isValid = false;
		else if(resevTime == null || resevTime.equals(""))
			isValid = false;
		else if(returnDate == null || returnDate.equals(""))
			isValid = false;
		else if(returnTime == null || returnTime.equals(""))
			isValid = false;
		
		if(isValid) {
			boolean updateRe = reservationDao.updateReservation(reCode, resevDt, returnDt);
			if(updateRe) {
				request.setAttribute("isValid", true);
				
			} else {
				request.setAttribute("isValid", false);
			}
			
		} else {
			request.setAttribute("isValid", false);
		}
		request.getRequestDispatcher("/reservationForm").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
}
