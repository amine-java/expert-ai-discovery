package expert.ai.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.expert.nlapi.exceptions.NLApiException;
import ai.expert.nlapi.v2.cloud.Analyzer;
import ai.expert.nlapi.v2.message.AnalyzeResponse;
import expert.ai.entity.ResultAnalyze;
import expert.ai.mapper.EntityMapper;
import expert.ai.mapper.SentimentMapper;
import expert.ai.mapper.TopicMapper;

@Service
public class AnalyzerService {

	@Autowired
	private Analyzer analyzer;

	@Autowired
	private EntityMapper entityMapper ; 
	
	@Autowired
	private TopicMapper topicMapper; 
	
	@Autowired
	private SentimentMapper sentimentMapper ; 
	
	
	/**
	 * Method that performs a full analyze of the text provided in parameter
	 * @param text
	 * @return ResultAnalyze 
	 * @throws NLApiException
	 * @throws IOException
	 */
	public ResultAnalyze analyzeFull(String text) throws NLApiException, IOException {
		ResultAnalyze result = new ResultAnalyze();
		
		// Call Discovery API
		AnalyzeResponse response = analyzer.analyze(text);
		// Entities
		result.setEntities(entityMapper.mapAll(response.getData().getEntities()));
		// Topics
		result.setTopics(topicMapper.mapAll(response.getData().getTopics()));
		// Sentiment
		result.setSentiment(sentimentMapper.map(response.getData().getSentiment()));
		
		return result;
	}

}
