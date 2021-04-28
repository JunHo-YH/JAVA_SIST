package com.sist.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class BoardService {
	@Resource(name="boardDAO")
	private BoardDAO bDao;
	@Resource(name="replyDAO")
	private ReplyDAO rDao;
	
	public List<BoardVO> boardListData(Map map) {
		return bDao.boardListData(map);
		
	}
	
	public int boardTotalPage() {
		return bDao.boardTotalPage();
	}
}
