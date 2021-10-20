package com.douzone.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.PageVo;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	public List<BoardVo> findall(Long pno) {
		Long no = (pno-1)*5;
		return boardRepository.findAll(no);
	}

	public void delete(Long no) {
		// TODO Auto-generated method stub
		boardRepository.delete(no);
	}

	public BoardVo view(Long no) {
		return boardRepository.findByTableNo(no);
	}

	public boolean update(BoardVo vo) {
		// TODO Auto-generated method stub
		return boardRepository.update(vo);
	}

	public boolean write(BoardVo vo) {
		// TODO Auto-generated method stub
		return boardRepository.insert(vo);
	}

	public boolean viewcount(Long no) {
		// TODO Auto-generated method stub
		return boardRepository.hitupdate(no);
	}

	public BoardVo reply(Long no) {
		// TODO Auto-generated method stub
		return boardRepository.findByTableNo(no);
	}

	public void replyadd(BoardVo vo) {
		// TODO Auto-generated method stub
		boardRepository.replyInsert(vo);
	}
	public PageVo findcount(Long pno) {
		// TODO Auto-generated method stub
		PageVo count = boardRepository.findcount();
		System.out.println("총 게시물 갯수 : "+count.toString());
		Long totalcount = count.getTotalCount();
		if(totalcount % 5 >0) {
			Long viewCount = totalcount/5+1;
			count.setViewCount(viewCount);
		}else {
			Long viewCount = totalcount/5;
			count.setViewCount(viewCount);
		}
		count.setPage(pno);
		count.setFirstViewCount(pno);
		count.setEndViewCount((count.getFirstViewCount()-1)+5);
		return count;
	}
	public PageVo findcounts(Long pno,Long firstView) {
		// TODO Auto-generated method stub
		PageVo count = boardRepository.findcount();
		System.out.println("총 게시물 갯수 : "+count.toString());
		Long totalcount = count.getTotalCount();
		if(totalcount % 5 >0) {
			Long viewCount = totalcount/5+1;
			count.setViewCount(viewCount);
		}else {
			Long viewCount = totalcount/5;
			count.setViewCount(viewCount);
		}
		count.setPage(pno);
		count.setFirstViewCount(firstView);
		count.setEndViewCount((count.getFirstViewCount()-1)+5);
		return count;
	}
}
