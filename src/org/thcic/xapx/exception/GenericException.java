/**
 * 
 */
package org.thcic.xapx.exception;

/**
 * @author zhangyu octopusthu@gmail.com
 */
public class GenericException extends RuntimeException {
	private static final long serialVersionUID = -9095858712549150894L;
	private String msg;

	public GenericException(String msg) {
		setMsg(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
