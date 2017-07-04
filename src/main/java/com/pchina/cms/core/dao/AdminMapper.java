package com.pchina.cms.core.dao;

import com.pchina.cms.core.model.Admin;

public interface AdminMapper {
	public Admin findByAdmin(String username) throws Exception;
}
