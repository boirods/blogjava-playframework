package controllers;

import java.util.UUID;

import models.MediaLink;
import models.Post;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http.Request;
import play.mvc.Result;

public class MediaLinkController extends Controller {
	MediaLink media;
	public MediaLinkController() {
	}
	
	public Result salva(Request novo) {
		media = new MediaLink();
		if(novo.body().asJson().has("post")) {
			if(novo.body().asJson().has("link"))
				media.setMediaLink(novo.body().asJson().get("link").textValue());
			if(novo.body().asJson().has("tipo"))
				media.setMediaType(novo.body().asJson().get("tipo").textValue());
			media.setPost(Post.find.byId(UUID.fromString(novo.body().asJson().get("post").textValue())));
			media.save();
			media.refresh();
			return ok(Json.toJson(media));
		} else {
			return ok("Não salvo, precisa de um post");
		}
	}
	
	public Result altera(Request novo, String id) {
		if(novo.body().asJson().has("post")) {
			media = MediaLink.find.byId(UUID.fromString(id));
			if(novo.body().asJson().has("link"))
				media.setMediaLink(novo.body().asJson().get("link").textValue());
			if(novo.body().asJson().has("tipo"))
				media.setMediaType(novo.body().asJson().get("tipo").textValue());
			media.setPost(Post.find.byId(UUID.fromString(novo.body().asJson().get("post").textValue())));
			media.save();
			media.refresh();
			return ok(Json.toJson(media));
		} else {
			media = MediaLink.find.byId(UUID.fromString(id));
			media.setMediaLink(novo.body().asJson().get("link").textValue());
			media.save();
			media.refresh();
			return ok(Json.toJson(media));
		}
	}
	public Result pegaTodos() {
		return ok(Json.toJson(MediaLink.find.all())); 
	}
	public Result pegaId(String id) {
		return ok(Json.toJson(MediaLink.find.byId(UUID.fromString(id))));
	}
	public Result apaga(String id) {
		return ok(Json.toJson(MediaLink.find.byId(UUID.fromString(id)).delete()));
	}
}
