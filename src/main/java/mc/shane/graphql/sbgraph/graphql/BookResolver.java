package mc.shane.graphql.sbgraph.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import mc.shane.graphql.sbgraph.dao.BookRepository;
import mc.shane.graphql.sbgraph.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    private final BookRepository repository;

    @Autowired
    public BookResolver(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getBooksForAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public List<Book> getBooks(int count, int offset) {
        Pageable pageable = new PageRequest(offset / count, count);
        return repository.findAll(pageable).getContent();
    }

    public Book getBook(Integer bookId) {
        return repository.findOne(bookId);
    }
}
