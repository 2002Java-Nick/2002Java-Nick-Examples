package com.revature.dao;

import com.revature.pojo.Book;

public interface BookDAO {
	
	public void createBook(Book b);
	
	public Book readBook(String isbn);

}
