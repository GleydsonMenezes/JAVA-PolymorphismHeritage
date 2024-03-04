package entities;

public class NaturalPerson extends Person {

	private Double healthCost;
	
	
	public NaturalPerson() {
		super();
	}
	
	public NaturalPerson(String name, Double annualIncome, Double healthCost) {
		super(name, annualIncome);
		this.healthCost = healthCost;
	}
	
	
	public Double getHealthCost() {
		return healthCost;
	}

	public void setHealthCost(Double healthCost) {
		this.healthCost = healthCost;
	}

	@Override
	public Double taxCalc() {
		if (super.getAnnualIncome() > 20000.00) {
			return (super.getAnnualIncome() * 0.25) - (healthCost * 0.50);
		}else {
			return (super.getAnnualIncome() * 0.15) - (healthCost * 0.50);
		}
	}


	
	
}
