package expert.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import expert.ai.entity.DocSentiment;

@Repository
public interface DocSentimentRepository extends JpaRepository<DocSentiment, Long>{
}
