package com.spring.weather.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.weather.domain.AjaxDAO;
import com.spring.weather.domain.WriteDTO;

@Service
public class AjaxService {
	AjaxDAO dao;
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<WriteDTO> list(int from, int pageRows){
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.selectFromRow(from, pageRows);
	}
	
	public int count() {
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.countAll();
	}
	
	public List<WriteDTO> viewByUid(int uid){
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.selectByUid(uid);
	}
	
	public List<WriteDTO> selectByUid(int uid){
		dao = sqlSession.getMapper(AjaxDAO.class);  // MyBaris
		return dao.selectByUid(uid);				// 1개 짜리 List
	}
	
	public int write(WriteDTO dto) {
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.insert(dto);
	}
	
	public int update(WriteDTO dto) {
		dao = sqlSession.getMapper(AjaxDAO.class);
		Integer uid = dto.getW_uid();
		
		
		return dao.update(dto);
	}
	
	public int deleteByUid(int [] uids) {
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.deleteByUid(uids);
	}
}
