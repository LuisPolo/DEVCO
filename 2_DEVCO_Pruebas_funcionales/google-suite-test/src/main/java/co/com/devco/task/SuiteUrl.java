package co.com.devco.task;

public enum  SuiteUrl {
	
	GOOGLE("https://www.google.com");
	
	private String url;
	
	SuiteUrl (String url){
		this.url = url;
	}
	
	public String url() {
		return this.url;
	}

}
