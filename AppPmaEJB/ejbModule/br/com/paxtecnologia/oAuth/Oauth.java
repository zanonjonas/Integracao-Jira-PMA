package br.com.paxtecnologia.oAuth;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.ejb.Stateless;

import com.google.api.client.auth.oauth.OAuthAuthorizeTemporaryTokenUrl;
import com.google.api.client.auth.oauth.OAuthCredentialsResponse;

import br.com.paxtecnologia.beans.AuthBean;
import br.com.paxtecnologia.dao.AuthDao;
import br.com.paxtecnologia.util.JiraOAuthUrls;
import br.com.paxtecnologia.util.OAuthUtils;

@Stateless
public class Oauth {

	private AuthDao authDao = new AuthDao();
	private static OAuthUtils oAuthUtils = new OAuthUtils();

	public String getTempToken() {
		String retorno = null;
		try {

			AuthBean properties = authDao.getProperties();
			OAuthCredentialsResponse response = oAuthUtils.getToken(authDao.getProperties());

			properties.setToken(response.token);
			properties.setToken_secret(response.tokenSecret);

			OAuthAuthorizeTemporaryTokenUrl accessTempToken = new OAuthAuthorizeTemporaryTokenUrl(
					JiraOAuthUrls.AUTHENTICATE_URL);
			accessTempToken.temporaryToken = response.token;
			String authUrl = accessTempToken.build();

			retorno = (("Token de request adquirido! \nVá em " + authUrl
					+ " para autorizar-lo. Após autorizar, acesse a api de captura do Token de Acesso. pax/api/v1/processamento/auth/access_token/{verification_code}"));

			authDao.saveTempTokenProperties(properties);

		} catch (IOException e) {
			e.printStackTrace();
			retorno = "Error: " + (e.getMessage() + " " + e.getCause());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			retorno = "Error: " + (e.getMessage());
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
			retorno = "Error: " + (e.getMessage() + " " + e.getCause());
		} catch (Exception e) {
			e.printStackTrace();
			retorno = "Error: " + (e.getMessage() + " " + e.getCause());
		}
		return retorno;
	}

	public String getAccessToken(String verifier_code) {
		String retorno = null;
		try {

			AuthBean props = authDao.getProperties();

			OAuthCredentialsResponse accessTokenResponse = oAuthUtils.getToken(props, verifier_code);

			if (accessTokenResponse.token != null) {

				System.out.println("token_secret: " + accessTokenResponse.tokenSecret);
				props.setToken_secret(accessTokenResponse.tokenSecret);
				System.out.println("consumer_key: " + props.getConsumer_key());
				System.out.println("token: " + accessTokenResponse.token);
				props.setToken(accessTokenResponse.token);
				System.out.println("verifier: " + verifier_code);
				props.setVerifier(verifier_code);

				retorno = ("Access_Token: " + accessTokenResponse.token);

				authDao.saveAccess(props);
			} else {
				retorno = ("Error: Não houve retorno de token do jira!");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			retorno = "NoSuchAlgorithmException: " + (e.getMessage()) + " " + e.getCause();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
			retorno = "InvalidKeySpecException: " + (e.getMessage() + " " + e.getCause());
		} catch (IOException e) {
			e.printStackTrace();
			retorno = "IOException: " + (e.getMessage() + " " + e.getCause());
		} catch (Exception e) {
			e.printStackTrace();
			retorno = "Exception: " + (e.getMessage() + " " + e.getCause());
		}
		return retorno;
	}
}
