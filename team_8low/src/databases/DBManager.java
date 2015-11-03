package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import constants.TPConstant;
import constants.TPConstant.ESQLList;

public class DBManager {
	private Connection con;
	private static DBManager uniqueManager;
	
	private DBManager () {
		try {
			Class.forName(TPConstant.JDBC_DRIVER);
			con = DriverManager.getConnection(TPConstant.DB_URL, TPConstant.USERNAME, TPConstant.PASSWORD);
			if(con != null) System.out.println("데이터 베이스 접속 성공");
		} catch(ClassNotFoundException e) {	System.out.println("드라이버 로드 실패");
		} catch(SQLException e) {System.out.println("데이터 베이스 접속 실패");}
	}
	
	public static DBManager getInstance () {
		if(uniqueManager != null) {
			// empty
		} else {
			uniqueManager = new DBManager();
		}
		return uniqueManager;
	}
	
	public int insert(ESQLList sqlVar, Map<String, Object> param) {
		String sql = null;
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			if (sqlVar.equals(ESQLList.ADD_CITY)) {
				sql = TPConstant.ADD_CITY;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, (String)(param.get("c_name")));
			}
			else if (sqlVar.equals(ESQLList.ADD_DISTRICT)) {
				sql = TPConstant.ADD_DISTRICT;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, (String)(param.get("d_name")));
			}
			else if (sqlVar.equals(ESQLList.ADD_LOCATION)) {
				sql = TPConstant.ADD_LOCATION;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, (String)(param.get("l_name")));
			}
			
			result = pstmt.executeUpdate(sql);
		} catch (SQLException e) {e.printStackTrace();}
		
		return result;
	}
	
	public int delete(ESQLList sqlVar, Map<String, Object> param) {
		String sql = null;
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			if (sqlVar.equals(ESQLList.DELETE_CITY)) {
				sql = TPConstant.DELETE_CITY;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, (String)(param.get("c_name")));
			}
			else if (sqlVar.equals(ESQLList.DELETE_DISTRICT)) {
				sql = TPConstant.DELETE_DISTRICT;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, (String)(param.get("d_name")));
			}
			else if (sqlVar.equals(ESQLList.DELETE_LOCATION)) {
				sql = TPConstant.DELETE_LOCATION;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, (String)(param.get("l_name")));
			}
			
			result = pstmt.executeUpdate(sql);
		} catch (SQLException e) {e.printStackTrace();}
		
		return result;
	}
	
	
	public ResultSet select(ESQLList sqlVar, Map<String, Object> param) {
		ResultSet rs = null;
		String sql = null;
		PreparedStatement pstmt = null;
		try {
			if (sqlVar.equals(ESQLList.FIND_CITY)) {
				sql = TPConstant.FIND_CITY;
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, (int) param.get("c_id"));
			}
			else if (sqlVar.equals(ESQLList.FIND_DISTRICT)) {
				sql = TPConstant.FIND_DISTRICT;
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, (int) param.get("d_id"));
			}
			else if (sqlVar.equals(ESQLList.FIND_LOCATION)) {
				sql = TPConstant.FIND_LOCATION;
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