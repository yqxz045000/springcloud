package com.example.demo;

/**
 * 
 * @author cfyj 2017年9月6日 下午5:42:17 传值对象
 *
 */
public class Msg {
	private String title;
	private String content;
	private String extraInfo;

	public Msg() {
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

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public Msg(String title, String content, String extraInfo) {
		this.title = title;
		this.content = content;
		this.extraInfo = extraInfo;
	}
}
