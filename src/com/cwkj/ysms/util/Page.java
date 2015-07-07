package com.cwkj.ysms.util;

/**
 * 分页类，用于分页，与PageUtil配合使用。
 * @author chrismacong
 * @since 2014-12-31
 *
 */
public class Page {  
	// 1.每页显示数量(everyPage)  
	private int everyPage;  
	// 2.总记录数(totalCount)  
	private int totalCount;  
	// 3.总页数(totalPage)  
	private int totalPage;  
	// 4.当前页(currentPage)  
	private int currentPage;  
	// 5.起始点(beginIndex)  
	private int beginIndex;  
	// 6.是否有上一页(hasPrePage)  
	private boolean hasPrePage;  
	// 7.是否有下一页(hasNextPage)  
	private boolean hasNextPage;  

	/**
	 * 构造方法，在初始化分页功能时使用。根据每页显示数创建page，起始点默认设置为1
	 * @param everyPage
	 */
	public Page(int everyPage){
		this.everyPage = everyPage;
		this.beginIndex = 1;
	}
	/**
	 * 构造方法，对所有属性进行设置
	 * @param everyPage
	 * @param totalCount
	 * @param totalPage
	 * @param currentPage
	 * @param beginIndex
	 * @param hasPrePage
	 * @param hasNextPage
	 */
	public Page(int everyPage, int totalCount, int totalPage, int currentPage,  
			int beginIndex, boolean hasPrePage, boolean hasNextPage) {  
		this.everyPage = everyPage;  
		this.totalCount = totalCount;  
		this.totalPage = totalPage;  
		this.currentPage = currentPage;  
		this.beginIndex = beginIndex;  
		this.hasPrePage = hasPrePage;  
		this.hasNextPage = hasNextPage;  
	}  

	/**
	 * Page默认构造方法
	 */
	public Page(){}  


	public int getEveryPage() {  
		return everyPage;  
	}  

	public void setEveryPage(int everyPage) {  
		this.everyPage = everyPage;  
	}  

	public int getTotalCount() {  
		return totalCount;  
	}  

	public void setTotalCount(int totalCount) {  
		this.totalCount = totalCount;  
	}  

	public int getTotalPage() {  
		return totalPage;  
	}  

	public void setTotalPage(int totalPage) {  
		this.totalPage = totalPage;  
	}  

	public int getCurrentPage() {  
		return currentPage;  
	}  

	public void setCurrentPage(int currentPage) {  
		this.currentPage = currentPage;  
	}  

	public int getBeginIndex() {  
		return beginIndex;  
	}  

	public void setBeginIndex(int beginIndex) {  
		this.beginIndex = beginIndex;  
	}  

	public boolean isHasPrePage() {  
		return hasPrePage;  
	}  

	public void setHasPrePage(boolean hasPrePage) {  
		this.hasPrePage = hasPrePage;  
	}  

	public boolean isHasNextPage() {  
		return hasNextPage;  
	}  

	public void setHasNextPage(boolean hasNextPage) {  
		this.hasNextPage = hasNextPage;  
	}  

}  