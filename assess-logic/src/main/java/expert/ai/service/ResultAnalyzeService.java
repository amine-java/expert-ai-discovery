package expert.ai.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.expert.nlapi.exceptions.NLApiException;
import expert.ai.entity.DocCategorie;
import expert.ai.entity.ResultAnalyze;
import expert.ai.repository.DocEntityRepository;
import expert.ai.repository.DocSentimentRepository;
import expert.ai.repository.DocTopicRepository;
import expert.ai.repository.ResultAnalyzeRepository;

@Service
public class ResultAnalyzeService {

	@Autowired
	private AnalyzerService analyzerService;
	
	@Autowired
	private ResultAnalyzeRepository resultAnalyzeRepository;
	
	@Autowired
	private DocSentimentRepository docSentimentRepository;
	
	@Autowired
	private DocEntityRepository docEntityRepository;
	
	@Autowired
	private DocTopicRepository docTopicRepository ; 
	
	@Autowired
	private CategorizerService categorizerService;

	/**
	 * Creates a full analyze
	 * @param file
	 * @return ResultAnalyze
	 * @throws IOException 
	 * @throws NLApiException 
	 */
	@Transactional
	public ResultAnalyze createResultAnalyze(String text , String fileName) throws NLApiException, IOException {
		
		// Call discovery API
		ResultAnalyze result = analyzerService.analyzeFull(text);
		result.setFileName(fileName);
		result.setAnalyzeDate(LocalDate.now());
		
		// Retrieve Categories
		List<DocCategorie> categories = categorizerService.analyzeCategories(text);

		result.setCategories(categories);
		
		// Save to DB
		docSentimentRepository.save(result.getSentiment());
		docEntityRepository.saveAll(result.getEntities());
		docTopicRepository.saveAll(result.getTopics());
		resultAnalyzeRepository.save(result);

		return result;

	}

	/**
	 * Finds ResultAnalyze by its id
	 * @param id
	 * @return ResultAnalyze
	 */
	public ResultAnalyze findResultAnalyzeById(Long id) {
		return resultAnalyzeRepository.findById(id).get();
	}
}
