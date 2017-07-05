package br.com.paxtecnologia.oAuth;

import com.google.api.client.auth.oauth.OAuthGetAccessToken;

public class PaxOAuthGetAccessToken extends OAuthGetAccessToken {

	public PaxOAuthGetAccessToken(String authorizationServerUrl) {
		super(authorizationServerUrl);
		this.usePost = true;
	}
}
