package com.cdac.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.cdac.dto.CustomerModel;
import com.cdac.dto.TranspProfile;
import com.cdac.dto.User;
@Repository
public class CustomerTemplateRepo {
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	
	public List<CustomerModel> ShipList(int userId) {
		
			
			String query="select * from customer where user_id= ?"; 
				
			//List<CustomerModel> members = jdbcTemplate.query(sql,new BeanPropertyRowMapper<CustomerModel>(CustomerModel.class));
	      return   jdbcTemplate.execute(query,new PreparedStatementCallback<List<CustomerModel>>(){
	        	
	        	
	            @Override
	            public List<CustomerModel> doInPreparedStatement(PreparedStatement ps)
	                    throws SQLException, DataAccessException {

	            	ps.setInt(1,userId);
	               
	            	ArrayList<CustomerModel> al = new  ArrayList<CustomerModel>();

	            	
	            	ResultSet rs = ps.executeQuery();
	            	while(rs.next())
	    			{
	    				CustomerModel exp = new CustomerModel();
	    				//User usr=new User();
	    				
	    				exp.setId(rs.getLong("id"));
	    				exp.setItemname(rs.getString("item_name"));
	    				exp.setWeightofitem(rs.getFloat("item_weight"));
	    				exp.setSozeofitem(rs.getInt("item_size"));
	    				exp.setPickupadd(rs.getString("pickupadd"));
	    				exp.setPickupcity(rs.getString("pickupcity"));
	    				exp.setDeladd(rs.getString("deladd"));
	    				exp.setDelcity(rs.getString("delcity"));
	    				exp.setShipdate(rs.getString("ship_date"));
	    				exp.setFare(rs.getFloat("item_fare"));
	    				
	    				//exp.setUsrId(rs.getInt("user_id"));
	    				
	    				
	    				al.add(exp);
	    			}
	            	return al;
	            }
	        });
			
		
//return members;
	
}
	// add shipment details
	
	@Autowired
    JdbcTemplate jdbcTemplate1;
	
	
	public Boolean saveShipment(CustomerModel member , int userId) {
		CustomerModel c=new CustomerModel();
		
			String query="insert into customer values(?,?,?,?,?,?,?,?,?,?,?)";
			
			
			
	        return jdbcTemplate1.execute(query,new PreparedStatementCallback<Boolean>(){
	            @Override
	            public Boolean doInPreparedStatement(PreparedStatement ps)
	                    throws SQLException, DataAccessException {

	            	ps.setLong(1, member.getId());
	            	ps.setString(2, member.getDeladd());
	            	ps.setString(3,member.getDelcity());
	            	ps.setFloat(4,member.getFare());
	            	ps.setString(5, member.getItemname());
	            	ps.setString(6,member.getPickupadd());
	            	ps.setString(7, member.getPickupcity());
	            	ps.setString(8,member.getShipdate());
	            	
	            	ps.setInt(9, member.getSozeofitem());
	            	ps.setFloat(10, member.getWeightofitem());
	                ps.setInt(11,userId);

	                return ps.execute();

	            }
	        });
			
		}
   // update shipment
	
	@Autowired
    JdbcTemplate jdbcTemplate3;
	
	
	public  Boolean updateshipmentDetails(CustomerModel member,Long id) {
		
			String query="update customer set deladd=?,delcity=?,item_fare=?,item_name=?,pickupadd=?,pickupcity=? "
					+ ",ship_date=?,item_size=?,item_weight=? where id=?";
					
		System.out.println("in repo");
			
			
			
	        return jdbcTemplate3.execute(query,new PreparedStatementCallback<Boolean>(){
	            @Override
	            public Boolean doInPreparedStatement(PreparedStatement ps)
	                    throws SQLException, DataAccessException {
                 
	            	ps.setString(1,member.getDeladd());
	            	ps.setString(2,member.getDelcity());
	            	ps.setFloat(3,member.getFare());
	            	ps.setString(4,member.getItemname());
	            	ps.setString(5, member.getPickupadd());
	            	ps.setString(6, member.getPickupcity());
	            	ps.setString(7, member.getShipdate());
	            	ps.setInt(8, member.getSozeofitem());
	            	ps.setFloat(9, member.getWeightofitem());
	            	ps.setLong(10,id);
	            	//.setInt(10,userId);
	            	
	            	
	            	
	             //   ps.setString(1,member.getPassword());
	               
	              //  ps.setString(2,member.getEmailId());

	                return ps.execute();

	            }
	        });
			
		}
	
}

