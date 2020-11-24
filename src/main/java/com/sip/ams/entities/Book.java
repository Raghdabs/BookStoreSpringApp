package com.sip.ams.entities;

import java.sql.Date;

public class Book {
	private int id;
	private String title;
	private String Author;
	private double Price;
	private Date ReleaseDate;
	private String path;

	public Book(int id, String title, String author, double price, Date releaseDate, String path) {
		super();
		this.id = id;
		this.title = title;
		Author = author;
		Price = price;
		ReleaseDate = releaseDate;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public Date getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", Author=" + Author + ", Price=" + Price + ", ReleaseDate="
				+ ReleaseDate + ", path=" + path + "]";
	}

}
