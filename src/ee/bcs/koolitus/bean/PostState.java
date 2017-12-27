package ee.bcs.koolitus.bean;

public class PostState {
	private int postStateId;
	private String postStateName;

	public PostState() {
	}

	public PostState(int postStateId) {
		this.postStateId = postStateId;
	}
	
	public PostState(int postStateId, String postStateName) {
		super();
		this.postStateId = postStateId;
		this.postStateName = postStateName;
	}
	
	public int getPostStateId() {
		return postStateId;
	}

	public void setPostStateId(int postStateId) {
		this.postStateId = postStateId;
	}

	public String getPostStateName() {
		return postStateName;
	}

	public void setPostStateName(String postStateName) {
		this.postStateName = postStateName;
	}

	@Override
	public String toString() {
		return "PostState [postStateId=" + postStateId + ", postStateName=" + postStateName + "]";
	
	}

}
