package ee.bcs.koolitus.bean;

public class SearchPost {
		
	private int blogId;
	private String blogContent; 
	
	public SearchPost() {
		super();
	}
	
	public SearchPost(int blogId, String blogContent) {
		super();
		this.blogId = blogId;
		this.blogContent = blogContent; 
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	@Override
	public String toString() {
		return "SearchPost [blogId=" + blogId + ", blogContent=" + blogContent + "]";
	}

	



}
