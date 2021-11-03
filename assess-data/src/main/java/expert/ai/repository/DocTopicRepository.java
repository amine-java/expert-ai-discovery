package expert.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import expert.ai.entity.DocTopic;

@Repository
public interface DocTopicRepository extends JpaRepository<DocTopic, Long> {
}
