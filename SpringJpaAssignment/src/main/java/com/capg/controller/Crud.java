package com.capg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.capg.dao.LibraryDao;
import com.capg.model.Book;
import com.capg.model.Library;


   public class Crud {
	
      LibraryDao libraryDao = new LibraryDao();
      
	
	@RequestMapping("/addbook")
	public void addBook(HttpServletRequest request,HttpServletResponse response) throws IOException 
	{
		
		Library library = new Library();
	    Book book1 = new Book();
	    Book book2 = new Book();
	    Book book3 = new Book();
	      
	      
	    String libraryId = request.getParameter("LibraryId");
    	String libraryName = request.getParameter("LibraryName");
    	
    	String bookId1 = request.getParameter("BookId1");
		String bookName1 = request.getParameter("BookName1");
		String publisher1 = request.getParameter("Publisher1");
		String author1 = request.getParameter("Author1");
		
		
		String bookId2 = request.getParameter("BookId2");
		String bookName2 = request.getParameter("BookName2");
		String publisher2 = request.getParameter("Publisher2");
		String author2 = request.getParameter("Author2");
		
		
		String bookId3 = request.getParameter("BookId3");
		String bookName3 = request.getParameter("BookName3");
		String publisher3 = request.getParameter("Publisher3");
		String author3= request.getParameter("Author3");
		
		PrintWriter writer = response.getWriter();
		
		writer.println(libraryId);
		library.setLibraryId(libraryId);
		
		writer.println(libraryName);
		library.setLibraryId(libraryName);
		
		
		//BOOK 1
		
		writer.println(bookId1);
		book1.setBookId(bookId1);
		
		writer.println(bookName1);
		book1.setBookName(bookName1);
		
		writer.println(publisher1);
		book1.setPublisher(publisher1);
		
		writer.println(author1);
		book1.setAuthor(author1);
		
		//BOOK 2
		
		writer.println(bookId2);
		book2.setBookId(bookId2);
		
		writer.println(bookName2);
		book2.setBookName(bookName2);
		
		writer.println(publisher2);
		book2.setPublisher(publisher2);
		
		writer.println(author2);
		book2.setAuthor(author2);
		
		//BOOK 3
		
		writer.println(bookId3);
		book3.setBookId(bookId3);
		
		writer.println(bookName3);
		book3.setBookName(bookName3);
		
		writer.println(publisher3);
		book3.setPublisher(publisher3);
		
		writer.println(author3);
		book3.setAuthor(author3);
		
		libraryDao.addBook(library);
		
	}
	
	@RequestMapping("/searchbook")
	public void searchBook(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		Library library = libraryDao.searchBook(request.getParameter("searchByLibraryId"));
		
		if(library != null)
		{
			writer.println("Library Id:" + library.getLibraryId());
			writer.print("<br>");
			writer.println("Library Name:" + library.getLibraryName());
			
		}

		Book book = libraryDao.searchBookID(request.getParameter("searchByBookId"));
		
		  writer.print("<br>");
		  if(book != null) { 
			  writer.println("Book Id : " + book.getBookId());
			  writer.print("<br>");
		      writer.println("Book Name : " + book.getBookName());
		      writer.print("<br>");
		      writer.println("Publisher of Book : " + book.getPublisher()); 
		      writer.print("<br>");
		      writer.println("Author of Book : " + book.getAuthor());
		      writer.print("<br>");
		      
		      }
		  else {
		  writer.println("Enter the valid BookId"); }

	}
	
	@RequestMapping("/updatebook")
	public void updateBook(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String ubookId = request.getParameter("BookId");
		String ubookName = request.getParameter("BookName");
		String bookPublisher = request.getParameter("Publisher");
		String bookAuthor = request.getParameter("Author");
		
		
		Book book = libraryDao.searchBookID(ubookId);
		Book updatedBook = libraryDao.updateBook(ubookId, ubookName, bookAuthor, bookPublisher);
		 	
	  	out.println("Updated!!");
	  	out.print("<br>");
		out.println("BookName is : " + updatedBook.getBookName());
		out.print("<br>");
		out.println("Publisher : "+ updatedBook.getPublisher());
		out.print("<br>");
		out.println("Author : "+ updatedBook.getAuthor());
		out.print("<br>");
		
	}
	
	@RequestMapping("/deletebook")
	public void deleteBook(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		LibraryDao librarydao = new LibraryDao();
		librarydao.deleteBook(request.getParameter("DeleteBook"));
		writer.println("Library ID " + request.getParameter("DeleteBook") + " Deleted!!");
	}
	
	
	
	

}
