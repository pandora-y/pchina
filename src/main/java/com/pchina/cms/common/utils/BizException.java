package com.pchina.cms.common.utils; 
/** 
* @author chengjing.yang E-mail: 
* @version 创建时间：2017年7月4日 上午9:19:55 
* 异常类
*/
public class BizException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message,  cause);
    }
}
 