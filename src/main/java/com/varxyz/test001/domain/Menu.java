package com.varxyz.test001.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Menu {
	private long mId;
	private String menuName;
	private int menuPrice;
	private String menuType;
	private Date regDate;
	
	public Menu() {
		
	}
	
	public Menu(long mId) {
		this.mId = mId;
	}
}
