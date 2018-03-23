package session.test;

import java.io.Serializable;

public class MemberVO implements Serializable {
	private String user_id;
	private String user_name;
	private Integer user_level;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getUser_level() {
		return user_level;
	}
	public void setUser_level(Integer user_level) {
		this.user_level = user_level;
	}
	@Override
	public String toString() {
		return "MemberVO [user_id=" + user_id + ", user_name=" + user_name + ", user_level=" + user_level + "]";
	}
	
	
}
