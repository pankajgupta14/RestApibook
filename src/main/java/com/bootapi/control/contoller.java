package com.bootapi.control;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootapi.entity.*;
import com.bootapi.service.bookservice;

import jakarta.websocket.server.PathParam;
 
@RestController
public class contoller {

	@Autowired
	private bookservice Bookservice;
	
	@GetMapping("/books")
	public ResponseEntity<List<book>> books()
	{
		List<book> list = this.Bookservice.getallbook();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	@GetMapping("/books/{id}")
	public ResponseEntity<book> book(@PathVariable("id")  int id)
	{
		book list = this.Bookservice.getbyid(id);
		if(list==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list)); 
	}
	
	@PostMapping("/books")
	public ResponseEntity<Optional<book>> addbook(@RequestBody book bb)
	{
		System.out.println(bb);
		book adbook= null;
		try {
			 adbook = this.Bookservice.addbook(bb);
			 return ResponseEntity.ok(Optional.of(adbook));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/books/{bookid}")
	public ResponseEntity<Void> deletebook(@PathVariable("bookid") int id) {
		try {
			this.Bookservice.deletebookbyid(id);	
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	 }
	
	//update the book
	@PutMapping("/books/{bookid}")
	public ResponseEntity<Void> updatebook(@RequestBody book b , @PathVariable("bookid") int id) {
		try {
			this.Bookservice.updatebookbyid(b, id);
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
