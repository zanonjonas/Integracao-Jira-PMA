package br.com.paxtecnologia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import br.com.paxtecnologia.beans.AuthBean;

public class AuthDao {

	private Datasource conn;

	public AuthBean getProperties() throws SQLException, NamingException {
		AuthBean retorno = null;
		conn = new Datasource();
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT * FROM paxrel.FP_TOKEN";
			pstmt = conn.getPreparedStatement(sql);
			ResultSet result = conn.executaQuery(pstmt);

			retorno = new AuthBean();
			while (result.next()) {
				try {
					retorno.setConsumer_key(result.getString("consumer_key"));
				} catch (SQLException e) {
				}

				try {
					retorno.setPrivate_key(result.getString("private_key"));
				} catch (SQLException e) {
				}

				try {
					retorno.setPublic_key(result.getString("public_key"));
				} catch (SQLException e) {
				}

				try {
					retorno.setToken(result.getString("token"));
				} catch (SQLException e) {
				}

				try {
					retorno.setToken_secret(result.getString("token_secret"));
				} catch (SQLException e) {
				}
				
				try {
					retorno.setTemp_token(result.getString("temp_token"));
				} catch (SQLException e) {
				}

				try {
					retorno.setTemp_token_secret(result.getString("temp_token_secret"));
				} catch (SQLException e) {
				}

				try {
					retorno.setVerifier(result.getString("verifier"));
				} catch (SQLException e) {
				}

			}
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SQLException(e);
				}
			}
		}
		return retorno;
	}

	public void saveTempTokenProperties(AuthBean properties) throws SQLException, NamingException {
		conn = new Datasource();
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE paxrel.FP_TOKEN" + " SET temp_token = ?";
			pstmt = conn.getPreparedStatement(sql);
			pstmt.setString(1, properties.getToken());
			conn.executaUpdate(pstmt);

			String sql2 = "UPDATE paxrel.FP_TOKEN" + " SET temp_token_secret = ?";
			pstmt = conn.getPreparedStatement(sql2);
			pstmt.setString(1, properties.getToken_secret());
			conn.executaUpdate(pstmt);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SQLException(e);
				}
			}
		}
	}

	public void saveAccess(AuthBean properties) throws SQLException, NamingException {
		conn = new Datasource();
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE paxrel.FP_TOKEN" + " SET token = ?";
			pstmt = conn.getPreparedStatement(sql);
			pstmt.setString(1, properties.getToken());
			conn.executaUpdate(pstmt);

			sql = "UPDATE paxrel.FP_TOKEN" + " SET token_secret = ?";
			pstmt = conn.getPreparedStatement(sql);
			pstmt.setString(1, properties.getToken_secret());
			conn.executaUpdate(pstmt);

			sql = "UPDATE paxrel.FP_TOKEN" + " SET verifier = ?";
			pstmt = conn.getPreparedStatement(sql);
			pstmt.setString(1, properties.getVerifier());
			conn.executaUpdate(pstmt);

			sql = "UPDATE paxrel.FP_TOKEN" + " SET consumer_key = ?";
			pstmt = conn.getPreparedStatement(sql);
			pstmt.setString(1, properties.getConsumer_key());
			conn.executaUpdate(pstmt);

			sql = "UPDATE paxrel.FP_TOKEN" + " SET private_key = ?";
			pstmt = conn.getPreparedStatement(sql);
			pstmt.setString(1, properties.getPrivate_key());
			conn.executaUpdate(pstmt);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SQLException(e);
				}
			}
		}
	}
}
