package server.model;

public class APIResponse {

	private String content;

	public APIResponse() {}

	public APIResponse(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}
}