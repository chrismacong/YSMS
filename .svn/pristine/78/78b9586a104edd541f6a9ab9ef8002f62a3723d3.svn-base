package com.cwkj.ysms.basedao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cwkj.ysms.basedao.GenericDao;
import com.cwkj.ysms.util.Page;

/**
 * GenericDao的实现类，作为所有dao层实现类的父类
 * @author chrismacong
 * @since 2015-03-04
 *
 */
@Repository 
@Transactional(rollbackFor=Exception.class) 
public class GenericDaoImpl implements GenericDao{
	@Resource 
	private SessionFactory sessionFactory;
	
	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Object> findByHQL(String hql) {
		// TODO Auto-generated method stub
		try
		{
			Query queryObject = this.sessionFactory.getCurrentSession()
					.createQuery(hql);
			return queryObject.list();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	@Override
	public List<Object> findByHQLAndLimit(String hql, int limitIndex) {
		// TODO Auto-generated method stub
		try
		{
			Query queryObject = this.sessionFactory.getCurrentSession()
					.createQuery(hql).setMaxResults(limitIndex);
			return queryObject.list();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	@Override
	public List<Object> findByHQLAndPage(String hql, Page page) {
		// TODO Auto-generated method stub
		try
		{
			Query queryObject = this.sessionFactory.getCurrentSession()
					.createQuery(hql);
			queryObject.setMaxResults(page.getEveryPage());
			queryObject.setFirstResult(page.getBeginIndex());
			return queryObject.list();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	@Override
	public int getHqlRecordCount(String hqlStr) {  
        int fromIndex = hqlStr.indexOf("from");  
        String hql = "select count(*) " + hqlStr.substring(fromIndex);  
        Query query = this.sessionFactory.getCurrentSession()
				.createQuery(hql);
        return ((Long)query.uniqueResult()).intValue();  
    }  
}
