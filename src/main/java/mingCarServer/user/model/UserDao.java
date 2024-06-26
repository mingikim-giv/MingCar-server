package mingCarServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
			
			String sql = "SELECT user_id, email, name, birth, phone, gender, password FROM users WHERE user_id=?";
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
	
	public boolean userExists(String id) {
		return findUserById(id) != null;
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
	
	public UserResponseDto updateUserPassword(UserRequestDto userDto, String newPassword) {
		UserResponseDto user = null;
		
		if(newPassword == null || newPassword.equals("")) {
			return user;
		}
		
		// 이때 쿼리 할 필요 X
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null)
			return user;
		
		try {
			System.out.println("password");
			conn = DBManager.getConnection();
			
			String sql = "UPDATE users SET password=? WHERE user_id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PasswordCrypto.encrypt(newPassword));
			pstmt.setString(2, userDto.getId());
			
			pstmt.execute();
			
			User userVo = findUserById(userDto.getId());
			
			user = new UserResponseDto(userVo);
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return user;
	}
	
	public UserResponseDto updateUserEmail(UserRequestDto userDto) {
		UserResponseDto user = null;
		
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null)
			return user;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE users SET email=? WHERE user_id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			// 맵핑하기
			pstmt.setString(1, userDto.getEmail());
			pstmt.setString(2, userDto.getId());
			
			// sql 구문 실행
			pstmt.execute();
			
			user = findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return user;
	}
	
	public UserResponseDto updateUserPhone(UserRequestDto userDto) {
		UserResponseDto user = null;
		
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null)
			return user;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE users SET phone=? WHERE user_id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userDto.getPhone());
			pstmt.setString(2, userDto.getId());
			
			pstmt.execute();
			
			user = findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return user;
	}
	
	// 패스워드가 일치하지 않으면 false가 됨
	public boolean deleteUser(UserRequestDto userDto) {
		
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null) {
			return false;
		}
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "DELETE FROM users WHERE user_id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userDto.getId());
			
			pstmt.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return false;
	}
	
	private User findUserById(String id) {
		User user = null;
		
		try {
			conn = DBManager.getConnection();
			
			// 쿼리할 준비
			String sql = "SELECT user_id, email, name, birth, phone, gender, reg_date, mod_date FROM users WHERE user_id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			// 쿼리 실행
			rs = pstmt.executeQuery();		// <- 결과가 rs 변수에 담김
			
			// 튜플 읽기
			if(rs.next()) {
				// database의 column index는 1부터 시작!
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String phone = rs.getString(5);
				String gender = rs.getString(6);
				Timestamp regDate = rs.getTimestamp(7);
				Timestamp modDate = rs.getTimestamp(8);
				
				// user 초기화
				user = new User(id, email, name, birth, phone, gender, regDate, modDate);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return user;
	}
}
