package mc.shane.graphql.sbgraph.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import mc.shane.graphql.sbgraph.dao.BookRepository;
import mc.shane.graphql.sbgraph.dao.RatingRepository;
import mc.shane.graphql.sbgraph.domain.Book;
import mc.shane.graphql.sbgraph.domain.Rating;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final RatingRepository ratingRepository;
    private final BookRepository bookRepository;

    public Mutation(RatingRepository ratingRepository,
                    BookRepository bookRepository) {
        this.ratingRepository = ratingRepository;
        this.bookRepository = bookRepository;
    }

    public Rating writeRating(Integer bookId, Integer score, String ratingText) {
        Book book = bookRepository.findOne(bookId);
        if (book == null) {
            throw new IllegalArgumentException("No book found");
        }
        Rating rating = Rating.build()
                .withBook(book)
                .withScore(score)
                .withRatingText(ratingText)
                .build();
        return ratingRepository.save(rating);
    }
}
