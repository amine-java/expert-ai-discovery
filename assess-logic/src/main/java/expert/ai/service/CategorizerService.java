package expert.ai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.expert.nlapi.exceptions.NLApiException;
import ai.expert.nlapi.v2.cloud.Categorizer;
import ai.expert.nlapi.v2.message.CategorizeResponse;
import expert.ai.entity.DocCategorie;
import expert.ai.mapper.CategoryMapper;
import expert.ai.repository.DocCategorieRepository;

@Service
public class CategorizerService {

	@Autowired
	private Categorizer categorizer; 
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private DocCategorieRepository docCategorieRepository;
	
	/**
	 * Method that performs the categories-analyze of the text provided in parameter 
	 * @param text
	 * @return List<DocCategorie>
	 * @throws NLApiException
	 */
	public List<DocCategorie> analyzeCategories(String text) throws NLApiException {
		
		// Call Discovery service
		CategorizeResponse response = categorizer.categorize(text);
		// Map Categories
		List<DocCategorie> categories = categoryMapper.mapAll(response.getData().getCategories());
		// Save in DB
		docCategorieRepository.saveAll(categories);
		
		return categories;
	}
	
	
}
