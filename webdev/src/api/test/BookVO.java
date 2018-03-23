package api.test;

import java.io.Serializable;

public class BookVO implements Serializable{
	private String subject;
	private String writer;
	private String publiser;
	private String genre;
	private long price;
	
	
	
	public BookVO(String subject, String writer, String publiser, String genre, long price) {
		super();
		this.subject = subject;
		this.writer = writer;
		this.publiser = publiser;
		this.genre = genre;
		this.price = price;
	}
	
	public BookVO() {
		super();
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPubliser() {
		return publiser;
	}
	public void setPubliser(String publiser) {
		this.publiser = publiser;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "BookVO [subject=" + subject + ", writer=" + writer + ", publiser=" + publiser + ", genre=" + genre
				+ ", price=" + price + "]";
	}
	
	
}
