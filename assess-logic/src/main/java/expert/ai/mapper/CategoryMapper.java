package expert.ai.mapper;

import org.springframework.stereotype.Component;

import ai.expert.nlapi.v2.model.Category;
import expert.ai.entity.DocCategorie;

@Component
public class CategoryMapper implements Mapper<Category, DocCategorie>{

	@Override
	public DocCategorie map(Category target) {
		DocCategorie categorie = new DocCategorie();
		categorie.setLabel(target.getLabel());
		categorie.setFrequency(target.getFrequency());
		categorie.setScore(target.getScore());
		return categorie;
	}

}
