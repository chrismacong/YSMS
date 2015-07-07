package com.cwkj.ysms.util;

/**
 * 分页信息辅助类，用于辅助完成分页创建，页设置等功能。
 * @author chrismacong
 * @since 2014-12-31
 *
 */
public class PageUtil {  

	public static Page createPage(int everyPage,int currentPage) {  
		everyPage = getEveryPage(everyPage);  
		currentPage = getCurrentPage(currentPage);  
		int beginIndex = getBeginIndex(everyPage, currentPage);  
		return new Page(everyPage, 0, 0, currentPage,  
				beginIndex, false,  false);  
	}  

	public static Page createPage(Page page,int totalCount) {  
		int everyPage = getEveryPage(page.getEveryPage());  
		int currentPage = getCurrentPage(page.getCurrentPage());  
		int totalPage = getTotalPage(everyPage, totalCount);  
		int beginIndex = getBeginIndex(everyPage, currentPage);  
		boolean hasPrePage = getHasPrePage(currentPage);  
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);  
		return new Page(everyPage, totalCount, totalPage, currentPage,  
				beginIndex, hasPrePage,  hasNextPage);  
	}  

	/**
	 * 获取每页显示记录数
	 * @param everyPage
	 * @return
	 */
	public static int getEveryPage(int everyPage) {  
		return everyPage == 0 ? 10 : everyPage;  
	}  

	/**
	 * 获取当前页
	 * @param currentPage
	 * @return
	 */
	public static int getCurrentPage(int currentPage) {  
		return currentPage == 0 ? 1 : currentPage;  
	}  

	/**
	 * 根据需要总记录数和每页显示的数量，获取总页数
	 * @param everyPage
	 * @param totalCount
	 * @return
	 */
	public static int getTotalPage(int everyPage,int totalCount) {  
		int totalPage = 0;  
		if(totalCount % everyPage == 0) {  
			totalPage = totalCount / everyPage;  
		} else {  
			totalPage = totalCount / everyPage + 1;  
		}  
		return totalPage;  
	}  

	/**
	 * 根据每页显示的数量和当前页，获取本页起始点
	 * @param everyPage
	 * @param currentPage
	 * @return
	 */
	public static int getBeginIndex(int everyPage,int currentPage) {  
		return (currentPage - 1) * everyPage;  
	}  

	/**
	 * 判断是否有上一页
	 * @param currentPage
	 * @return
	 */
	public static boolean getHasPrePage(int currentPage) {  
		return currentPage == 1 ? false : true;  
	}  

	/**
	 * 判断是否有下一页
	 * @param totalPage
	 * @param currentPage
	 * @return
	 */
	public static boolean getHasNextPage(int totalPage, int currentPage) {  
		return currentPage == totalPage || totalPage == 0 ? false : true;  
	}  

}  
