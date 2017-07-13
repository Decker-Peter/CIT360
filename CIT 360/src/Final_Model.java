package test.M;

import java.io.IOException;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONUtilities;
import org.quickconnectfamily.json.ParseException;

import org.quickconnectfamily.json.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Final_Model {
	String[] start; 
	String usernameGlo;
	String[] loggedin;
	int ID;

	public Final_Model(){
		start = new String[] {"Welcome to ShareMy","To Browse press 1","To Register press 2", "To Login press 3",  "To Quit press 4"};
	}
	
	public String[] getArrayOfStrings(){
		return start;
	}
	
	public void Login_Model(String username){
		loggedin = new String[] {"Welcome " + username, "To Post press 1","To Browse press 2 ",  "To Exit press 3"};
	}
	
	public String[] getStringLoggedIn(){
		return loggedin;
	}

	public void Register(String username, String password, String email){
		
		newperson regi = new newperson();
		regi.setID(findID());
		regi.setUsername(username);
		regi.setPassword(password);
		regi.setEmail(email);
		
        Configuration con = new Configuration().configure().addAnnotatedClass(newperson.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
	
		session.save(regi);
		
		tx.commit();
		
	}
	
	public void PostGame(String game, Float price){
		
		gamesdb post = new gamesdb();
		post.setID(findIDforGames());
		post.setGame(game);
		post.setPrice(price);
	
        Configuration con = new Configuration().configure().addAnnotatedClass(gamesdb.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
	
		session.save(post);
		
		tx.commit();
		
	}
	
	public int findIDforGames(){
		String find = "false";
		int i = 1;
		
		while(find == "false"){
			gamesdb post = new gamesdb();
		
        Configuration con = new Configuration().configure().addAnnotatedClass(gamesdb.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		if ((post = (gamesdb)session.get(gamesdb.class, i)) == null){
		find = "true";
		} else {
		i++;
		}
	}
		return i;	
}
	
	public int findID(){
		String find = "false";
		int i = 1;
		
		while(find == "false"){
		newperson regi = new newperson();
		
        Configuration con = new Configuration().configure().addAnnotatedClass(newperson.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		if ((regi = (newperson)session.get(newperson.class, i)) == null){
		find = "true";
		} else {
		i++;
		}
	}
		return i;	
}
	
	public String[] BrowsePurchase(){
		int size = findIDforGames();
		String[] games = new String[size];
		String find = "false";
		int i = 1;
		int j = 1;
		
		while(find == "false"){
		gamesdb post = new gamesdb();
		

        Configuration con = new Configuration().configure().addAnnotatedClass(gamesdb.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		post = (gamesdb)session.get(gamesdb.class, i);	
		games[j] = post.toString();
		i++;
		if ((post = (gamesdb)session.get(gamesdb.class, i)) == null){
			find = "true";
		} else {
			j++;
		}
			}
			return games;		
		}
	
	public String[] loginInfo(){
		int size = findID();
		String[] users = new String[size];
		
		String find = "false";
		int i = 1;
		int j = 1;
		
		while(find == "false"){
		newperson regi = new newperson();
		
        Configuration con = new Configuration().configure().addAnnotatedClass(newperson.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		regi = (newperson)session.get(newperson.class, i);
		users[j] = regi.toString();
		i++;
		if ((regi = (newperson)session.get(newperson.class, i)) == null){
		find = "true";
		} else {
		j++;
		}
	}
		return users;	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}