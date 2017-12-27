package ee.bcs.koolitus.bean;

public class Blog {

	private int blogId;
	private String blogName;
	private String blogContent; 
	private PostState postState;
	private String tagsFromPost;

	public Blog() {
		super();
	}

	public Blog(int blogId, String blogName, String blogContent, String tagsFromPost) {//added String tagsFromPosts
		super();
		this.blogId = blogId;
		this.blogName = blogName;
		this.blogContent = blogContent;
		this.tagsFromPost = tagsFromPost; 
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public PostState getPostState() {
		return postState;
	}

	public void setPostState(PostState postState) {
		this.postState = postState;
	}

	public String getTagsFromPost() {
		return tagsFromPost;
	}

	public void setTagsFromPost(String tagsFromPost) {
		this.tagsFromPost = tagsFromPost;
	}


	

}