package com.spring.weather.domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface AjaxDAO {

	public List<WriteDTO> selectFromRow(
			@Param("from") int from,
			@Param("pageRows") int pageRows);
	
	// 전체 글의 개수
	public int countAll();
	
	// 글 읽기
	public List<WriteDTO> selectByUid(int uid);
	
	// 글작성
	public int insert(WriteDTO dto);
	
	// 글수정
	public int update(WriteDTO dto);

	// 특정 uid 글(들) 삭제하기
	public int deleteByUid(int [] uids);
}
