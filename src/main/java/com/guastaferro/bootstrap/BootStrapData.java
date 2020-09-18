package com.guastaferro.bootstrap;

import com.guastaferro.model.Author;
import com.guastaferro.model.Book;
import com.guastaferro.repo.AuthorRepository;
import com.guastaferro.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private BookRepository bookRepository;

  public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author eric = new Author("Eric", "Evans");
    Book book1 = new Book("Domain Driver Design", "123123");
    eric.getBooks().add(book1);
    book1.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(book1);

    Author rod = new Author("Rod", "Johnson");
    Book book2 = new Book("J2EE Development", "3939393939393939");
    rod.getBooks().add(book2);
    book2.getAuthors().add(rod);

    authorRepository.save(rod);
    bookRepository.save(book2);

    System.out.println("Started in BootStrap");
    System.out.println("Number of Books: "+ bookRepository.count());
  }
}
