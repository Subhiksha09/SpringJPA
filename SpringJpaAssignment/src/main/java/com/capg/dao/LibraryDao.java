package com.capg.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capg.model.Book;
import com.capg.model.Library;


public class LibraryDao {
	

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Library");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public void addBook(Library library) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(library);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	
	}
	
	  public Library searchBook(String libraryId) { 
		  return entityManager.find(Library.class,libraryId); 
		  }
	 
	  public Book searchBookID(String bookId) { 
		  return entityManager.find(Book.class,bookId); 
		  }
	  
	  public Book updateBook(String ubookId, String ubookName, String bookAuthor, String bookPublisher) {
			
			Book book = searchBookID(ubookId);
			entityManager.getTransaction().begin();
		    book.setBookName(ubookName);
			book.setAuthor(bookAuthor);
			book.setPublisher(bookPublisher);
			entityManager.getTransaction().commit();
			return book;
		}
	  
	  public void deleteBook(String libraryId) {
	  
		  entityManager.getTransaction().begin(); 
		  Library library = searchBook(libraryId); 
		  entityManager.remove(library);
		  entityManager.getTransaction().commit();
		}

}
