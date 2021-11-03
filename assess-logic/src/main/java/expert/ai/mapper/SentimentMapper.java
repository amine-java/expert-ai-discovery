package expert.ai.mapper;

import org.springframework.stereotype.Component;

import ai.expert.nlapi.v2.model.Sentiment;
import expert.ai.entity.DocSentiment;

@Component
public class SentimentMapper implements Mapper<Sentiment, DocSentiment> {

	@Override
	public DocSentiment map(Sentiment target) {
		DocSentiment docSentiment = new DocSentiment();
		docSentiment.setNegativity(target.getNegativity());
		docSentiment.setOverall(target.getOverall());
		docSentiment.setPositivity(target.getPositivity());
		return docSentiment;
	}

}
