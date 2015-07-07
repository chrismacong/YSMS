package com.cwkj.ysms.wechat.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.cwkj.ysms.wechat.entity.ReceiveXmlEntity;

/**
 * @author Administrator
 * 解析微信端XML数据，转换为对象
 *
 */
public class ParseReceiveXml {
	/**
	 * 解析XML消息
	 * @param content
	 * @return
	 */
	public static ReceiveXmlEntity getMsgEntity(String content){
		ReceiveXmlEntity msg = null;
		try{
			//将字符串转换为xml对象
			Document doc = DocumentHelper.parseText(content);
			
			//获取文档根节点
			Element root = doc.getRootElement();
			
			//遍历根节点下所有子节点
			Iterator<?> iterator = root.elementIterator();
			
			//利用反射调用set方法
			Class<?> c = Class.forName("com.cwkj.ysms.wechat.entity.ReceiveXmlEntity");
			
			//创建实体类
			msg = (ReceiveXmlEntity)c.newInstance();
			
			while(iterator.hasNext()){
				Element ele = (Element) iterator.next();
				//获取set方法中的参数字段（实体类属性）
				Field field = c.getDeclaredField(ele.getName());
				//获取set方法
				Method method = c.getDeclaredMethod("set" + ele.getName(), field.getType());
				//调用set方法
				method.invoke(msg, ele.getText());
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return msg;
	}
}
