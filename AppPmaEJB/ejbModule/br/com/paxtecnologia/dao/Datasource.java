package br.com.paxtecnologia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Datasource {

	protected static DataSource dataSource;
	private Connection conn;

	public Datasource() throws SQLException, NamingException {
		conn = pegaConexao();
	}

	private Connection pegaConexao() throws SQLException, NamingException {
		Connection con = null;
		Context ic;
		try {
			ic = new InitialContext();
			dataSource = (DataSource) ic
					.lookup("java:jboss/datasource/OracleMonitor");
			try {
				con = dataSource.getConnection();
			} catch (SQLException e) {
				throw new SQLException(e);
			}
		} catch (NamingException e) {
			throw new NamingException("Datasource não encontrado!");
		}
		return con;
	}
	
	public PreparedStatement getPreparedStatement(String sql) throws SQLException{
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(sql);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return pstmt;
	}
	
	public ResultSet executaQuery(PreparedStatement pstmt) throws SQLException {
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return rs;

	}
	
	public void executaUpdate(PreparedStatement pstmt) throws SQLException {
		try {
			pstmt.execute();
		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}

	public Boolean closeConnection(PreparedStatement pstmt) throws SQLException{
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return true;
	}
}
