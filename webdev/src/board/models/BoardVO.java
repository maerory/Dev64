package board.models;

import java.io.Serializable;

import org.apache.commons.codec.digest.DigestUtils;

public class BoardVO implements Serializable {
	
	private Long no;
	private String name;
	private String title;
	private String passwd;
	private String content;
	private String regdate;
	private int readcount;
	
	public BoardVO(Long no, String name, String title, String passwd, String content, String regdate, int readcount) {
		super();
		this.no = no;
		this.name = name;
		this.title = title;
		this.passwd = passwd;
		this.content = content;
		this.regdate = regdate;
		this.readcount = readcount;
	}
	public BoardVO() {}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", name=" + name + ", title=" + title + ", passwd=" + passwd + ", content="
				+ content + ", regdate=" + regdate + ", readcount=" + readcount + "]";
	}

	public long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = DigestUtils.sha512Hex(passwd);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
}
