package com.space.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.json.JSONArray;


public class SpaceDAO implements SpaceDAOInterface{

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "PROJECT";
	String passwd = "123456";
	

	private static final String INSERT_STMT = 
	    "INSERT INTO SPACE VALUES ('SPACE' || lpad(SPACE_ID_SEQ.NEXTVAL, 5, '0'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_STMT = 
		"SELECT * FROM SPACE order by SPACE_ID";
	private static final String SELECT_ONE_STMT = 
		"SELECT * FROM SPACE where SPACE_ID = ?";
	private static final String DELETE = 
		"DELETE FROM SPACE where SPACE_ID = ?";
	private static final String UPDATE = 
		"UPDATE SPACE set MEMBER_ID=?,EMP_ID=?,SPACE_ADDRESS=?,SPACE_LNG=?,SPACE_LAT=?,SPACE_NAME=?,SPACE_TYPE=?,SPACE_EQUMENT=?,SPACE_CONTAIN=?,SPACE_RULE=?,SPACE_REFUND=?,SPACE_STATUS=?,SPACE_SIGNUP_DATE=?,SPACE_ONSALE_DATE=?,SPACE_OFFSALE_DATE=? where SPACE_ID=?";

	@Override
	public void insert(SpaceVO spaceVO) {
		Connection con = null;
		PreparedStatement ptmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(INSERT_STMT);
			
			ptmt.setString(1, spaceVO.getMemId());
			ptmt.setString(2, spaceVO.getEmpId());
			ptmt.setString(3, spaceVO.getSpaceAddress());
			ptmt.setDouble(4, spaceVO.getSpaceLng());
			ptmt.setDouble(5, spaceVO.getSpaceLat());
			ptmt.setString(6, spaceVO.getSpaceName());
			ptmt.setString(7, spaceVO.getSpaceType());
			ptmt.setString(8, spaceVO.getSpaceEquipment());
			ptmt.setString(9, spaceVO.getSpaceContain());
			ptmt.setString(10, spaceVO.getSpaceRule());
			ptmt.setString(11, spaceVO.getSpaceRefund());
			ptmt.setString(12, spaceVO.getSpaceStatus());
			ptmt.setDate(13, spaceVO.getSpaceSignupDate());
			ptmt.setDate(14, spaceVO.getSpaceOnsaleDate());
			ptmt.setDate(15, spaceVO.getSpaceOffsaleDate());

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
	public void delete(String spaceId) {
		Connection con = null;
		PreparedStatement ptmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(DELETE);
			
			ptmt.setString(1, spaceId);
			
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
	public void update(SpaceVO spaceVO) {
		Connection con = null;
		PreparedStatement ptmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(UPDATE);
			
			ptmt.setString(1, spaceVO.getMemId());
			ptmt.setString(2, spaceVO.getEmpId());
			ptmt.setString(3, spaceVO.getSpaceAddress());
			ptmt.setDouble(4, spaceVO.getSpaceLng());
			ptmt.setDouble(5, spaceVO.getSpaceLat());
			ptmt.setString(6, spaceVO.getSpaceName());
			ptmt.setString(7, spaceVO.getSpaceType());
			ptmt.setString(8, spaceVO.getSpaceEquipment());
			ptmt.setString(9, spaceVO.getSpaceContain());
			ptmt.setString(10, spaceVO.getSpaceRule());
			ptmt.setString(11, spaceVO.getSpaceRefund());
			ptmt.setString(12, spaceVO.getSpaceStatus());
			ptmt.setDate(13, spaceVO.getSpaceSignupDate());
			ptmt.setDate(14, spaceVO.getSpaceOnsaleDate());
			ptmt.setDate(15, spaceVO.getSpaceOffsaleDate());
			ptmt.setString(16, spaceVO.getSpaceId());

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
	public SpaceVO selectOne(String spaceId) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		SpaceVO spaceVO = new SpaceVO();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(SELECT_ONE_STMT);
			
			ptmt.setString(1, spaceId);
			
			rs = ptmt.executeQuery();
			while (rs.next()) {
				spaceVO.setSpaceId(rs.getString("SPACE_ID"));
				spaceVO.setMemId(rs.getString("MEMBER_ID"));
				spaceVO.setEmpId(rs.getString("EMP_ID"));
				spaceVO.setSpaceAddress(rs.getString("SPACE_ADDRESS"));
				spaceVO.setSpaceLng(rs.getDouble("SPACE_LNG"));
				spaceVO.setSpaceLat(rs.getDouble("SPACE_LAT"));
				spaceVO.setSpaceName(rs.getString("SPACE_NAME"));
				spaceVO.setSpaceType(rs.getString("SPACE_TYPE"));
				spaceVO.setSpaceEquipment(rs.getString("SPACE_EQUMENT"));
				spaceVO.setSpaceContain(rs.getString("SPACE_CONTAIN"));
				spaceVO.setSpaceRule(rs.getString("SPACE_RULE"));
				spaceVO.setSpaceRefund(rs.getString("SPACE_REFUND"));
				spaceVO.setSpaceStatus(rs.getString("SPACE_STATUS"));
				spaceVO.setSpaceSignupDate(rs.getDate("SPACE_SIGNUP_DATE"));
				spaceVO.setSpaceOnsaleDate(rs.getDate("SPACE_ONSALE_DATE"));
				spaceVO.setSpaceOffsaleDate(rs.getDate("SPACE_OFFSALE_DATE"));
				
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
		return spaceVO;
	}

	@Override
	public List<SpaceVO> getAll() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		SpaceVO spaceVO = null;
		List<SpaceVO> list = new ArrayList<SpaceVO>();
		
		String jsonStr = JSONArray.class.toString();
		System.out.println(jsonStr);
		
		
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ptmt = con.prepareStatement(SELECT_ALL_STMT);
			
			rs = ptmt.executeQuery();
			while (rs.next()) {
				spaceVO = new SpaceVO();
				spaceVO.setSpaceId(rs.getString("SPACE_ID"));
				spaceVO.setMemId(rs.getString("MEMBER_ID"));
				spaceVO.setEmpId(rs.getString("EMP_ID"));
				spaceVO.setSpaceAddress(rs.getString("SPACE_ADDRESS"));
				spaceVO.setSpaceLng(rs.getDouble("SPACE_LNG"));
				spaceVO.setSpaceLat(rs.getDouble("SPACE_LAT"));
				spaceVO.setSpaceName(rs.getString("SPACE_NAME"));
				spaceVO.setSpaceType(rs.getString("SPACE_TYPE"));
				spaceVO.setSpaceEquipment(rs.getString("SPACE_EQUMENT"));
				spaceVO.setSpaceContain(rs.getString("SPACE_CONTAIN"));
				spaceVO.setSpaceRule(rs.getString("SPACE_RULE"));
				spaceVO.setSpaceRefund(rs.getString("SPACE_REFUND"));
				spaceVO.setSpaceStatus(rs.getString("SPACE_STATUS"));
				spaceVO.setSpaceSignupDate(rs.getDate("SPACE_SIGNUP_DATE"));
				spaceVO.setSpaceOnsaleDate(rs.getDate("SPACE_ONSALE_DATE"));
				spaceVO.setSpaceOffsaleDate(rs.getDate("SPACE_OFFSALE_DATE"));
				
				list.add(spaceVO);
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

	@Override
	public List<SpaceVO> queryByStartEnd(int start, int end) {
		
		
		List<SpaceVO> list = new ArrayList<SpaceVO>();

        StringBuffer sql = new StringBuffer("SELECT * FROM SPACE");
        sql.append(" LIMIT ").append(end - start);
        sql.append(" OFFSET ").append(start);

//        jdbcTemplate.query(conn -> {
//            PreparedStatement ps = conn.prepareStatement(sql.toString());
//            return ps;
//        }, rs -> {
//            populate(list, rs);
//
//        });

        return list;
	}

	@Override
	public SpaceVO querDetail(long spaceId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
//	========================================================================================================== //
	
	
	
	
	
	
	
	
	
	
}
