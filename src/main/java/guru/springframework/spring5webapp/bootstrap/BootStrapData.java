package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository
            , PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author peter = new Author("Peter", "K");
        Book spring = new Book("Spring Ebook", "12354");
        peter.getBooks().add(spring);
        spring.getAuthors().add(peter);

        authorRepository.save(peter);
        bookRepository.save(spring);

        Author eric = new Author("Eric", "K");
        Book noEJB = new Book("J2EE", "665485");
        eric.getBooks().add(noEJB);
        noEJB.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(noEJB);

        Publisher nzPub = new Publisher("nzPub", "Auckland", "AKL", "AKL", "0623");
        publisherRepository.save(nzPub);

        System.out.println("---Started in Bootstrap---");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher output: " + nzPub);
    }
}
