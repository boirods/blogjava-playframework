package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import models.User;

public class UserUtils {
	
	public static boolean isValidEmail(String email) {
		if(email.contains("@")) {
			String aposArroba = email.split("@")[1];
			if(aposArroba.contains("."))
				return true;
		}
		return false;
	}
	
	public static boolean isValidPassword(String pass) {
		if(pass.length() > 5) {
			if(pass.contains("!") || pass.contains("@") || pass.contains("#") || pass.contains("$") || pass.contains("%") || pass.contains("&")) {
				if((pass.indexOf('0') == -1) || (pass.indexOf('1') == -1) || (pass.indexOf('2') == -1) ||
				   (pass.indexOf('3') == -1) || (pass.indexOf('4') == -1) || (pass.indexOf('5') == -1) ||
				   (pass.indexOf('6') == -1) || (pass.indexOf('7') == -1) || (pass.indexOf('8') == -1) ||
				   (pass.indexOf('9') == -1))
				return true;
			}
		}
		return false;
	}
	
	public static String criptographPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest algoritmo=MessageDigest.getInstance("SHA");
		byte messageDigest[]=algoritmo.digest(password.getBytes("UTF-8"));
		return messageDigest.toString();
	}
	
	public static String decriptographPassword(String password) {
		StringBuilder sb = new StringBuilder();
		for(byte b : password.getBytes())
			sb.append(String.format("%02x", b));
		return sb.toString();
	}
}