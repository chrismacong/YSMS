package com.cwkj.ysms.util;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 配置applicationContext，输出日志检测spring mvc是否启动成功
 * @author chrismacong
 * @since 2015-03-04
 *
 */
public class ThtApplicationContext implements ApplicationContextAware {
	private static final Logger logger = Logger.getLogger(ThtApplicationContext.class);
	private static ApplicationContext applicationContext = null;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		if (ThtApplicationContext.applicationContext == null) {
			ThtApplicationContext.applicationContext = applicationContext;
			logger.info(
					"========ApplicationContext配置成功,在普通类可以通过调用ToolSpring.getAppContext()获取applicationContext对象,applicationContext="
							+ applicationContext + "========");
		}
	}
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
	public static <T> T getBean(Class<T> requiredType)
	{
		return getApplicationContext().getBean(requiredType);
	}
}