package com.qa.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDqueries {

	// To carry out CRUD queries - where we connect to the db
	// Four main things needed:
	// - open the connection
	// - write your query/statement - CRUD
	// - Execute query.
	// - close connection

	private Connection conn;// has a driver manager class which contains the methods to connect to db
	private Statement stmt;// allows us to prepare the query we want to execute
	private ResultSet rs; // Crucial for when returning multiple rows from a database table

	// open connection in the constructor - initialises everything
	public CRUDqueries() {
		try {
			conn = DriverManager.getConnection(DBconfig.URL, DBconfig.USER, DBconfig.PASS);
			this.stmt = conn.createStatement();// create a statement object to execute sql queries
			System.out.println("Connection Successful!");
		} catch (SQLException e) {
			System.out.println("Incorrect credentials");
			e.printStackTrace();
		}
	}

	// Need a way to run our queries - call specific methods from the Statement
	// class
	// - executeQuery - retrieves info -> READ
	// - executeUpdate - passes into through and returns nothing -> CREATE, UPDATE,
	// DELETE

	// CREATE - INSERT INTO .... -> returns nothing, just says "query ok"
	public void create(Customer c) {

//	public void create(String first name, String last name, int age) {
		// info to collect to pass into the database
//		String first name = "James";
//		String last name = "Morgan";
// 		int age = 25;

		// INSERT INTO customer(first name, last name, age)
		// VALUES("James","Morgan",25);
		String createStmt = "INSERT INTO customer(first name, age, last name) VALUES('" + c.getFirstName() +
				 ",'" + c.getAge() + "'," + c.getLastName() ;
		try {
			stmt.executeUpdate(createStmt);
			System.out.println("Create statement executed");
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

	// READ - SELECT ..... -> executeQuery
	public void read() {
		String readStmt = "SELECT * FROM customer.customer;";
		try {
			rs = stmt.executeQuery(readStmt);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("First Name: " + rs.getString("firstname"));
				System.out.println("Age: " + rs.getInt("age"));
				System.out.println("Last Name: " + rs.getString("lastname"));
			}

		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

	// UPDATE - UPDATE ..... -> executeUpdate
	public void update(String updateVal, int id ) {
//		UPDATE customer SET first name = "James" WHERE id = 2;
		String updateStmt = "UPDATE customer SET first name = '" + updateVal + "' WHERE id = " + id + ";";
		try {
			stmt.executeUpdate(updateStmt);
			System.out.println("Update statement executed");
			
		}catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

	// DELETE - DELETE ..... -> executeUpdate
	public void delete(int id) {
		String delStmt = "DELETE FROM customer WHERE id =" + id + ";";
		try {
			stmt.executeUpdate(delStmt);
			System.out.println("Delete statement executed");
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}

	}

	// close the connection
	public void closeConn() {
		try {
			conn.close();
			System.out.println("Closed!");
		} catch (SQLException e) {
			System.out.println("Closing connection...");
			e.printStackTrace();
		}
	}

}
