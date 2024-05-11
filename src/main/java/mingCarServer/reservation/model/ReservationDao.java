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
	
	public List<ReservationResponseDto> reservationList(ReservationRequestDto reDto) {
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
				int reserveCode = rs.getInt(1);
				String id = rs.getString(2);
				int carCode = rs.getInt(3);
				Date stDate = rs.getDate(4);
				Date enDate = rs.getDate(5);
				String paymentMethod = rs.getString(6);
				boolean payment = rs.getBoolean(7);
				
				ReservationResponseDto reservation = new ReservationResponseDto(reserveCode, id, carCode, stDate, enDate, paymentMethod, payment);
				list.add(reservation);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ReservationResponseDto createReservation(ReservationRequestDto reservationDto) {
		ReservationResponseDto response = null;
		
		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO reservation (`user_id`, `car_code`, `start_date`, `end_date`) VALUES(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, reservationDto.getId());
			pstmt.setInt(2, reservationDto.getCarCode());
			pstmt.setDate(3, reservationDto.getStartDate());
			pstmt.setDate(4, reservationDto.getEndDate());

			pstmt.execute();
			
			response = findReservationNumber(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return response;
	}
	
	public ReservationResponseDto findReservationNumber(int resNum) {
		ReservationResponseDto reservation = null;
		
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM reservation WHERE `reserve_code`=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, resNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				int carCode = rs.getInt(2);
				Date startDate = rs.getDate(3);
				Date endDate = rs.getDate(4);
				String paymentMethod = rs.getString(5);
				boolean payment = rs.getBoolean(6);

				reservation = new ReservationResponseDto(resNum, id, carCode, startDate, endDate, paymentMethod, payment);
			}
			return reservation;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return reservation;
	}
}
