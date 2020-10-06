package com.spaceComment.Service.controller;

import java.io.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;


@WebServlet("/space/showhighestoption")
public class SpaceCommentServiceController {

	
	
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String userid = "PROJECT";
	private static final String passwd = "123456";
	private static final String RATE_HIGHER_OPTION = "select AVG(SPACE_COMMENT_LEVEL) from SPACE_COMMENT where SPACE_ID = ? AND SPACE_COMMENT_LEVEL >3";
	
	
	
	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 	for choose HIGHEST
	 * 
	 * 
	 * 
	 * 
	 * 
	 */


	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		

//		try {
//			PreparedStatement pstmt = con.prepareStatement(RATE_HIGHER_OPTION);
//			String spaceId = req.getParameter("spaceId").trim();
//			pstmt.setString(1, spaceId);
//			ResultSet rs = pstmt.executeQuery();
//			
//
//			if (rs.next()) {
////				
//				rs.getString(1, spaceId);
//				
//				while ((len = in.read(buf)) != -1) {
//					out.write(buf, 0, len);
//				}
//				in.close();
//			} else {
//				res.sendError(HttpServletResponse.SC_NOT_FOUND);
//			}
//			rs.close();
//			pstmt.close();
//			con.close();
//		} catch (Exception e) {
//			System.out.println(e);
//			System.out.println(req.getParameter("spaceId").trim());
//		}
//	}
	}
}
