package com.cfyj.rabbitMQ.carrier;

import java.util.Date;
import java.util.List;

/**
 * 用来发送消息的bean
 * 
 * @author exception
 *
 */
public class LogCarrier {

	private Long id;
	private String name;
	private List<String> testStrList;
	private Date dateCreated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTestStrList() {
		return testStrList;
	}

	public void setTestStrList(List<String> testStrList) {
		this.testStrList = testStrList;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
