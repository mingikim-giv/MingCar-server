package mingCarServer.board.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mingCarServer.util.DBManager;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int cnt;
	
	private BoardDao() {};
	
	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	public List<BoardResponseDto> findBoardAll() {
		List<BoardResponseDto> list = new ArrayList<BoardResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT board_code, user_id, title, content, author, category, reg_write, mod_write FROM board ORDER BY reg_write DESC";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int boardcode = rs.getInt(1);
				String id = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String author = rs.getString(5);
				Boolean category = rs.getBoolean(6);
				Date regWrite = rs.getDate(7);
				Date modWrite = rs.getDate(8);
				
				BoardResponseDto board = new BoardResponseDto(boardcode, id, title, content, author, category, regWrite, modWrite);
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public BoardResponseDto findBoardCode(int boardCode) {
		BoardResponseDto board = null;
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT board_code, user_id, title, content, author, category, reg_write, mod_write FROM board WHERE board_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardCode);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int code = rs.getInt(1);
				String id = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String author = rs.getString(5);
				Boolean category = rs.getBoolean(6);
				Date regWrite = rs.getDate(7);
				Date modWrite = rs.getDate(8);
				
				if(boardCode == code) {
					board = new BoardResponseDto(boardCode, id, title, content, author, category, regWrite, modWrite);
					return board;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return board;
	}
	
	public int createCode() {
		int code;
		code = ++ cnt;
		return code;
	}
	
	public BoardResponseDto createBoard(BoardRequestDto boardDto) {
		BoardResponseDto board = null;
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO board(board_code, user_id, title, content, author, category) VALUES(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql); 
			
			String id = boardDto.getId();
			
			pstmt.setInt(1, boardDto.getBoardCode());
			pstmt.setString(2, boardDto.getId());
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContent());
			pstmt.setString(5, boardDto.getAuthor());
			pstmt.setBoolean(6, id.equals("admin") ? true : false);

			pstmt.execute();
			board = findBoardCode(boardDto.getBoardCode());
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return board;
	}
	
	public boolean deleteBoardForm(int boardCode) {
		try {
			conn = DBManager.getConnection();
			
			String sql = "DELETE FORM board WHERE board_code=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardCode);
			
			pstmt.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return false;
	}
}
