package com.jersey;

public class ContatoModel {
	private int id;
	private String name;
	private String cel;
	private String email;
	
	public ContatoModel(){}

	public ContatoModel(int id, String name, String cel, String email) {
		this.id = id;
		this.name = name;
		this.cel = cel;
		this.email = email;
	}

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

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
