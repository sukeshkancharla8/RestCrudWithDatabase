package com.accolite.rest.RestSample.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private int id;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Message() {
		// TODO Auto-generated constructor stub
	}
	public Message(int id, String content) {
		super();
		this.id = id;
		this.content = content;
		
	}
	
}
