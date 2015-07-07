package com.cwkj.ysms.basedao;

import java.util.List;

import org.hibernate.Session;

import com.cwkj.ysms.util.Page;

/**
 * Dao层统一父类的接口
 * @author chrismacong
 * @since 2015-03-04
 */
public interface GenericDao {
	/**
	 * 获取当前session
	 * @return
	 */
	public Session getSession();
	/**
	 * 根据hql语句执行查询
	 * @param hql HQL语句
	 * @return
	 * @throws Exception
	 */
	public List<Object> findByHQL(String hql);
	/**
	 * 根据hql和limit数量执行查询
	 * @param hql HQL语句
	 * @param limit_index 查询条目的数量
	 * @return
	 * @throws Exception
	 */
	public List<Object> findByHQLAndLimit(String hql, int limitIndex) ;
	/**
	 * 根据hql和page获取分页数据，用于分页查询
	 * page只需要通过单参构造方法，设置每页显示数即可。起始值默认设置为1.
	 * @param hql
	 * @param page
	 * @return
	 */
	public List<Object> findByHQLAndPage(String hql, final Page page);
	
	/**
	 * 获取某条hql中的总数，用于分页
	 * @param hqlStr
	 * @return
	 */
	public int getHqlRecordCount(String hqlStr);
}
