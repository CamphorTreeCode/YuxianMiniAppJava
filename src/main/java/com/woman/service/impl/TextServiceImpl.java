package com.woman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woman.dao.textMapper;
import com.woman.pojo.text;
import com.women.service.TextService;
@Service
public class TextServiceImpl implements TextService{
	@Autowired
    textMapper textMapper;
	@Override
	public int updateText(text t) {
		// TODO Auto-generated method stub
		if(t.getTextid()==null){
			textMapper.insert(t);
			return 0;
		}
		else{
			textMapper.updateByPrimaryKeySelective(t);
			return 1;
		}
	   
	}

	@Override
	public text getByType(int type) {
		// TODO Auto-generated method stub
		return textMapper.getByType(type);
	}

}
