package com.accounting.dao.util;

import java.util.ResourceBundle;

public class DBResourceManager {
	private static final DBResourceManager instance = new DBResourceManager();
	private ResourceBundle bundle = ResourceBundle.getBundle("db");
	
	public static DBResourceManager getInstance() {
		return instance;
	}
	public String getValue(String key) {
		return bundle.getString(key);
	}
}
