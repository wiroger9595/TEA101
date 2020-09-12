package com.MemberComm.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberCommDAO implements MemberCommDAOInterface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "PROJECT";
	String passwd = "123456";

	private static final String INSERT_STMT = 
	    "INSERT INTO MEMBER_COMM VALUES (MEMBER_COMM_ID,?,?,?,?,?)";
	private static final String SELECT_ALL_STMT = 
		"SELECT * FROM MEMBER_COMM order by MEMBER_COMM_ID";
	private static final String SELECT_ONE_STMT = 
		"SELECT * FROM MEMBER_COMM where MEMBER_COMM_ID = ?";
	private static final String DELETE = 
		"DELETE FROM MEMBER_COMM where MEMBER_COMM_ID = ?";
	private static final String UPDATE = 
		"UPDATE MEMBER_COMM set MEMBER_A_ID=?,MEMBER_B_ID=?,COMM=?,COMM_LEVEL=?,COMM_DATE=? where MEMBER_COMM_ID = ?";


	@Override
	public void insert(MemberCommVO memberCommVO) {
		Connection con = null;
		PreparedStatement ptmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(INSERT_STMT);
			
			ptmt.setString(1, memberCommVO.getMemberAId());
			ptmt.setString(2, memberCommVO.getMemberBId());
			ptmt.setString(3, memberCommVO.getComm());
			ptmt.setInt(4, memberCommVO.getCommLevel());
			ptmt.setDate(5, memberCommVO.getCommDate());

			ptmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (ptmt != null) {
				try {
					ptmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(String memberCommId) {
		Connection con = null;
		PreparedStatement ptmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(DELETE);
			
			ptmt.setString(1, memberCommId);
			
			ptmt.executeUpdate();
			
		}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if (ptmt != null) {
					try {
						ptmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
	}

	@Override
	public void update(MemberCommVO memberCommVO) {
		Connection con = null;
		PreparedStatement ptmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(UPDATE);
			
			ptmt.setString(1, memberCommVO.getMemberAId());
			ptmt.setString(2, memberCommVO.getMemberBId());
			ptmt.setString(3, memberCommVO.getComm());
			ptmt.setInt(4, memberCommVO.getCommLevel());
			ptmt.setDate(5, memberCommVO.getCommDate());
			ptmt.setString(6, memberCommVO.getMemberCommlId());
			
			ptmt.executeUpdate();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (ptmt != null) {
				try {
					ptmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public MemberCommVO selectOne(String memberCommId) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		MemberCommVO memberCommVO = new MemberCommVO();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(SELECT_ONE_STMT);
			
			ptmt.setString(1, memberCommId);
			
			rs = ptmt.executeQuery();
			while (rs.next()) {
				memberCommVO.setMemberCommlId(rs.getString("MEMBER_COMM_ID"));
				memberCommVO.setMemberAId(rs.getString("MEMBER_A_ID"));
				memberCommVO.setMemberBId(rs.getString("MEMBER_B_ID"));
				memberCommVO.setComm(rs.getString("COMM"));
				memberCommVO.setCommLevel(rs.getInt("COMM_LEVEL"));
				memberCommVO.setCommDate(rs.getDate("COMM_DATE"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (ptmt != null) {
				try {
					ptmt.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return memberCommVO;
	}

	@Override
	public List<MemberCommVO> selectAll() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		MemberCommVO memberCommVO = null;
		List<MemberCommVO> list = new ArrayList<MemberCommVO>();;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(SELECT_ALL_STMT);
			
			rs = ptmt.executeQuery();
			while (rs.next()) {
				
				
//				memberCommVO = new MemberCommVO();
//				memberCommVO.setMemberCommlId(rs.getString("MEMBER_COMM_ID"));
//				memberCommVO.setMemberAId(rs.getString("MEMBER_A_ID"));
//				memberCommVO.setMemberBId(rs.getString("MEMBER_B_ID"));
//				memberCommVO.setComm(rs.getString("COMM"));
//				memberCommVO.setCommLevel(rs.getInt("COMM_LEVEL"));
//				memberCommVO.setCommDate(rs.getDate("COMM_DATE"));
//				list.add(memberCommVO);
				
				populate(list, rs);
			}

			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (ptmt != null) {
					try {
						ptmt.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
		return list;
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////
	
	public void populate(List<MemberCommVO> list, ResultSet rs) throws SQLException {
		MemberCommVO memberCommVO = new MemberCommVO();

		memberCommVO = new MemberCommVO();
		memberCommVO.setMemberCommlId(rs.getString("MEMBER_COMM_ID"));
		memberCommVO.setMemberAId(rs.getString("MEMBER_A_ID"));
		memberCommVO.setMemberBId(rs.getString("MEMBER_B_ID"));
		memberCommVO.setComm(rs.getString("COMM"));
		memberCommVO.setCommLevel(rs.getInt("COMM_LEVEL"));
		memberCommVO.setCommDate(rs.getDate("COMM_DATE"));
		list.add(memberCommVO);
	}

}
