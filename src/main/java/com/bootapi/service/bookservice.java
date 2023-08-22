package com.bootapi.service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bootapi.entity.book;

@Component
public class bookservice {

	private static List<book> bk = new ArrayList<book>();

	static {
		bk.add(new book(1, "java", "james"));
		bk.add(new book(2, "collection", "advance"));
		bk.add(new book(3, "springboot", "spring"));
	}

	// getting all book
	public List<book> getallbook() {
		return bk;
	}

	// getting book by id
	public book getbyid(int id) {
		Iterator<book> itr = bk.iterator();

		while (itr.hasNext()) {
			book b = itr.next();
			if (b.getId() == id) {
				return b; // Found the book with the specified ID
			}
		}
		return null; // Book with the specified ID was not found
	}
	
	// add book
	public book addbook(book bb)
	{
		bk.add(bb);
		return bb;
	}
	
 // dleteing a book
	public void deletebookbyid(int id)
	{
		bk = bk.stream().filter(book ->book.getId()!=id).collect(Collectors.toList());
	}
	//update a book
	public void updatebookbyid(book b , int id) {
		Iterator<book>  itr = bk.iterator();
		 
		while(itr.hasNext()) {
			book next = itr.next();
			if(next.getId()== id) {
				next.setAuthor(b.getAuthor());
				next.setName(null);
			}
		}
	}
	
}
