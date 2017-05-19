package test.M;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class Person {
	
	@Id 
	private int ID;
	private String Fname;
	private String Lname;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	@Override
	public String toString() {
		return "Person [ID=" + ID + ", Fname=" + Fname + ", Lname=" + Lname
				+ "]";
	}
	
}
