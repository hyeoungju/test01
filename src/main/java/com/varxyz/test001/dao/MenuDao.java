package com.varxyz.test001.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.test001.domain.Menu;


public class MenuDao {
	private JdbcTemplate jdbcTemplate;
	
	public MenuDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * 메뉴이름이 중복되는지 검사
	 * @param menu
	 * @return
	 */
	public Menu isMenu(String menuName) {
		String sql = "SELECT * FROM Menu WHERE menuName = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new RowMapper<Menu>() {

				@Override
				public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
					Menu menu = new Menu();
					menu.setMenuName(rs.getString("menuName"));
					menu.setMenuPrice(rs.getInt("menuPrice"));
					menu.setMenuType(rs.getString("menuType"));
					return menu;
				}
				
			}, menuName);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}
	
	/**
	 * 메뉴등록하기
	 * @param menu
	 */
	public int addMenu(Menu menu) {
		String sql = "INSERT INTO Menu (menuName, menuPrice, menuType) VALUES (?, ?, ?)";
		try {
			jdbcTemplate.update(sql, menu.getMenuName(), menu.getMenuPrice(), menu.getMenuType());
			System.out.println("메뉴등록성공");
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 2;
		}
	}
	
	/**
	 * 등록된 메뉴리스트 가져오기
	 * @return
	 */
	public List<Menu> getMenuItem(){
		String sql = "SELECT menuName, menuPrice, menuType FROM Menu";
		return jdbcTemplate.query(sql, new RowMapper<Menu>() {
			
			@Override
			public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
				Menu menu = new Menu();
				menu.setMenuName(rs.getString("menuName"));
				menu.setMenuPrice(rs.getInt("menuPrice"));
				menu.setMenuType(rs.getString("menuType"));
				return menu;	
			}
		});
	}
	
}

