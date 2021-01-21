package com.cdac.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.cdac.dto.TranspProfile;

@Repository
public class TransporterRepoImple {
   
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	
	public Boolean saveProfile(TranspProfile member , int userId) {
		
			String query="insert into tprofile values(?,?,?,?,?,?)";
			
			
			
	        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
	            @Override
	            public Boolean doInPreparedStatement(PreparedStatement ps)
	                    throws SQLException, DataAccessException {

	            	
	                ps.setInt(1,member.getProfileId());
	                ps.setString(2,member.getAdharNo());
	                
	                ps.setString(3,member.getInsuranceNo());
	                ps.setInt(4,userId);
	                ps.setString(5,member.getVehicleNo());
	                ps.setString(6,member.getLicenceNo());
	                //ps.setString(6,member.getMemberEmail());
	                

	                return ps.execute();

	            }
	        });
			
		}

	 // delete transporter
	
	public Boolean deleteTransporterByAdmin(int userId) {
		
		String query="delete from user where user_id=?";
		
		
		
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

            	
               // ps.setInt(1,member.getProfileId());
                //ps.setString(2,member.getAdharNo());
              

                return ps.execute();

            }
        });
		
	}


}
