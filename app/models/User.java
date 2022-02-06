package models;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class User extends BaseModel{
	
	@Column
    private String email;
	
	@Column
    private String password;
	
	@Column
	private String bio;
	
	@OneToMany(cascade = CascadeType.ALL)
    private List<UUID> posts;

    public User(){
    	super();
    }

	public UUID getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<UUID> getPosts() {
		return posts;
	}

	public void setPosts(List<UUID> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", bio=" + bio + ", posts=" + posts + ", id=" + id
				+ "]";
	}
}
