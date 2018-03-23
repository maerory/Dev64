package net.n1books.dev.article.controllers;

import java.io.Serializable;

public class PageVO implements Serializable {
	private long startnum;
	private long endnum;
	
	public long getStartnum() {
		return startnum;
	}
	public void setStartnum(long startnum) {
		this.startnum = startnum;
	}
	public long getEndnum() {
		return endnum;
	}
	public void setEndnum(long endnum) {
		this.endnum = endnum;
	}
	@Override
	public String toString() {
		return "PageVO [startnum=" + startnum + ", endnum=" + endnum + "]";
	}
}
