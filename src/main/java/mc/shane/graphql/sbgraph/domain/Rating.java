package mc.shane.graphql.sbgraph.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private int score;

    @ManyToOne
    @JoinColumn(name="bookFK")
    private Book book;

    @Column
    private String ratingText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    public static RatingBuilder build() {
        return new RatingBuilder();
    }

    public static class RatingBuilder {
        private int score;
        private Book book;
        private String ratingText;

        public RatingBuilder withScore(int score) {
            this.score = score;
            return this;
        }
        public RatingBuilder withBook(Book book) {
            this.book = book;
            return this;
        }
        public RatingBuilder withRatingText(String ratingText) {
            this.ratingText = ratingText;
            return this;
        }

        public Rating build() {
            Rating rating = new Rating();
            rating.setBook(book);
            rating.setScore(score);
            rating.setRatingText(ratingText);
            return rating;
        }
    }
}
