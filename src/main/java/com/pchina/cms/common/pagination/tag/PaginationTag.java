package com.pchina.cms.common.pagination.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.pchina.cms.common.pagination.component.PaginationComponent;
import com.pchina.cms.common.pagination.component.PaginationComponentFactory;
import com.pchina.cms.common.pagination.model.PaginationList;



/**
 * 分页TAG
 * 
 * @author LOMI
 *
 */
public class PaginationTag extends SimpleTagSupport {

	// 引用分页列表
	private String modelRef;
	// form action url
	private String url;
	// 组件类型
	private String type;

	public String getModelRef() {
		return modelRef;
	}

	public void setModelRef(String modelRef) {
		this.modelRef = modelRef;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();

		PaginationList<?> paginatedList = (PaginationList<?>) this.getJspContext().findAttribute(this.getModelRef());

		PaginationComponent component = PaginationComponentFactory.buildComponent(this, paginatedList);
		try {
			component.render(this.getJspContext().getOut());
		} catch (IOException e) {
			throw new JspException(e);
		}
	}

}
