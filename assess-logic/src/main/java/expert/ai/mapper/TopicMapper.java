package expert.ai.mapper;

import org.springframework.stereotype.Component;

import ai.expert.nlapi.v2.model.DocumentTopic;
import expert.ai.entity.DocTopic;

@Component
public class TopicMapper implements Mapper<DocumentTopic, DocTopic>{

	@Override
	public DocTopic map(DocumentTopic target) {
		DocTopic docTopic = new DocTopic();
		docTopic.setLabel(target.getLabel());
		docTopic.setScore(target.getScore());
		return docTopic;
	}

}
