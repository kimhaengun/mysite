package com.douzone.mysite.repository;


import java.util.HashMap;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.exception.UserRepositoryExcetion;
import com.douzone.mysite.vo.UserVo;

@Repository
public class UserRepository {
	
	@Autowired
	private SqlSession sqlSession;
	public boolean nopassowrdupdate(UserVo vo) {
		// TODO Auto-generated method stub
		int count = sqlSession.update("user.nopassowrdupdate", vo);
		return count == 1;		
	}
	
	public boolean update(UserVo vo) {
		// TODO Auto-generated method stub
		int count = sqlSession.update("user.update",vo);
		return count == 1;		
	}	
	public UserVo findByNo(Long no) throws UserRepositoryExcetion {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("user.findByNo",no);
	}
	
	
	public UserVo findByEmailAndPassword(String email,String password)  {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("e", email);
		map.put("p", password);
		
		
		return sqlSession.selectOne("user.findByEmailAndPassword",map);
		
	}	
	public boolean insert(UserVo vo) {
		// TODO Auto-generated method stub
		int count = sqlSession.insert("user.insert",vo);
		return count == 1;
	}//end insert	

}
