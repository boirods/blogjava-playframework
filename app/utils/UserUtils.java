package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import models.User;

public class UserUtils {
	
	public static boolean isValidEmail(String email) {
		if(email.contains(".") && email.contains("@")) {
			String[] emailDividido = email.split(".");
			for(int i = 0;i < emailDividido.length; i++) {
				if(emailDividido[i].length() >= 2) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean isValidPassword(String pass) {
		if(pass.matches("(?= . *?[#?! @$%^&*-])(?= . *?[0-9])(?= . *?[A-Z])(?= . *?[a-z])")) {
			return true;
		}
		return false;
	}
	
	public User criptographPassword(User usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest algoritmo=MessageDigest.getInstance("SHA");
		byte messageDigest[]=algoritmo.digest(usuario.getPassword().getBytes("UTF-8"));
		usuario.setPassword(messageDigest.toString());
		return usuario;
	}
	
}