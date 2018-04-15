package br.com.loanproject.commons.enumerate;

public enum RiskType {
    A("A"),
    B("B"),
    C("C");
	
	private String risk;
	
	RiskType(String risk){
		this.risk = risk;
	}
	
	public String risk() {
		return this.risk;
	}
}
