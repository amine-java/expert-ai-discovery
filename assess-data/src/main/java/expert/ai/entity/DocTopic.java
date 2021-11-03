package expert.ai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DocTopic {

	@Id
	@GeneratedValue
	private Long id; 
	
	private String label ; 
	
	private double score;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Long getId() {
		return id;
	}
	
	
}
