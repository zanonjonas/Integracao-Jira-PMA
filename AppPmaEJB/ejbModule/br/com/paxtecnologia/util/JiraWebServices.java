package br.com.paxtecnologia.util;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;

import br.com.paxtecnologia.beans.AuthBean;
import br.com.paxtecnologia.dao.AuthDao;

public class JiraWebServices {
	
	private AuthDao authDao = new AuthDao();
	
	public HttpResponse callJira(String url) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, SQLException, NamingException {
		// Use OAuthParameters to access the desired Resource URL
		OAuthUtils oAuthUtils = new OAuthUtils();
		AuthBean props = authDao.getProperties();
		OAuthParameters oauthParameters = new OAuthParameters();
		oauthParameters.signer = oAuthUtils.getOAuthRsaSigner(props.getPrivate_key());
		oauthParameters.consumerKey = props.getConsumer_key();
		oauthParameters.token = props.getToken();
		oauthParameters.verifier = props.getVerifier();
		HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory(oauthParameters);
		GenericUrl genericUrl = new GenericUrl("url");
		return requestFactory.buildGetRequest(genericUrl).execute();
	}
}
