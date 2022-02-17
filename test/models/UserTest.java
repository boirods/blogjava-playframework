package models;

import org.junit.Test;
import models.UserTest;
import utils.UserUtils;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class UserTest {
	@Test
	public void usuarioTestes() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		User user = new User();
		user.getId();
		user.setBio("Este é um teste da classe usuario.");
		user.setEmail("teste@teste.com.br");
		user.setPassword("teste123A#$");
		
		assertTrue("IsValid Email.", UserUtils.isValidEmail(user.getEmail()));
		assertTrue("IsValid Pass.", UserUtils.isValidPassword(user.getPassword()));
	}
}
