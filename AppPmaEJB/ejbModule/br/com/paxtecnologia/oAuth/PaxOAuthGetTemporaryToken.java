package br.com.paxtecnologia.oAuth;

import com.google.api.client.auth.oauth.OAuthGetTemporaryToken;

public class PaxOAuthGetTemporaryToken extends OAuthGetTemporaryToken {

	public PaxOAuthGetTemporaryToken(String authorizationServerUrl) {
		super(authorizationServerUrl);
		this.usePost = true;
	}
}
