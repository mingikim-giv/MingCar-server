package mingCarServer.reservation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
			
			Timestamp startDate = reDto.getStartDate();
			Timestamp endDate = reDto.getEndDate();
			
			String sql = "SELECT * FROM reservation WHERE (start_date<=? AND end_date>=?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, startDate);
			pstmt.setTimestamp(2, endDate);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int reserveCode = rs.getInt(1);
				String id = rs.getString(2);
				int carCode = rs.getInt(3);
				Timestamp stDate = rs.getTimestamp(4);
				Timestamp enDate = rs.getTimestamp(5);
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

			String sql = "INSERT INTO reservation (`user_id`, `car_code`, `payment_method`, `start_date`, `end_date`) VALUES(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, reservationDto.getId());
			pstmt.setInt(2, reservationDto.getCarCode());
			pstmt.setString(3, reservationDto.getPaymentMethod());
			pstmt.setTimestamp(4, reservationDto.getStartDate());
			pstmt.setTimestamp(5, reservationDto.getEndDate());

			pstmt.execute();
			
			response = findReservationCode(reservationCode());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return response;
	}
	
	public ReservationResponseDto findReservationCode(int resNum) {
		ReservationResponseDto reservation = null;
		
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM reservation WHERE `reserve_code`=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, resNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString(2);
				int carCode = rs.getInt(3);
				Timestamp startDate = rs.getTimestamp(4);
				Timestamp endDate = rs.getTimestamp(5);
				String paymentMethod = rs.getString(6);
				boolean payment = rs.getBoolean(7);

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
	
	public int reservationCode() {
		int reservationCode = -1;
		
		try {
			String sql = "SELECT reserve_code FROM reservation";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				reservationCode = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservationCode;
	}
}
