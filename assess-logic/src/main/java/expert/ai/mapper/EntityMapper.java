package expert.ai.mapper;

import org.springframework.stereotype.Component;

import ai.expert.nlapi.v2.model.Entity;
import expert.ai.entity.DocEntity;

@Component
public class EntityMapper implements Mapper<Entity, DocEntity> {

	public DocEntity map(Entity target) {
		DocEntity docEntity = new DocEntity();
		docEntity.setLemma(target.getLemma());
		docEntity.setRelevance(target.getRelevance());
		docEntity.setType(target.getType().getDescription());
		return docEntity;
	}

	
}
