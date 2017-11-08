package mc.shane.graphql.sbgraph.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import mc.shane.graphql.sbgraph.dao.LibraryRepository;
import mc.shane.graphql.sbgraph.domain.Book;
import mc.shane.graphql.sbgraph.domain.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Query implements GraphQLQueryResolver {

    private final LibraryRepository libraryRepository;

    @Autowired
    public Query(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Book> booksForLibrary(Integer libraryId, Integer count) {
        return libraryRepository.findOne(libraryId)
                .getBooks()
                .stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
