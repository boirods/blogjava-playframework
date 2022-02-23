package controllers;

import java.util.UUID;

import models.Post;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http.Request;
import play.mvc.Result;
import utils.PostUtils;

public class PostController extends Controller {
	Post post;
	public PostController() {
	}
	
	public Result salva(Request novo) {
		post = Json.fromJson(novo.body().asJson(), Post.class);
		if(novo.body().asJson().has("usuário")) {
			post.setUsuario(User.find.byId(UUID.fromString(novo.body().asJson().get("usuário").textValue())));
			post.setTitulo(PostUtils.urlFriendler4Titles(post.getTitulo()));
			post.save();
			post.refresh();
			return ok(Json.toJson(post));
		} else {
			return notFound("User not found!");
		}
	}
	public Result altera(Request novo, String id) {
		post = Post.find.byId(UUID.fromString(id));
		Post recebido = Json.fromJson(novo.body().asJson(), Post.class);
		if(novo.body().asJson().has("usuário")) {
			post.setUsuario(User.find.byId(UUID.fromString(
					novo.body().asJson().get("usuário").textValue())));
		}
		
		if(novo.body().asJson().has("titulo")) {
			post.setTitulo(PostUtils.urlFriendler4Titles(recebido.getTitulo()));
		}
		
		if(novo.body().asJson().has("conteudo")) {
			post.setConteudo(recebido.getConteudo());
		}
		
		if(novo.body().asJson().has("upvotes")) {
			post.setUpvotes(recebido.getUpvotes());
		}
		
		if(novo.body().asJson().has("downvotes")) {
			post.setDownvotes(recebido.getDownvotes());
		}
		
		post.setUpdatingDate();
		post.save();
		post.refresh();
		return ok(Json.toJson(post));
	}
	public Result pegaTodos() {
		return ok(Json.toJson(Post.find.all()));
	}
	
	public Result pegaId(String id) {
		return ok(Json.toJson(Post.find.byId(UUID.fromString(id))));
	}
	
	public Result pegaTitulo(String titulo) {
		return ok(Json.toJson(Post.findByTitulo(titulo)));
	}
	
	public Result apaga(String id) {
		return ok(Json.toJson(Post.find.byId(UUID.fromString(id)).delete()));
	}
}
