package org.thcic.xapx.exception;


/**
 * 整个框架根异常类。<br>
 * 推荐python风格的异常处理：root Exception继承自RuntimeException，但在方法接口上显式声明这些异常。<br>
 * 这样做有如下好处：<br>
 * <ol>
 * <li>类似checked exception，从接口即可看出会发生哪些异常</li>
 * <li>调用方不强制处理异常。而且，接口的异常声明改变也不会影响到调用方代码</li>
 * <ol>
 * 
 * 
 * @author <a href="mailto:zwangli@hotmail.com">郑王力</a>
 */
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 2376627903957963613L;

	public AppException(String message) {
		super(message);
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}
}
