package org.thcic.xapx.exception;

/**
 * Jdbc异常类
 * 
 * @author <a href="mailto:zwangli@hotmail.com">郑王力</a>
 * @since 2006-9-4 上午11:01:52
 * @version 1.0
 */
public class JdbcException extends AppException {

	private static final long serialVersionUID = -9115422190134712141L;

	public JdbcException(String message) {
		super(message);
	}

	public JdbcException(String message, Throwable cause) {
		super(message, cause);
	}

}