package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.revature.pojo.Book;

public class BookSerializationDAO implements BookDAO {

	public void createBook(Book b) {
		String filename;
		filename = b.getIsbn() + ".dat";
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Book readBook(String isbn) {
		return null;
	}

}
