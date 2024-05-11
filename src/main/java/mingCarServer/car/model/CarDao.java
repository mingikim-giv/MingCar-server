package mingCarServer.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mingCarServer.util.DBManager;

public class CarDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CarDao() {}
	
	private static CarDao instance = new CarDao();
	
	public static CarDao getInstance() {
		return instance;
	}
	
	public List<CarResponseDto> findCarAll() {
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT * FROM cars";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int carCode = rs.getInt(1);
				String carNumber = rs.getString(2);
				String carName = rs.getString(3);
				int carPrice = rs.getInt(4);
				String carType = rs.getString(5);
				int carSeat = rs.getInt(6);
				boolean reservation = rs.getBoolean(7);
				
				CarResponseDto temp = new CarResponseDto(carCode, carNumber, carName, carPrice, carType, carSeat, reservation);	
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return list;
	}
	
	public CarResponseDto findCarByCarNumber(String str) {
		CarResponseDto response = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT * FROM cars WHERE car_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int carCode = rs.getInt(1);
				String carNumber = rs.getString(2);
				String carName = rs.getString(3);
				int carPrice = rs.getInt(4);
				String carType = rs.getString(5);
				int carSeat = rs.getInt(6);
				boolean reservation = rs.getBoolean(7);
				
				response = new CarResponseDto(carCode, carNumber, carName, carPrice, carType, carSeat, reservation);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return response;
	}
}
