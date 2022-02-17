package models;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.ebean.DB;
import io.ebean.Finder;
import utils.UserUtils;

/**
 * Classe que representa um autor no aplicativo de blog feito em java e sobre java.
 * @author rodrigo
 *
 */
@Entity(name = "user")
public class User extends BaseModel{
	/**
	 * utilizado para recuperar um usuario no banco de dados.
	 */
	public static final Finder<UUID, User> find=new Finder<UUID, User>(User.class);
	
	@Column
    private String email;
	
	@Column
    private String password;
	
	@Column
	private String bio;
	
	/**
	 * Lista de posts do usuário.
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference("usuarios")
    private List<Post> posts;

	/**
	 * método construtor que usa o construtor da classe base.
	 */
    public User(){
    	super();
    }
    
    @Override
	public UUID getId() {
		return id;
	}
    
    /**
     * Método para recuperar o email do usuário
     * @return email do usuário em formato String.
     */
	public String getEmail() {
		return email;
	}

	/**
	 * Método para alterar o email do usuário.
	 * @param email que deverá ser alterado.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método para recuperar a senha do usuário
	 * @return a senha do usuário
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Método que altera a senha do usuário
	 * @param password a senha do usuário em formato String.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Método para recuperar a biografia do usuário.
	 * @return a biografiado usuário em formato String.
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * Método para alterar a biografia do usuário.
	 * @param bio que deverá ser inserida no usuário
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * Método que recupera a lista de posts do usuario.
	 * @return a lista de posts do usuário.
	 */
	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * Lista de posts a ser alterada para o usuário.
	 * @param posts a serem alterados para o usuário.
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	/**
	 * Método para recuperar o usuário pelo email informado como parametro.
	 * @param email a ser procurado
	 * @return usuario encontrado 
	 */
	public static User findByEmail(String email) {
		new User();
		User user = (User) DB.find(User.class).where().eq("email", email);
		return user;
	}
	
	/**
	 * Conversão de usuário para string.
	 */
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "passwordDecrypted=" + UserUtils.decriptographPassword(password) +", bio=" + bio + ", posts=" + posts + ", id=" + id
				+ "]";
	}
}
