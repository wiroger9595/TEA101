package com.spaceDetail.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SpaceDetailDAO implements SpaceDetailDAOInterface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "PROJECT";
	String passwd = "123456";
	

	private static final String INSERT_STMT = 
	    "INSERT INTO SPACE_DETAIL VALUES ('SD' || lpad(SPACE_DETAIL_ID_SEQ.NEXTVAL, 5, '0'),?,?,?)";
	private static final String SELECT_ALL_STMT = 
		"SELECT * FROM SPACE_DETAIL order by SPACE_DETAIL_ID";
	private static final String SELECT_ONE_STMT = 
		"SELECT * FROM SPACE_DETAIL where SPACE_ID = ?";
	private static final String DELETE = 
		"DELETE FROM SPACE_DETAIL where SPACE_DETAIL_ID = ?";
	private static final String UPDATE = 
		"UPDATE SPACE_DETAIL set SPACE_ID=?,SPACE_DETAIL_FREEDATE=?,SPACE_DETAIL_CHARGE=? where SPACE_DETAIL_ID = ?";


	@Override
	public void insert(SpaceDetailVO spaceDetailVO) {
		Connection con = null;
		PreparedStatement ptmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(INSERT_STMT);
			
			ptmt.setString(1, spaceDetailVO.getSpaceId());
			ptmt.setDate(2, spaceDetailVO.getSpaceDetailFreeDate());
			ptmt.setInt(3, spaceDetailVO.getSpaceDetailCharge());

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
	public void delete(String spaceDetailId) {
		Connection con = null;
		PreparedStatement ptmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(DELETE);
			
			ptmt.setString(1, spaceDetailId);
			
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
	public void update(SpaceDetailVO spaceDetailVO) {
		Connection con = null;
		PreparedStatement ptmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(UPDATE);
			
			ptmt.setString(1, spaceDetailVO.getSpaceId());
			ptmt.setDate(2, spaceDetailVO.getSpaceDetailFreeDate());
			ptmt.setInt(3, spaceDetailVO.getSpaceDetailCharge());
			ptmt.setString(4, spaceDetailVO.getSpaceDetailId());

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
	public SpaceDetailVO selectOne(String spaceId) {
		System.out.println("dddf"+spaceId);

		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		SpaceDetailVO spaceDetailVO = new SpaceDetailVO();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(SELECT_ONE_STMT);
			
			ptmt.setString(1, spaceId);
			
			rs = ptmt.executeQuery();
			while (rs.next()) {
				spaceDetailVO.setSpaceDetailId(rs.getString("SPACE_DETAIL_ID"));
				spaceDetailVO.setSpaceId(rs.getString("SPACE_ID"));
				spaceDetailVO.setSpaceDetailFreeDate(rs.getDate("SPACE_DETAIL_FREEDATE"));
				spaceDetailVO.setSpaceDetailCharge(rs.getInt("SPACE_DETAIL_CHARGE"));
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
		System.out.println("11111"+spaceDetailVO.getSpaceDetailCharge());
		return spaceDetailVO;
	}

	@Override
	public List<SpaceDetailVO> selectAll() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		SpaceDetailVO spaceDetailVO = null;
		List<SpaceDetailVO> list = new ArrayList<SpaceDetailVO>();;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(SELECT_ALL_STMT);
			
			rs = ptmt.executeQuery();
			while (rs.next()) {
				spaceDetailVO = new SpaceDetailVO();
				spaceDetailVO.setSpaceDetailId(rs.getString("SPACE_DETAIL_ID"));
				spaceDetailVO.setSpaceId(rs.getString("SPACE_ID"));
				spaceDetailVO.setSpaceDetailFreeDate(rs.getDate("SPACE_DETAIL_FREEDATE"));

				spaceDetailVO.setSpaceDetailCharge(rs.getInt("SPACE_DETAIL_CHARGE"));
				list.add(spaceDetailVO);
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

}
