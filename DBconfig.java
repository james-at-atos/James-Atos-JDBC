package com.qa.customer;

public class DBconfig {
	//Connect to database, we need 3 things:
		// - url
		// - password
		// - username
		// static - only one instance of that variable/method
		// final - fixed, can't be changed (constant)
	
	//                                                                db
	protected static final String URL = "jdbc:mysql://localhost:3306/customer";
	protected static final String USER = "root";
	protected static final String PASS = "root1234";

}
