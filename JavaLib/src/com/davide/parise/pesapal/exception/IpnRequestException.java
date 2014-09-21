/**
 * 
 */
package com.davide.parise.pesapal.exception;

/**
 * @author Davide Parise mailto:bubini.mara5@gmail.com
 * Sep 11, 2014
 *
 */
public class IpnRequestException extends PesapalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7159535116461873714L;

	/**
	 * 
	 */
	public IpnRequestException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param detailMessage
	 */
	public IpnRequestException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param throwable
	 */
	public IpnRequestException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param detailMessage
	 * @param throwable
	 */
	public IpnRequestException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

}
