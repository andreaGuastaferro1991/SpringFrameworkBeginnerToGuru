package com.guastaferro.bootstrap;

import com.guastaferro.model.Author;
import com.guastaferro.model.Book;
import com.guastaferro.model.Publisher;
import com.guastaferro.repo.AuthorRepository;
import com.guastaferro.repo.BookRepository;
import com.guastaferro.repo.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private PublisherRepository publisherRepository;

  public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository=publisherRepository;
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

    Publisher mondadori = new Publisher("Andrea","Mondadori");
    Publisher wassup = new Publisher("Wass","Up");

    publisherRepository.save(mondadori);
    publisherRepository.save(wassup);

    System.out.println("Started in BootStrap");
    System.out.println("Number of Books: "+ bookRepository.count());
    System.out.println("Number of publishers: " + publisherRepository.count());
  }
}
