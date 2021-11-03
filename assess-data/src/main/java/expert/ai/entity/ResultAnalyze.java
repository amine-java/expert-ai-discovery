package expert.ai.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ResultAnalyze {
	
	@Id
	@GeneratedValue
	private Long id; 
	
	private String fileName; 
	
	private LocalDate analyzeDate; 
	
	@OneToMany
	private List<DocCategorie> categories ; 

	@OneToMany
	private List<DocEntity> entities;
	
	@OneToOne
	private DocSentiment sentiment ; 
	
	@OneToMany
	private List<DocTopic> topics ;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LocalDate getAnalyzeDate() {
		return analyzeDate;
	}

	public void setAnalyzeDate(LocalDate analyzeDate) {
		this.analyzeDate = analyzeDate;
	}

	public List<DocCategorie> getCategories() {
		return categories;
	}

	public void setCategories(List<DocCategorie> categories) {
		this.categories = categories;
	}

	public List<DocEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<DocEntity> entities) {
		this.entities = entities;
	}

	public List<DocTopic> getTopics() {
		return topics;
	}

	public void setTopics(List<DocTopic> topics) {
		this.topics = topics;
	}

	public Long getId() {
		return id;
	}

	public DocSentiment getSentiment() {
		return sentiment;
	}

	public void setSentiment(DocSentiment sentiment) {
		this.sentiment = sentiment;
	} 
	
}
