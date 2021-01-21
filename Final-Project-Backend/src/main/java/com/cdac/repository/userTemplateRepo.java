package com.cdac.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.cdac.dto.User;
@Repository
public class userTemplateRepo {
   

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	
	public Boolean updatePassword(User member) {
		
			//String query="insert into Tprofile values(?,?,?,?,?,?)";
		
			String query="update user set password=? where email_id=?"; 
			
			
	        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
	            @Override
	            public Boolean doInPreparedStatement(PreparedStatement ps)
	                    throws SQLException, DataAccessException {

	            	
	                ps.setString(1,member.getPassword());
	               
	                ps.setString(2,member.getEmailId());

	                return ps.execute();

	            }
	        });
			
		}
	
}
