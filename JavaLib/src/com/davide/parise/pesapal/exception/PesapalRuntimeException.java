/**
 * 
 */
package com.davide.parise.pesapal.exception;

/**
 * @author Davide Parise mailto:bubini.mara5@gmail.com
 * Sep 10, 2014
 *
 */
public class PesapalRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2898423848610915504L;

	/**
	 * 
	 */
	public PesapalRuntimeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param detailMessage
	 * @param throwable
	 */
	public PesapalRuntimeException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param detailMessage
	 */
	public PesapalRuntimeException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param throwable
	 */
	public PesapalRuntimeException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	
}
