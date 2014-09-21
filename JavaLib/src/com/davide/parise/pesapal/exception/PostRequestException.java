/**
 * 
 */
package com.davide.parise.pesapal.exception;

/**
 * @author Davide Parise mailto:bubini.mara5@gmail.com
 * Sep 10, 2014
 *
 */
public class PostRequestException extends PesapalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1146022332752691348L;

	/**
	 * 
	 */
	public PostRequestException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param detailMessage
	 */
	public PostRequestException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param throwable
	 */
	public PostRequestException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param detailMessage
	 * @param throwable
	 */
	public PostRequestException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

}
