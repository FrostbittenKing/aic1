package aic.domain;

public enum Rating {
	AAA("AAA"),
	AAPlus("AAPlus"),
	AA("AA"),
	AAMinus("AAMinus"),
	APlus("APlus"),
	A("A"),
	AMinus("AMinus"),
	Defaulting("Defaulting");
	
	String rating = null;
	private Rating(String rating){
		this.rating = rating;
	}
	
	@Override
	public String toString(){
		return rating;
	}
}
