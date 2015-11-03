package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import constants.TPConstant;
import constants.TPConstant.sqlList;

public class DBManager {
	private Connection con;
	private static DBManager uniqueManager = new DBManager();
	
	public DBManager () {
		try {
			Class.forName(TPConstant.JDBC_DRIVER);
			con = DriverManager.getConnection(TPConstant.DB_URL, TPConstant.USERNAME, TPConstant.PASSWORD);
			if(con != null) System.out.println("데이터 베이스 접속 성공");
		} catch(ClassNotFoundException e) {	System.out.println("드라이버 로드 실패");
		} catch(SQLException e) {System.out.println("데이터 베이스 접속 실패");}
	}
	
	public static DBManager getInstance () {return uniqueManager;}
	
	public int insert(sqlList sqlVar, Map<String, Object> param) {
		String sql = null;
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			if (sqlVar.equals(sqlList.addCity)) {
				sql = TPConstant.addCity;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, (String)(param.get("c_name")));
			}
			else if (sqlVar.equals(sqlList.addDistrict)) {
				sql = TPConstant.addDistrict;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, (String)(param.get("d_name")));
			}
			else if (sqlVar.equals(sqlList.addLocation)) {
				sql = TPConstant.addLocation;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, (String)(param.get("l_name")));
			}
			
			result = pstmt.executeUpdate(sql);
		} catch (SQLException e) {e.printStackTrace();}
		
		return result;
	}
	
	public int delete(sqlList sqlVar, Map<String, Object> param) {
		String sql = null;
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			if (sqlVar.equals(sqlList.deleteCity)) {
				sql = TPConstant.deleteCity;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, (String)(param.get("c_name")));
			}
			else if (sqlVar.equals(sqlList.deleteDistrict)) {
				sql = TPConstant.deleteDistrict;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, (String)(param.get("d_name")));
			}
			else if (sqlVar.equals(sqlList.deleteLocation)) {
				sql = TPConstant.deleteLocation;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, (String)(param.get("l_name")));
			}
			
			result = pstmt.executeUpdate(sql);
		} catch (SQLException e) {e.printStackTrace();}
		
		return result;
	}
	
	
	public ResultSet select(sqlList sqlVar, Map<String, Object> param) {
		ResultSet rs = null;
		String sql = null;
		PreparedStatement pstmt = null;
		try {
			if (sqlVar.equals(sqlList.findCity)) {
				sql = TPConstant.findCity;
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, (int) param.get("c_id"));
			}
			else if (sqlVar.equals(sqlList.findDistrict)) {
				sql = TPConstant.findDistrict;
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, (int) param.get("d_id"));
			}
			else if (sqlVar.equals(sqlList.findLocation)) {
				sql = TPConstant.findLocation;
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, (int) param.get("l_id"));
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {e.printStackTrace();}
		try {
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}