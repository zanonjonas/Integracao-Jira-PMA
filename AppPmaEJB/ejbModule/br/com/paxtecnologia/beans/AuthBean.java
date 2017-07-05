package br.com.paxtecnologia.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authBean")
public class AuthBean {
	private String consumer_key;
	private String private_key;
	private String public_key;
	private String temp_token;
	private String temp_token_secret;
	private String token;
	private String token_secret;
	private String verifier;

	public String getConsumer_key() {
		return consumer_key;
	}

	public void setConsumer_key(String consumer_key) {
		this.consumer_key = consumer_key;
	}

	public String getPrivate_key() {
		return private_key;
	}

	public void setPrivate_key(String private_key) {
		this.private_key = private_key;
	}

	public String getPublic_key() {
		return public_key;
	}

	public void setPublic_key(String public_key) {
		this.public_key = public_key;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken_secret() {
		return token_secret;
	}

	public void setToken_secret(String token_secret) {
		this.token_secret = token_secret;
	}

	public String getVerifier() {
		return verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

	public String getTemp_token() {
		return temp_token;
	}

	public void setTemp_token(String temp_token) {
		this.temp_token = temp_token;
	}

	public String getTemp_token_secret() {
		return temp_token_secret;
	}

	public void setTemp_token_secret(String temp_token_secret) {
		this.temp_token_secret = temp_token_secret;
	}

}
