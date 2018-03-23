package net.n1books.dev.article.controllers;

import java.io.Serializable;

import org.apache.commons.codec.digest.DigestUtils;

public class ArticleVO implements Serializable {
	private long no;
	private String title;
	private String name;
	private String passwd;
	private String regdate;
	private int readcount;
	private String content;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = DigestUtils.sha512Hex(passwd);
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ArticleVO [no=" + no + ", title=" + title + ", name=" + name + ", passwd=" + passwd + ", regdate="
				+ regdate + ", readcount=" + readcount + ", content=" + content + "]";
	}
	
	
}
