package mingCarServer.reservation.model;

import java.sql.Connection;
import java.sql.Date;
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
			
			Date startDate = reDto.getStartDate();
			Date endDate = reDto.getEndDate();
			
			String sql = "SELECT * FROM reservation WHERE (start_date<=? AND end_date>=?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				int carCode = rs.getInt(2);
				Date stDate = rs.getDate(3);
				Date enDate = rs.getDate(4);
				String paymentMethod = rs.getString(5);
				boolean payment = rs.getBoolean(6);
				
				ReservationResponseDto reservation = new ReservationResponseDto(id, carCode, stDate, enDate, paymentMethod, payment);
				list.add(reservation);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
