package models;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.ebean.Finder;

@Entity(name = "media")
public class MediaLink extends BaseModel{
	public static final Finder<UUID, MediaLink> find = new Finder<UUID, MediaLink>(MediaLink.class);
	
	@Column
	private String multimediaLink;
	
	@Column
	private String mediaType;
	
	@Column
	@ManyToOne
	@JsonBackReference
	private Post post;
	
	public MediaLink() {
		super();
	}

	@Override
	public UUID getId() {
		return this.id;
	}

	public String getMediaLink() {
		return multimediaLink;
	}

	public void setMediaLink(String mediaLink) {
		this.multimediaLink = mediaLink;
	}
	
	public String getMediaType() {
		return mediaType;
	}
	
	public void setMediaType(String mediaType) {
		this.mediaType=mediaType;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}