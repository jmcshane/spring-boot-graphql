package mc.shane.graphql.sbgraph.dao;

import mc.shane.graphql.sbgraph.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
