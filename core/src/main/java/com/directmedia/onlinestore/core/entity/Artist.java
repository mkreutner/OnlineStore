package com.directmedia.onlinestore.core.entity;

public class Artist {
	private String name;

	/**
	 * Default constructor
	 */
	public Artist() {
		super();
	}

	/**
	 * Constructor with field
	 * @param name: Name of artist
	 */
	public Artist(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
