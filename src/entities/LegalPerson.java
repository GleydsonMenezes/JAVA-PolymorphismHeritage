package entities;

public class LegalPerson extends Person{
	
	private Integer numberEmployees;

	
	public LegalPerson(String name, Double annualIncome, Integer numberEmployees) {
		super(name, annualIncome);
		this.numberEmployees = numberEmployees;
	}

	public Integer getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(Integer numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	@Override
	public Double taxCalc() {
		if (numberEmployees > 10) {
			return super.getAnnualIncome() * 0.14;
		}else {
			return super.getAnnualIncome() * 0.16;
		}
	}
	
	
	
	
			
}
