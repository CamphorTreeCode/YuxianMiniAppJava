package com.women.service;

import java.util.List;

import com.woman.pojo.text;

public interface TextService {
	
	public int updateText(text t);
	
	public text getByType(int type);

	public List<text> selectAll();
}
