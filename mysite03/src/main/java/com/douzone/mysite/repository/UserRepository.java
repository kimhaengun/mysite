package com.douzone.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.exception.UserRepositoryExcetion;
import com.douzone.mysite.vo.UserVo;

@Repository
public class UserRepository {
	@Autowired
	private DataSource dataSource;
	
	public boolean nopassowrdupdate(UserVo vo) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			//3. SQL 준비
			String sql = "update user set name= ?,gender = ? where no= ?";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩(binding)
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getGender());
			pstmt.setLong(3, vo.getNo());
			//insert, update, delete 문 == executeUpdate
			//결과 값이 int
			int count = pstmt.executeUpdate();
			
			result = count == 1;
		}catch(SQLException e) {
			System.out.println("error : "+e);
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();					
				}
				if(conn != null) {
					conn.close();					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}// end try ~ finally
		return result;		
	}
	
	public boolean update(UserVo vo) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			//3. SQL 준비
			String sql = "update user set name= ?,password = ?,gender =? where no= ?";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩(binding)
			pstmt.setString(1, vo.getName());
			pstmt.setString(2,vo.getPassword());
			pstmt.setString(3, vo.getGender());
			pstmt.setLong(4, vo.getNo());
			//insert, update, delete 문 == executeUpdate
			//결과 값이 int
			int count = pstmt.executeUpdate();
			
			result = count == 1;
		}catch(SQLException e) {
			System.out.println("error : "+e);
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();					
				}
				if(conn != null) {
					conn.close();					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}// end try ~ finally
		return result;		
	}	
	public UserVo findByNo(Long no) throws UserRepositoryExcetion {
		// TODO Auto-generated method stub
		UserVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			//3. SQL 준비
			String sql = "select no,name,email, gender from  user where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			//insert, update, delete 문 == executeUpdate
			//결과 값이 int
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Long tableno = rs.getLong(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String gender = rs.getString(4);
				
				vo = new UserVo();
				vo.setNo(tableno);
				vo.setName(name);
				vo.setEmail(email);
				vo.setGender(gender);
			}

		}catch(SQLException e) {
			throw new UserRepositoryExcetion(e.toString());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();					
				}
				if(conn != null) {
					conn.close();					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}// end try ~ finally		
		
		return vo;
	}
	
	
	public UserVo findByEmailAndPassword(String email,String password)  {
		// TODO Auto-generated method stub
		UserVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			//3. SQL 준비
			String sql = "select no,name from user where email = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			//insert, update, delete 문 == executeUpdate
			//결과 값이 int
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				
				vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
				
			}

		}catch(SQLException e) {
			System.out.println("error : "+e);
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();					
				}
				if(conn != null) {
					conn.close();					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}// end try ~ finally
		return vo;
	}	
	public boolean insert(UserVo vo) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			//3. SQL 준비
			String sql = "insert into user values(null,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩(binding)
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3,vo.getPassword());
			pstmt.setString(4, vo.getGender());
			//insert, update, delete 문 == executeUpdate
			//결과 값이 int
			int count = pstmt.executeUpdate();
			
			result = count == 1;
		}catch(SQLException e) {
			System.out.println("error : "+e);
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();					
				}
				if(conn != null) {
					conn.close();					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}// end try ~ finally
		return result;
	}//end insert	

}
