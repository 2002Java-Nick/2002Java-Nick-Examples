package com.revature.driver;

import com.revature.dao.BookDAO;
import com.revature.dao.BookSerializationDAO;
import com.revature.pojo.Book;

public class Driver {
	
	private static BookDAO bDao = new BookSerializationDAO();

	public static void main(String[] args) {
		Book b = new Book("1234567890", "How to make money", "Nick", "self help", 1000.0, 3);
		bDao.createBook(b);
	}

}
