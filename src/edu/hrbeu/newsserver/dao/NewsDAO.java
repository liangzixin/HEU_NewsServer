package edu.hrbeu.newsserver.dao;

import java.sql.*;
import java.util.ArrayList;

import edu.hrbeu.newsserver.common.GateTime;
import edu.hrbeu.newsserver.common.JdbcUtil;
import edu.hrbeu.newsserver.model.News;

public class NewsDAO {
	/**
	 * @param news - A new News Entity that shall be inserted into database*/
	GateTime gateTime=new GateTime();
	public void updateNews(News news){
		Connection con = null;
		PreparedStatement stm = null;
		
		try {
			con = JdbcUtil.getConnection();
		stm = con.prepareStatement("INSERT INTO tb_productinfo (name, CategoryId, CreateTime) VALUES (?, ?, ?, ?, ?, ?, ?)");
			stm.setString(1, news.getName());
			stm.setInt(2, news.getCategoryId());
			//stm.setString(3, news.getAbstract());
		//	stm.setString(4, gateTime.formatTime(news.getCreateTime()));
		//	stm.setString(5, news.getStorageLoc());
		//	stm.setString(6, news.getLink());
		//	stm.setString(7, news.getProvider());
			
			stm.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(null, stm, con);
		}
	}
	/**
	 * @param title - Represent current the title of news
	 * @return Corresponding NewsID*/
	public int getNewsIDByTitle(String title){
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = JdbcUtil.getConnection();
			stm = con.prepareStatement("SELECT id FROM tb_productinfo WHERE name=?");
			stm.setString(1, title);
			rs = stm.executeQuery();
			while(rs.next()){
				result = rs.getInt("id");
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(null, stm, con);
		}
		return result;
}
	/**
	 * @param Loc - The local storage location of the target news.
	 * @param ID - The NewsID of target news.*/
	public void updateStorageLocByID(String Loc, int ID){
		Connection con = null;
		PreparedStatement stm = null;
		/*
		try {
			con = JdbcUtil.getConnection();
			stm = con.prepareStatement("UPDATE tb_productinfo SET StorageLoc = ? WHERE NewsID= ?");
			stm.setString(1, Loc);
			stm.setInt(2, ID);
			
			stm.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(null, stm, con);
		}
		*/
	}
	
	/**
	 * @param Category - Target category of news.
	 * @return A News list of a certain category.*/
	public ArrayList<News> getNewsByCategory(int CategoryId){
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<News> result = new ArrayList<News>();
		try {
			con = JdbcUtil.getConnection();
			stm = con.prepareStatement("SELECT TOP 3  id, name, categoryId, createTime FROM tb_productinfo WHERE CategoryId = ? ORDER BY ID DESC");
			stm.setInt(1, CategoryId);
			
			rs = stm.executeQuery();
			
			while(rs.next()){
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setName(rs.getString("name"));
				news.setCategoryId(rs.getInt("CategoryId"));
				//news.setAbstract(rs.getString("Abstract"));
			//	news.setProvider(rs.getString("Provider"));
			//	news.setCreateTime(rs.getDate("createTime"));
		//		news.setStorageLoc(rs.getString("StorageLoc"));
			//	news.setLink(rs.getString("Link"));
				
				result.add(news);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
