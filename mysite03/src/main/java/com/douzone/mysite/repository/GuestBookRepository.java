package com.douzone.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.exception.GuestbookRepositoryException;
import com.douzone.mysite.vo.GuestBookVo;


@Repository
public class GuestBookRepository {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession;
	
	public boolean delete(GuestBookVo vo) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			//3. SQL 준비
			String sql = "delete from guestbook where no = ? and password =?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getPassword());
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
	public List<GuestBookVo> findAll() throws GuestbookRepositoryException{
		// TODO Auto-generated method stub
		
		
		List<GuestBookVo> result = new ArrayList<GuestBookVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			//3. SQL 준비
			String sql = "select no, name, date_format(reg_date,'%Y/%m/%d %H:%i:%s'), message from guestbook order by reg_date desc";
			pstmt = conn.prepareStatement(sql);
			
			//insert, update, delete 문 == executeUpdate
			//결과 값이 int
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String regDate = rs.getString(3);
				String message = rs.getString(4);
				
				GuestBookVo vo = new GuestBookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setRegDate(regDate);
				vo.setMessage(message);
				
				result.add(vo);
			}

		}catch(SQLException e) {
			throw new GuestbookRepositoryException(e.toString());
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
		
		return result;
	}	
	public boolean insert(GuestBookVo vo) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			//3. SQL 준비
			String sql = "insert into guestbook values(null,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩(binding)
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3,vo.getMessage());
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
