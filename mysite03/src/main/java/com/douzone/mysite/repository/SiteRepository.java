package com.douzone.mysite.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.vo.SiteVo;

@Repository
public class SiteRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public SiteVo sitefind() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("site.sitefind");
	}

	public boolean siteUpdate(SiteVo siteVo) {
		// TODO Auto-generated method stub
		int result = sqlSession.update("site.siteupdate",siteVo);
		return result == 1;
	}

}
