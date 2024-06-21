package dao;

import java.util.ArrayList;

import beans.Utilisateur;
import db.DatabaseManager;

public class DaoMysqlImpl implements Dao<Utilisateur> {
	
	private static final ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
	
	public void addUser(Utilisateur u) {
		
		DatabaseManager.add(u);
	}
	
	public ArrayList<Utilisateur> listUsers () {
		return DatabaseManager.getAll();
	}
	
	public void remove (int id) {
		DatabaseManager.delete(id);
	}
	
	public void update (int id,Utilisateur modifiedUser) {
		
		DatabaseManager.update(id,modifiedUser);
	}
	
	public Utilisateur findUser (int id) {
		return DatabaseManager.get(id);
	}
	
	
	public Utilisateur findUser (String username) {
		return DatabaseManager.get(username);
	}
	public Utilisateur login (String username, String password) {
		for(Utilisateur user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
}
