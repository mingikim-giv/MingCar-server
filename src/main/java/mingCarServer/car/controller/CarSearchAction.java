package mingCarServer.car.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mingCarServer.car.model.CarDao;
import mingCarServer.car.model.CarResponseDto;

/**
 * Servlet implementation class CarSearchAction
 */
public class CarSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarSearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String carType = request.getParameter("search-type");
		
		session.setAttribute("carType", carType);
		
		CarDao carDao = CarDao.getInstance();
		
		List<CarResponseDto> carList = carDao.searchCarType(carType);
		
		System.out.println("carList" + carList);
		request.setAttribute("carList", carList);

		request.getRequestDispatcher("/carForm").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
