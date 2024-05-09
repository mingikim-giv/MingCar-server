package mingCarServer.board.model;

import java.sql.Date;

public class BoardResponseDto {
	private int boardCode;
	private String id;
	private String title;
	private String content;
	private String author;
	private boolean category;
	private Date regWrite;
	private Date modWrite;
	
	public BoardResponseDto(int boardCode, String id, String title, String content, String author, boolean category,
			Date regWrite, Date modWrite) {
		super();
		this.boardCode = boardCode;
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.category = category;
		this.regWrite = regWrite;
		this.modWrite = modWrite;
	}

	public int getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isCategory() {
		return category;
	}

	public void setCategory(boolean category) {
		this.category = category;
	}

	public Date getRegWrite() {
		return regWrite;
	}

	public void setRegWrite(Date regWrite) {
		this.regWrite = regWrite;
	}

	public Date getModWrite() {
		return modWrite;
	}

	public void setModWrite(Date modWrite) {
		this.modWrite = modWrite;
	}
	
	@Override
	public String toString() {
		return String.format("board_code: %d id: %s title: %s content: %s author: %s category: %b", boardCode, id, title, content, author, category);
	}
}
