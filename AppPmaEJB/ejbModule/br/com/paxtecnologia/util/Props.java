package br.com.paxtecnologia.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

import com.google.api.client.util.Base64;

public class Props {

	private static Props instance;
	private String auth;

	private Props() {
		InputStream input = null;
		try {
			input = getClass().getClassLoader().getResourceAsStream("META-INF/auth.properties");
			System.out.println("Lendo arquivo de configurações... ");
			if (input == null) {
				System.out.println("Não foi possivel carregar o arquivo de propriedades!");
			} else {
				// load a properties file
				Properties prop = new Properties();
				prop.load(input);
				String authString = prop.getProperty("email") + ":" + prop.getProperty("senha");
				byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
				this.auth = new String(authEncBytes);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public synchronized static Props getInstance() {
		if (instance == null) {
			instance = new Props();
		}
		return instance;
	}

	public void setProps(Map<String, String> properties, String fileName) throws IOException {
		Properties prop = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream("META-INF/temp_token.properties");
			for (Map.Entry<String, String> entry : properties.entrySet()) {
				prop.setProperty(entry.getKey(), entry.getValue());
			}
			prop.store(output, null);
		} catch (IOException io) {
			throw new IOException(io);
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public void setAuth(String auth) {
		Properties prop = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream("META-INF/auth.properties");
			// set the properties value
			prop.setProperty("jira_home", "https://paxtecnologia.atlassian.net/");
			prop.setProperty("consumer_key", auth);
			prop.store(output, null);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public String getAuth() {
		return auth;
	}
}
