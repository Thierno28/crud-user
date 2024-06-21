package db;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import beans.Utilisateur;

public class DatabaseManager {
	private static final ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
	
	private static String url="jdbc:mysql://localhost:3306/cruduser?characterEncoding=latin1&useConfigs=maxPerformance";
	private static String username = "root";
	private static String password = "passer";
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	static {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(url,username,password);
		 }catch (SQLException ex){
			 System.out.println("Erreur de connexion à la base de donnée: " + ex.getMessage()) ;
		 }catch(Exception e){
			 System.out.println("Erreur de chargement du driver: " + e.getMessage());
		 }
	}
	
	public static ArrayList<Utilisateur> getAll () {
		try {
			users.clear() ;
			stmt = (Statement) con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users");
			while(rs.next())  {
				int id = rs.getInt("id");
				String prenom = rs.getString("prenom");
				String nom = rs.getString("nom");
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				Utilisateur user = new Utilisateur(id,nom,prenom,username,password);
				users.add(user);
			}
			return users;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		 

	}
	
	public static Utilisateur get(int id) {
		try {
			stmt = (Statement) con.createStatement();
			String sql="SELECT * FROM users WHERE id='"+id+"'";
			rs = stmt.executeQuery(sql);
			
			Utilisateur user = new Utilisateur();
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setPrenom(rs.getString("prenom"));
				user.setNom(rs.getString("nom"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			
			return user;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Utilisateur get(String username) {
		try {
			stmt = (Statement) con.createStatement();
			String sql="SELECT * FROM users WHERE username='"+username+"'";
			rs = stmt.executeQuery(sql);
			
			Utilisateur user = new Utilisateur();
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setPrenom(rs.getString("prenom"));
				user.setNom(rs.getString("nom"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			
			return user;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void  add (Utilisateur user) {
		try {
			stmt = (Statement) con.createStatement();
			String sql="INSERT INTO users (prenom,nom,username,password) VALUES (?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString (1, user.getPrenom());
			preparedStmt.setString (2, user.getNom());
			preparedStmt.setString   (3, user.getUsername());
			preparedStmt.setString(4, user.getPassword());
			preparedStmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void update (int id,Utilisateur user) {
		
		try {
			stmt = (Statement) con.createStatement();
			String sql="UPDATE users set prenom=?,nom=?,username=?,password=? where id = "+id;
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, user.getPrenom());
			preparedStmt.setString(2, user.getNom());
			preparedStmt.setString(3, user.getUsername());
			preparedStmt.setString(4, user.getPassword());
			preparedStmt.execute();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void  delete (int id) {
		try {
			stmt = (Statement) con.createStatement();
			String sql="DELETE FROM users WHERE id="+id;
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
