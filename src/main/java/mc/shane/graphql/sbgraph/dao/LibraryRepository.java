package mc.shane.graphql.sbgraph.dao;

import mc.shane.graphql.sbgraph.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
