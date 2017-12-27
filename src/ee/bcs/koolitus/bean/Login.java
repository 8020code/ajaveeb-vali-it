package ee.bcs.koolitus.bean;

public class Login {
	private int userId;
	private String userNamePassword;  
	
	public Login(){
		super();
	}

	public Login(int userId, String userNamePassword) {
		super();
		this.userId= userId;
		this.userNamePassword = userNamePassword;
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserNamePassword() {
		return userNamePassword;
	}

	public void setUserNamePassword(String userNamePassword) {
		this.userNamePassword = userNamePassword;
	}

	@Override
	public String toString() {
		return "Login [userId=" + userId + ", userNamePassword=" + userNamePassword + "]";
	}

	
	
}

