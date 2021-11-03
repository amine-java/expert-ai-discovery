package expert.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import expert.ai.entity.DocEntity;

@Repository
public interface DocEntityRepository extends JpaRepository<DocEntity, Long>{
}
