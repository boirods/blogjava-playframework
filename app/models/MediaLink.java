package models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "media")
public class MediaLink extends BaseModel{
	
	@Column
	private String multimediaLink;
	
	@Column
	private Post post;
	
	public MediaLink() {
		super();
	}

	@Override
	public UUID getId() {
		return this.id;
	}

	public String getImageLink() {
		return multimediaLink;
	}

	public void setImageLink(String imageLink) {
		this.multimediaLink = imageLink;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	
}
