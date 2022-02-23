package models;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.ebean.DB;
import io.ebean.Finder;

/**
 * Entidade que representa um post na aplicação de blog java.
 * @author rodrigo
 *
 */
@Entity(name = "user")
public class Post extends BaseModel {
	
	public static final Finder<UUID, Post> find=new Finder<UUID, Post>(Post.class);
	
	/**
	 * Representa o título de um post na aplicação.
	 */
	@Column
	private String titulo;
	
	/**
	 * Representa o conteudo do post na aplicação.
	 */
	@Column
	private String conteudo;
	
	/**
	 * Representa a quantidade de "likes" (ou mais conhecido como "Gostei") que o post teve.
	 */
	@Column
	private int upvotes;
	
	/**
	 * representa a quantidade de "dislike" (ou mais conhecido como "Não gostei") que o post teve.
	 */
	@Column
	private int downvotes;
	
	@Column
	private String updatingDate;
	
	/**
	 * Representa o usuário que fez a postagem na aplicação
	 */
	@ManyToOne
	@JsonBackReference("usuarios")
	private User usuario;
	
	@OneToMany
	@JsonManagedReference
	private List<MediaLink> imageLinks;
	
	/**
	 * Método construtor que pega o id gerado na classe base.
	 */
	public Post() {
		super();
		updatingDate = LocalDateTime.now().toString();
	}

	/**
	 * Recupera o titulo de um post na aplicação.
	 * @return título do post.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Altera o título do post na aplicação.
	 * @param titulo a ser inserido.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Recupera um conteudo do post na aplicação.
	 * @return um conteudo já gerado na aplicação.
	 */
	public String getConteudo() {
		return conteudo;
	}
	
	/**
	 * Altera o conteudo do post na aplicação.
	 * @param conteudo a ser alterado
	 */
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	/**
	 * Recupera a lista de links multimidia usado no post da aplicação.
	 * @return lista de links multimidia.
	 */
	public List<MediaLink> getImageLinks() {
		return this.imageLinks;
	}

	/**
	 * Altera a lista de links multimidia usados no post da apĺicação.
	 * @param links multimidia novos a ser inserido no post.
	 */
	public void setImageLinks(List<MediaLink> links) {
		this.imageLinks = links;
	}

	/**
	 * Recupera a quantidade upvotes ou mais conhecido como "Like" do post.
	 * @return um numero inteiro que representa a quantidade de upvotes (likes).
	 */
	public int getUpvotes() {
		return upvotes;
	}

	/**
	 * Altera a quantidade de upvotes ou mais conhecido como "Like" do post.
	 * @param upvotes nova quantidade de upvotes a ser inserida no post.
	 */
	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}

	/**
	 * Recupera a quantidade downvotes ou mais conhecido como "Dislike" do post.
	 * @return um numero inteiro que representa a quantidade de downvotes (dislikes).
	 */
	public int getDownvotes() {
		return downvotes;
	}

	/**
	 * Altera a quantidade de downvotes ou mais conhecido como "Dislike" do post.
	 * @param downvotes nova quantidade de downvotes a ser inserida no post.
	 */
	public void setDownvotes(int downvotes) {
		this.downvotes = downvotes;
	}

	/**
	 * Recupera o usuario que realizou a publicação do post.
	 * @return usuário que realizou a publicação do post.
	 */
	public User getUsuario() {
		return usuario;
	}

	/**
	 * Se o escritor quiser alterar o dono da publicação. Ainda a verificar se permanecerá no sistema (acredito que não).
	 * @param usuario novo usuário que receberá a publicação do post.
	 */
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Pega a data da ultima atualização do post.
	 * @return data da ultima atualização
	 */
	public String getUpdatingDate() {
		return this.updatingDate;
	}
	/**
	 * Altera a data de atualização do post.
	 * @param updatingDate data da atualização do post (localtime.now)
	 */
	public void setUpdatingDate() {
		this.updatingDate = LocalDateTime.now().toString();
	}
	
	public static List<Post> findByTitulo(String titulo) {
		@SuppressWarnings("unchecked")
		List<Post> posts = (List<Post>) DB.find(Post.class).where().like("titulo", "%"+titulo+"%").findList();
		return posts;
	}

	@Override
	public UUID getId() {
		return this.id;
	}
	
}
