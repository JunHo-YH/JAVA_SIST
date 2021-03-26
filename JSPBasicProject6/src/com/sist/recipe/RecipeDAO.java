package com.sist.recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sist.jdbc.DAOManager;

public class RecipeDAO {
	private DAOManager dm=new DAOManager();
	 private Connection conn;
	 private PreparedStatement ps;
	 public void recipeInsert(RecipeVO vo) {
		 try {
			 conn = dm.getConnection();
			 String sql = "INSERT INTO recipe VALUES("
			 		+ "(SELECT NVL(MAX(no)+1,1) FROM recipe), "
			 		+ "?,?,?,0,?)";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, vo.getPoster());
			 ps.setString(2, vo.getTitle());
			 ps.setString(3, vo.getChef());
			 ps.setString(4, vo.getLink());
			 
			 ps.executeUpdate();
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }finally {
			 dm.disConnection(conn, ps);
		 }
	 }
}
