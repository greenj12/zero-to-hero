package server.model;

public class APIRequest {

	private String content;

	public APIRequest() {}

	public APIRequest(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}
}