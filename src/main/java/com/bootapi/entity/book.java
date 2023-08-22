package com.bootapi.entity;

import org.springframework.stereotype.Component;

@Component
public class book {

	private int id;
	private String name;
	private String author;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public book(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	
	
}
