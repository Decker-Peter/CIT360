package test.M;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity 
public class newperson {

	@Id 
	private int ID;
	private String username;
	private String password;
	private String email;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String name) {
		username = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass) {
		password = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String edress) {
		email = edress;
	}
	@Override
	public String toString() {
		return ID + " " + username + password;
	}
	
}