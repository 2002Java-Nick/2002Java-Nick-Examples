package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojo.Book;

public class BookSerializationDAO implements BookDAO {

	public void createBook(Book b) {
		String filename;
		filename = b.getIsbn() + ".dat";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Book readBook(String isbn) {
		
		String filename;
		filename = isbn + ".dat";
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Book b = null;
		try {
			fis = new FileInputStream(filename);
			ois = new ObjectInputStream(fis);
			b = (Book) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
