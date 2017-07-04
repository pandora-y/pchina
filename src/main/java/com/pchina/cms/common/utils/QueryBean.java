package com.pchina.cms.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LOMI
 *
 */
public class QueryBean {

	public static final String DESC_ORDER = " DESC ";
	public static final String ASC_ORDER = " ASC ";
	protected Integer pageSize = 10;
	protected Integer currentPage = 1;
	protected Integer totalCount = 0;
	protected List<String> orderByProperties;
	
	public QueryBean(){}
	
	public QueryBean(Integer pageSize, Integer currentPage){
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	/**  
	 * pageSize  
	 *  
	 * @return  the pageSize 
	 *
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**  
	 * @param pageSize the pageSize to set  
	 *
	 */
	public QueryBean setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	/**  
	 * currentPage  
	 *  
	 * @return  the currentPage 
	 *
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**  
	 * @param currentPage the currentPage to set  
	 *
	 */
	public QueryBean setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		return this;
	}

	public int getStartIndex() {
		if(!this.totalCount.equals(0)){
			Double maxPageDouble=Math.ceil((double)this.totalCount/this.pageSize);
			int maxPage=maxPageDouble.intValue();
			currentPage=currentPage>maxPage?maxPage:currentPage;
		}
		return (currentPage - 1) * pageSize;
	}

	public String getReversedFiled() {
		StringBuffer buffer = new StringBuffer();
		boolean isFirst = true;
		if (this.orderByProperties == null) {
			return "";
		}
		for(String prop : this.orderByProperties){
			if(!isFirst){
				buffer.append(",");
			}
			if(prop.contains(DESC_ORDER)){
				buffer.append(prop.replaceAll(DESC_ORDER, ASC_ORDER));
			}else{
				buffer.append(prop.replaceAll(ASC_ORDER, DESC_ORDER));
			}
			isFirst = false;
		}
		return buffer.toString();
	}

	public String getOrderByField() {
		StringBuffer buffer = new StringBuffer();
		boolean isFirst = true;
		if (this.orderByProperties == null) {
			return "";
		}
		for(String prop : this.orderByProperties){
			if(!isFirst){
				buffer.append(",");
			}
			buffer.append(prop);
			isFirst = false;
		}
		return buffer.toString();
	}

	/**  
	 * appendListProp
	 * @方法作用
	 * 向buffer 中追加list的值生成 缓存key时候使用
	 *  
	 * @param buffer
	 *   
	 * void  
	 * @exception   
	*/
	@SuppressWarnings("rawtypes")
	protected void appendListProp(List list, String sign, StringBuffer buffer) {
		if(list == null || list.isEmpty()){
			buffer.append(sign);
		}else{
			for(Object obj : list){
				buffer.append(obj.toString());
			}
		}
	}

	public List<String> getOrderByProperties() {
		return orderByProperties;
	}

	public void setOrderByProperties(List<String> orderByProperties) {
		this.orderByProperties = orderByProperties;
	}

	/**  
	 * totalCount  
	 *  
	 * @return  the totalCount 
	 *
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**  
	 * @param totalCount the totalCount to set  
	 *
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	public QueryBean addDescProperty(String property){
		if(orderByProperties == null){
			orderByProperties = new ArrayList<String>();
		}
		orderByProperties.add(property + DESC_ORDER); 
		return this;
	}
	
	public QueryBean addAscProperty(String property){
		if(orderByProperties == null){
			orderByProperties = new ArrayList<String>();
		}
		orderByProperties.add(property + ASC_ORDER); 
		return this;
	}

	public Integer getEndIndex() {
		Integer curEnd = this.pageSize * this.currentPage;
		if(totalCount == 0){
			return curEnd;
		}
		return curEnd > totalCount ? totalCount : curEnd;
	}

}
