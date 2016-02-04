package com.csuf.Model;

public class Blog {
	
	private int blogid;
	 private String userName;

	    private String title;

	    private String description;
	    
	    private String date;

	
		public int getBlogid() {
			return blogid;
		}

		public void setBlogid(int blogid) {
			this.blogid = blogid;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	    
	    

}
