package mingCarServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mingCarServer.util.PasswordCrypto;
import mingCarServer.util.DBManager;
import mingCarServer.user.model.UserRequestDto;
import mingCarServer.user.model.UserResponseDto;

public class UserDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// UserDao 객체를 단일 인스턴스로 만들기 위해
	// Singleton Pattern 적용
	
	// 1. 생성자를 private으로
	private UserDao() {}
	
	// 2. 단일 인스턴스를 생성 (클래스 내부에서)
	private static UserDao instance = new UserDao();
	
	// 3. 단일 인스턴스에 대한 getter
	public static UserDao getInstance() {
		return instance;
	}
	
	public List<UserResponseDto> findUserAll() {
		List<UserResponseDto> list = new ArrayList<UserResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			
			// 쿼리할 준비
			String sql = "SELECT user_id, email, name, birth, phone, gender FROM users";
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리 실행
			rs = pstmt.executeQuery();		// <- 결과가 rs 변수에 담김
			
			// 튜플 읽기
			while(rs.next()) {
				// database의 column index는 1부터 시작!
				String id = rs.getString(1);
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String phone = rs.getString(5);
				String gender = rs.getString(6);
				
				UserResponseDto user = new UserResponseDto(id, email, name, birth, phone, gender);
				list.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public UserResponseDto findUserByIdAndPassword(String id, String password) {
		UserResponseDto user = null;
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT user_id, email, name, birth, phone, gender FROM users WHERE user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String phone = rs.getString(5);
				String gender = rs.getString(6);
				String encryptedPassword = rs.getString(7);
				
				if(PasswordCrypto.decrypt(password, encryptedPassword)) {
					// user 초기화
					user = new UserResponseDto(id, email, name, birth, phone, gender);
					return user;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return null;
	}
	
	public boolean userExists(UserRequestDto userDto) {
		return findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) != null;
	}
	
	public UserResponseDto createUser(UserRequestDto userDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO  users(user_id, password, email, name, birth, phone, gender) VALUES(?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, PasswordCrypto.encrypt(userDto.getPassword()));
			
			String email = userDto.getEmail().equals("") ? null : userDto.getEmail();
			pstmt.setString(3, email);
			
			pstmt.setString(4, userDto.getName());
			pstmt.setString(5, userDto.getBirth());
			pstmt.setString(6, userDto.getPhone());
			pstmt.setString(7, userDto.getGender());
			
			pstmt.execute();
			return findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}
}
