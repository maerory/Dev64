package net.n1books.dev.mvc;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.validator.constraints.Length;

public class MemoVO implements Serializable {
	
	@Length(min = 2, max = 6)
	private String name;
	
	@NotBlank
	private String title;
	
	@Length(min = 2)
	private String passwd;
	
	@Length(min = 1, max = 1000)
	private String content;
	
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
		if (passwd.trim().length() >= 2) {
			this.passwd = DigestUtils.sha512Hex(passwd);
		} else {
			this.passwd = passwd;
		}
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "MemoVO [name=" + name + ", title=" + title + ", passwd=" + passwd + ", content=" + content + "]";
	}
	
	
}
