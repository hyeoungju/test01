package com.varxyz.test001.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.test001.domain.Customer;


public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Customer getCustomerByUserId(String userId){
		String sql = "SELECT * FROM Customer WHERE userId=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer(rs.getLong("cId"),
						rs.getString("userId"), rs.getString("name"),
						rs.getString("passwd"));
				return customer;
			}
			
		}, userId);
	}
	
	/**
	 * 아이디 중복 검사
	 * @param userId
	 * @return
	 */
	public boolean isUser(String userId) {
		String sql = "SELECT count(*) FROM Customer WHERE userId=?";
		boolean result = true;
		int ishere = jdbcTemplate.queryForObject(sql, Integer.class, userId);
		if(ishere == 0 ) {
			result = false; 
		}
		return result;
		
	}
	/**
	 * 로그인할때 가입된 유저인지 검사
	 * @param userId
	 * @param passwd
	 * @return
	 */
	public boolean isUserLogin(String userId, String passwd) {
		String sql = "SELECT count(*) FROM Customer WHERE userId = ? AND passwd = ?";
		boolean result = true;
		int ishere = jdbcTemplate.queryForObject(sql, Integer.class, userId, passwd);
		if(ishere == 0 ) {
			result = false; 
		}
		return result;
		
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (userId, passwd, name) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, customer.getUserId(), customer.getPasswd(), customer.getName());
		System.out.println("회원가입성공");
	}
	
}

