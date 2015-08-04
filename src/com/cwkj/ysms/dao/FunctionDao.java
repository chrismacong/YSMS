package com.cwkj.ysms.dao;

import java.util.List;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.model.YsmsFunction;

public interface FunctionDao extends GenericDao  {
	public YsmsFunction findById(int functionId);
	
	public List<YsmsFunction> findAll();
}
