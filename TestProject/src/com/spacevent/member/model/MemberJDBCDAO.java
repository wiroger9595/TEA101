package com.spacevent.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberJDBCDAO implements Member_interface{
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "PROJECT";
	String passwd = "123456";
	
	
	private static final String INSERT_STMT = 
			"INSERT INTO member (member_id ,member_account ,member_password , member_name , member_nickname , member_email, member_photo , member_phone, member_address, member_birth, member_sex, member_country, member_singup_date, member_auth, member_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";                 
		
	private static final String GET_ALL_STMT = 
//			"SELECT member_id ,member_account ,member_password , member_name , member_nickname , member_email, member_photo , member_phone, member_address, to_char(member_birth, 'yyyy-mm-dd'), member_sex, member_country, to_char(member_singup_date, 'yyyy-mm-dd'), member_auth, member_status from member order by member_id";                 
			"SELECT * FROM MEMBER order by MEMBER_ID";
		private static final String GET_ONE_STMT = 
//			"SELECT member_id ,member_account ,member_password , member_name , member_nickname , member_email, member_photo , member_phone, member_address, to_char(member_birth, 'yyyy-mm-dd'), member_sex, member_country, to_char(member_singup_date, 'yyyy-mm-dd'), member_auth, member_status from MEMBER WHERE member_id = ?";                 
			"SELECT * FROM MEMBER where MEMBER_ID = ?";
		private static final String DELETE = 
			"DELETE FROM MEMBER where MEMBER_ID = ?";
				
//			"DELETE FROM member where member_id = ?";
		private static final String UPDATE = 
		//	"UPDATE member set member_account = ? ,member_password= ? , member_name = ?, member_nickname = ?, member_email = ?, member_photo = ?, member_phone = ?, member_address = ?, to_char(member_birth, 'yyyy-mm-dd') = ?, member_sex = ?, member_country = ?, to_char(member_singup_date, 'yyyy-mm-dd') = ?, member_auth = ?, member_status = ? where member_id = ?";                 
				"UPDATE MEMBER set MEMBER_ACCOUNT = ? ,MEMBER_PASSWORD = ? , MEMBER_NAME = ? , MEMBER_NICKNAME = ? ,MEMBER_EMAIL = ? , MEMBER_PHOTO = ? , MEMBER_PHONE = ? , MEMBER_ADDRESS = ? ,member_birth = ? , MEMBER_SEX = ? , MEMBER_COUNTRY = ? ,member_singup_date = ? , MEMBER_AUTH = ? , MEMBER_STATUS = ?  where MEMBER_ID = ? ";

			
		
		
		
	@Override
	public void insert(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		byte[] photoImg = null;
		
		
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memberVO.getMember_account());
			pstmt.setString(2, memberVO.getMember_password());
			pstmt.setString(3, memberVO.getMember_name());
			pstmt.setString(4, memberVO.getMember_nickname());
			pstmt.setString(5, memberVO.getMember_email());
			pstmt.setBytes(6, memberVO.getMember_photo());
			pstmt.setString(7, memberVO.getMember_phone());
			pstmt.setString(8, memberVO.getMember_address());
			pstmt.setDate(9, memberVO.getMember_birth());
			pstmt.setString(10, memberVO.getMember_sex());
			pstmt.setString(11, memberVO.getMember_country());
			pstmt.setDate(12, memberVO.getMember_signup_date());
			pstmt.setInt(13, memberVO.getMember_auth());
			pstmt.setString(14, memberVO.getMember_status());
			
			photoImg = memberVO.getMember_photo();
			System.out.println(photoImg);
			Base64.Encoder encode = Base64.getEncoder();
			
			if(photoImg == null) {
//				b1 = Base64.getDecoder().decode(imgString);
//				System.out.println(b1 + "here ");
				memberVO.setMember_photo_string(encode.encodeToString("".getBytes()));
			} else {
				memberVO.setMember_photo_string(encode.encodeToString(photoImg));
			}
			
			
			
			
			pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
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

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		byte[] photoImg = null;
		
		
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memberVO.getMember_account());
			pstmt.setString(2, memberVO.getMember_password());
			pstmt.setString(3, memberVO.getMember_name());
			pstmt.setString(4, memberVO.getMember_nickname());
			pstmt.setString(5, memberVO.getMember_email());
			pstmt.setBytes(6, memberVO.getMember_photo());
			pstmt.setString(7, memberVO.getMember_phone());
			pstmt.setString(8, memberVO.getMember_address());
			pstmt.setDate(9, memberVO.getMember_birth());
			pstmt.setString(10, memberVO.getMember_sex());
			pstmt.setString(11, memberVO.getMember_country());
			pstmt.setDate(12, memberVO.getMember_signup_date());
			pstmt.setInt(13, memberVO.getMember_auth());
			pstmt.setString(14, memberVO.getMember_status());
			pstmt.setString(15, memberVO.getMember_id());
			
			photoImg = memberVO.getMember_photo();
			System.out.println(photoImg);
			Base64.Encoder encode = Base64.getEncoder();
			
			if(photoImg == null) {
//				b1 = Base64.getDecoder().decode(imgString);
//				System.out.println(b1 + "here ");
				memberVO.setMember_photo_string(encode.encodeToString("".getBytes()));
			} else {
				memberVO.setMember_photo_string(encode.encodeToString(photoImg));
			}
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
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
	public void delete(String member_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, member_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
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
	public MemberVO findByPrimaryKey(String member_id) {
		
		MemberVO memberVO = new MemberVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, member_id);

			rs = pstmt.executeQuery();
			

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				memberVO.setMember_id(rs.getString("member_id"));
				memberVO.setMember_account(rs.getString("member_account"));
				memberVO.setMember_password(rs.getString("member_password"));
				memberVO.setMember_name(rs.getString("member_name"));
				memberVO.setMember_nickname(rs.getString("member_nickname"));
				memberVO.setMember_email(rs.getString("member_email"));
				memberVO.setMember_photo(rs.getBytes("member_photo"));
				memberVO.setMember_phone(rs.getString("member_phone"));
				memberVO.setMember_address(rs.getString("member_address"));
				memberVO.setMember_birth(rs.getDate("member_birth"));
				memberVO.setMember_sex(rs.getString("member_sex"));
				memberVO.setMember_country(rs.getString("member_country"));
				memberVO.setMember_signup_date(rs.getDate("member_singup_date"));
				memberVO.setMember_auth(rs.getInt("member_auth"));
				memberVO.setMember_status(rs.getString("member_status"));

				
				////////////////////////////////
				
			
				
				Base64.Encoder encode = Base64.getEncoder();
								
				byte[] photoImg = memberVO.getMember_photo();
				System.out.println(photoImg);
				if(photoImg == null) {
//					
					memberVO.setMember_photo_string(encode.encodeToString("".getBytes()));
				} else {
					memberVO.setMember_photo_string(encode.encodeToString(rs.getBytes("member_photo")));
				}
				
				
				/////////////// 
				
//				BufferedInputStream bis  = new BufferedInputStream(rs.getBinaryStream("photo"));
//				byte[] pic = new byte[4*1024*1024];
//				System.out.println(rs.getBinaryStream("photo").available());
//				bis.read(pic);
//				empVO.setPhoto(pic);
//				bis.close();
				
				
				
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			if(bis != null) {
//				try {
//					bis.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
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
		return memberVO;
	}

	
	/////////////////////////////////////////////////////////////////////
	
	
	@Override
	public List<MemberVO> getAll() {
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try {

			Class.forName(driver);
			
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			

			rs = pstmt.executeQuery();
			

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				memberVO = new MemberVO();
				memberVO.setMember_id(rs.getString("member_id"));
				memberVO.setMember_account(rs.getString("member_account"));
				memberVO.setMember_password(rs.getString("member_password"));
				memberVO.setMember_name(rs.getString("member_name"));
				memberVO.setMember_nickname(rs.getString("member_nickname"));
				memberVO.setMember_email(rs.getString("member_email"));
				memberVO.setMember_photo(rs.getBytes("member_photo"));
				memberVO.setMember_phone(rs.getString("member_phone"));
				memberVO.setMember_address(rs.getString("member_address"));
				memberVO.setMember_birth(rs.getDate("member_birth"));
				memberVO.setMember_sex(rs.getString("member_sex"));
				memberVO.setMember_country(rs.getString("member_country"));
				memberVO.setMember_signup_date(rs.getDate("member_singup_date"));
				memberVO.setMember_auth(rs.getInt("member_auth"));
				memberVO.setMember_country(rs.getString("member_status"));

				
				
				
				////////////////////////////////
				
			
				byte[] photoImg = memberVO.getMember_photo();
				System.out.println(photoImg);
				Base64.Encoder encode = Base64.getEncoder();
				
				if(photoImg == null) {
//					
					memberVO.setMember_photo_string(encode.encodeToString("".getBytes()));
				} else {
					memberVO.setMember_photo_string(encode.encodeToString(rs.getBytes("member_photo")));
				}
				
				list.add(memberVO);
				/////////////// 
				
//				BufferedInputStream bis  = new BufferedInputStream(rs.getBinaryStream("photo"));
//				byte[] pic = new byte[4*1024*1024];
//				System.out.println(rs.getBinaryStream("photo").available());
//				bis.read(pic);
//				empVO.setPhoto(pic);
//				bis.close();
				
				
				
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
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
		return list;
	}
}
