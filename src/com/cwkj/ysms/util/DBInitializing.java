package com.cwkj.ysms.util;

import org.springframework.beans.factory.InitializingBean;

/**
 * Spring MVC启动时默认加载的类，用于数据和线程池的初始化操作
 * 已在applicationContext中进行配置? * @author chrismacong
 * @since 2015-03-04
 *
 */
public class DBInitializing implements InitializingBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	public void tcpInit() throws Exception{
		EMSysThread thread = new EMSysThread();
		thread.start();
	}
}
class EMSysThread extends Thread{
	public void run(){
		//此处添加数据库初始化代码，比如默认的用户名和密码
	}
}