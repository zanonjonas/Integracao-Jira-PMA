package br.com.paxtecnologia.oAuth;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.api.client.auth.oauth.OAuthRsaSigner;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;

import br.com.paxtecnologia.beans.AuthBean;
import br.com.paxtecnologia.dao.AuthDao;
import br.com.paxtecnologia.util.OAuthUtils;

public class JiraOauthSearch {

	private static OAuthUtils util = new OAuthUtils();
	private static AuthDao dao = new AuthDao();

	public static String getJiraRest(String searchUrl)
			throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, SQLException, NamingException {
		OAuthParameters oauthParameters = null;
		String retorno = null;
		try {
			AuthBean authBean = dao.getProperties();
			oauthParameters = new OAuthParameters();
			OAuthRsaSigner signer = new OAuthRsaSigner();
			signer.privateKey = util.getPrivateKey(authBean.getPrivate_key());
			oauthParameters.signer = signer;
			oauthParameters.consumerKey = authBean.getConsumer_key();
			oauthParameters.token = authBean.getToken();
			oauthParameters.verifier = authBean.getVerifier();

			// Use OAuthParameters to access the desired Resource URL
			HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory(oauthParameters);
			GenericUrl genericUrl = new GenericUrl(searchUrl);
			HttpResponse response = requestFactory.buildGetRequest(genericUrl).execute();
			retorno = response.parseAsString();
		} catch (IOException e) {
			throw new IOException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new NoSuchAlgorithmException(e);
		} catch (InvalidKeySpecException e) {
			throw new InvalidKeySpecException(e);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return retorno;
	}
}
