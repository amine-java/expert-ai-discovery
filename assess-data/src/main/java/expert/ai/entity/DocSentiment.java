package expert.ai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DocSentiment {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private double overall; 
	
	private double negativity;
	
	private double positivity;

	public double getOverall() {
		return overall;
	}

	public void setOverall(double overall) {
		this.overall = overall;
	}

	public double getNegativity() {
		return negativity;
	}

	public void setNegativity(double negativity) {
		this.negativity = negativity;
	}

	public double getPositivity() {
		return positivity;
	}

	public void setPositivity(double positivity) {
		this.positivity = positivity;
	}

	public Long getId() {
		return id;
	}
	
	
	

}
