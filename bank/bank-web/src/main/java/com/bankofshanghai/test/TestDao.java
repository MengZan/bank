package com.bankofshanghai.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

	private JdbcTemplate jdbcTemplate;
	
	private final static String ADD_USER_SQL = "INSERT INTO admin_user(username,password) VALUES(?,?)";
	
	private final static String FIND_USER_BY_ID_SQL = "SELECT username,password FROM admin_user WHERE id=?";

	public void addUser(AdminUser user) {
		Object[] params = new Object[] { user.getUsername(), user.getPassword() };
		jdbcTemplate.update(ADD_USER_SQL, params);
	}
	
	public void addUserGetId(final AdminUser user){
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(ADD_USER_SQL);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				return ps;
			}
		},keyHolder);
		user.setId(keyHolder.getKey().longValue());
	}
	
	public AdminUser getUserById(final long id){
		final AdminUser user = new AdminUser();
		jdbcTemplate.query(FIND_USER_BY_ID_SQL, new Object[]{id}, new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setId(id);
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		});
		return user;
	}
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
}
