package model;

public class item {
	
	private String title;
	private String url;
	private String[] seo;
	private String description;
	public item(String title, String url, String[] seo, String description) {
		super();
		this.title = title;
		this.url = url;
		this.seo = seo;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String[] getSeo() {
		return seo;
	}
	public void setSeo(String[] seo) {
		this.seo = seo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
