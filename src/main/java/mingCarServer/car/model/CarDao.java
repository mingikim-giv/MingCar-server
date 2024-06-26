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
				String carName = rs.getString(2);
				int carPrice = rs.getInt(3);
				String carType = rs.getString(4);
				int carSeat = rs.getInt(5);
				boolean reservation = rs.getBoolean(6);
				
				CarResponseDto temp = new CarResponseDto(carCode, carName, carPrice, carType, carSeat, reservation);	
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
			
			String sql = "SELECT * FROM cars WHERE car_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int carCode = rs.getInt(1);
				String carName = rs.getString(2);
				int carPrice = rs.getInt(3);
				String carType = rs.getString(4);
				int carSeat = rs.getInt(5);
				boolean reservation = rs.getBoolean(6);
				
				response = new CarResponseDto(carCode, carName, carPrice, carType, carSeat, reservation);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return response;
	}
	
	public List<CarResponseDto> searchCarType(String typeTemp) {
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT * FROM cars WHERE car_type LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, typeTemp);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int carCode = rs.getInt(1);
				String carName = rs.getString(2);
				int carPrice = rs.getInt(3);
				String carType = rs.getString(4);
				int carSeat = rs.getInt(5);
				boolean reservation = rs.getBoolean(6);
				
				CarResponseDto car = new CarResponseDto(carCode, carName, carPrice, carType, carSeat, reservation);
				list.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
