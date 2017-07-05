package br.com.paxtecnologia.util;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import com.google.api.client.auth.oauth.OAuthCredentialsResponse;
import com.google.api.client.auth.oauth.OAuthRsaSigner;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;

import br.com.paxtecnologia.beans.AuthBean;
import br.com.paxtecnologia.oAuth.PaxOAuthGetAccessToken;
import br.com.paxtecnologia.oAuth.PaxOAuthGetTemporaryToken;

public class OAuthUtils {

	public OAuthCredentialsResponse getToken(AuthBean props)
			throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
		PaxOAuthGetTemporaryToken getTemporaryToken = new PaxOAuthGetTemporaryToken(JiraOAuthUrls.TOKEN_SERVER_URL);

		getTemporaryToken.consumerKey = props.getConsumer_key();
		getTemporaryToken.signer = getOAuthRsaSigner(props.getPrivate_key());
		getTemporaryToken.transport = new ApacheHttpTransport();
		getTemporaryToken.callback = "oob";

		return getTemporaryToken.execute();
	}

	public OAuthCredentialsResponse getToken(AuthBean props, String verifier_code)
			throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		PaxOAuthGetAccessToken accessToken = new PaxOAuthGetAccessToken(JiraOAuthUrls.ACCESS_TOKEN_URL);

		accessToken.consumerKey = props.getConsumer_key();
		accessToken.signer = getOAuthRsaSigner(props.getPrivate_key());
		accessToken.transport = new ApacheHttpTransport();
		accessToken.verifier = verifier_code;
		accessToken.temporaryToken = props.getTemp_token(); 
		
		return accessToken.execute();
	}

	public OAuthRsaSigner getOAuthRsaSigner(String privKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
		OAuthRsaSigner signer = new OAuthRsaSigner();
		signer.privateKey = getPrivateKey(privKey);
		return signer;
	}

	public PrivateKey getPrivateKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] privateBytes = Base64.decodeBase64(key);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePrivate(keySpec);
	}
}
