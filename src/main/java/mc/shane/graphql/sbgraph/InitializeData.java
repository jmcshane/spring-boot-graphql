package mc.shane.graphql.sbgraph;

import mc.shane.graphql.sbgraph.dao.BookRepository;
import mc.shane.graphql.sbgraph.dao.LibraryRepository;
import mc.shane.graphql.sbgraph.dao.RatingRepository;
import mc.shane.graphql.sbgraph.domain.Book;
import mc.shane.graphql.sbgraph.domain.Library;
import mc.shane.graphql.sbgraph.domain.Rating;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class InitializeData {

    private final BookRepository bookRepo;
    private final LibraryRepository libraryRepo;
    private final RatingRepository ratingRepo;

    public InitializeData(BookRepository bookRepo,
                          LibraryRepository libraryRepo,
                          RatingRepository ratingRepo) {
        this.bookRepo = bookRepo;
        this.libraryRepo = libraryRepo;
        this.ratingRepo = ratingRepo;
    }

    @PostConstruct
    protected void init() {
        Book book = new Book();
        book.setAuthor("Author");
        book.setPublishYear(1999);
        book.setTitle("My Book");
        final Book bookCreate = bookRepo.save(book);

        Book book1 = new Book();
        book1.setAuthor("Steve Test");
        book1.setPublishYear(1978);
        book1.setTitle("My Writings");
        final Book book1create = bookRepo.save(book1);

        Library library = new Library();
        library.setAddress("8675309 Street");
        library.setLibraryName("My Library");
        library = libraryRepo.save(library);
        bookCreate.setLibrary(library);
        book1create.setLibrary(library);
        bookRepo.save(bookCreate);
        bookRepo.save(book1create);
        Rating rating = new Rating();
        rating.setRatingText("I liked it");
        rating.setScore(4);
        rating.setBook(bookCreate);
        ratingRepo.saveAndFlush(rating);

        Rating rating1 = new Rating();
        rating1.setRatingText("I didn't like it");
        rating1.setScore(2);
        rating1.setBook(book1create);
        ratingRepo.saveAndFlush(rating1);

        Rating rating2 = new Rating();
        rating2.setRatingText("I loved it");
        rating2.setScore(5);
        rating2.setBook(book1create);
        ratingRepo.saveAndFlush(rating2);

    }
}
