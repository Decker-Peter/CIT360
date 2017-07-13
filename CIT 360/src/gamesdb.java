package test.M;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity 
public class gamesdb {

	@Id 
	private int ID;
	private String game;
	private Float price;
	
		
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String gamee) {
		game = gamee;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float pricee) {
		price = pricee;
	}
	@Override
	public String toString() {
		return ID + " Game: " + game + ", Price: " + price;
	}
		
}