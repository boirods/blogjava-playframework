package controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http.*;
import play.mvc.Result;
import utils.UserUtils;

public class UserController extends Controller{
	User user;
	
	public UserController() {
	}
	
	public Result salva(Request novo) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		user = Json.fromJson(novo.body().asJson(), User.class);
		
		if(UserUtils.isValidPassword(user.getPassword()) && UserUtils.isValidEmail(user.getEmail())) {
			user.setPassword(UserUtils.criptographPassword(user.getPassword()));
			user.save();
			user.refresh();
			return ok(Json.toJson(user));
		} else {
			return ok(Json.toJson("Verifique se seu email possui ao menos um '@' ou um '.' e se sua senha possui ao menos um caractere especial "
					+ "e um numero!"));
		}
		
	}
	public Result altera(Request novo, String id) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		user = User.find.byId(UUID.fromString(id));
		User novoUser = Json.fromJson(novo.body().asJson(), User.class);
		if(novoUser.getBio() != null)
			user.setBio(novoUser.getBio());
		
		if(novoUser.getEmail() != null) {
			if(UserUtils.isValidEmail(novoUser.getEmail()))
				user.setEmail(novoUser.getEmail());
		}
		
		if(novoUser.getPassword() != null) {
			if(UserUtils.isValidPassword(novoUser.getPassword()))
				user.setPassword(UserUtils.criptographPassword(novoUser.getPassword()));
		}
		user.save();
		user.refresh();
		return ok(Json.toJson(user));
	}
	//ok
	public Result pegaTodos() {
		return ok(Json.toJson(User.find.all()));
	}
	//ok
	public Result pegaId(String id) {
		return ok(Json.toJson(User.find.byId(UUID.fromString(id))));
	}
	//a verificar
	public Result pegaEmail(String email) {
		user = User.findByEmail(email);
		return ok();
	}
	public Result apaga(String id) {
		return ok(Json.toJson(User.find.byId(UUID.fromString(id)).delete()));
	}
}
