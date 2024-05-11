package mingCarServer.reservation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mingCarServer.util.DBManager;

public class ReservationDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private ReservationDao() {}
	
	private static ReservationDao instance = new ReservationDao();

	public static ReservationDao getInstance() {
		return instance;
	}
	
	public List<ReservationResponseDto> createReservation(ReservationRequestDto reDto) {
		List<ReservationResponseDto> list = new ArrayList<ReservationResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
