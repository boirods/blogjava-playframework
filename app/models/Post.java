package models;

import java.util.List;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Post extends BaseModel {
	@Column
	private String titulo;
	
	@Column
	private String conteudo;
	
	@Column
	private int upvotes;
	
	@Column
	private int downvotes;
	
	@ManyToOne
	private User usuario;
	
	@ElementCollection
	@CollectionTable(name = "Links", joinColumns = @JoinColumn(name = "id"))
	private List<MediaLink> imageLinks;
	
	public Post() {
		super();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public List<MediaLink> getImageLinks() {
		return this.imageLinks;
	}

	public void setImageLinks(List<MediaLink> links) {
		this.imageLinks = links;
	}

	public int getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}

	public int getDownvotes() {
		return downvotes;
	}

	public void setDownvotes(int downvotes) {
		this.downvotes = downvotes;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	@Override
	public UUID getId() {
		return this.id;
	}
	
}
