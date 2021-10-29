package com.douzone.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.GuestBookVo;
import com.douzone.mysite.vo.PageVo;
import com.douzone.mysite.vo.UserVo;

@Repository
public class BoardRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	//게시판 리스트
	public List<BoardVo> findAll(Long page) {
		// TODO Auto-generated method stub
		List<BoardVo> list = sqlSession.selectList("board.list",page);
	
		return list;
	}	
	
	//게시판 총 수
	public PageVo findcount() {
		// TODO Auto-generated method stub
		PageVo vo = sqlSession.selectOne("board.findcount");
		System.out.println("-----"+vo);
		return vo;
	}	

	//게시판 삭제
	public boolean delete(Long no) {
		// TODO Auto-generated method stub
		int result = sqlSession.delete("board.delete", no);
		return result == 1;
	}	
	
	//테이블 상세보기
	public BoardVo findByTableNo(Long no) {
		// TODO Auto-generated method stu	
		
		return 	sqlSession.selectOne("board.findByTableNo",no);
	}
	
	//게시판 생성
	public boolean insert(BoardVo vo) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("board.insert", vo);
		return result == 1;
	}//end insert	
	
	//hit 증가
	public boolean hitupdate(Long no) {
		int result = sqlSession.update("board.hitupdate",no);
		return result == 1;
	}	
	
	//게시판 수정
	public boolean update(BoardVo vo) {
		// TODO Auto-generated method stub
		int result = sqlSession.update("board.update",vo);
		return result == 1;		
	}	
	
	//댓글 추가
	public boolean replyInsert(BoardVo vo) {
		int result = sqlSession.insert("board.replyinsert", vo);
		return result == 1;
	}//end insert
	
	public boolean replyUpdate(BoardVo vo) {
		int result = sqlSession.update("board.replyupdate", vo);
		return result == 1;
	}	

}
