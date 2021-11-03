package expert.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import expert.ai.entity.DocCategorie;

@Repository
public interface DocCategorieRepository extends JpaRepository<DocCategorie, Long> {
}
