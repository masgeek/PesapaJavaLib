/**
 * 
 */
package com.davide.parise.pesapal;

import java.net.URL;

import com.davide.parise.pesapal.exception.PesapalException;


/**
 * @author Davide Parise mailto:bubini.mara5@gmail.com
 * Sep 10, 2014
 *
 */
public interface IRequest {

	/**
	 * Build a signed string with secret and key passed to the initialization of the Parse library
	 * 
	 * @return - the string signed of the request to send
	 * @throws PesapalException 
	 */
	public String getURL() throws PesapalException;
	
	/**
	 * Convenience method for get the string returned by getURL() as  URL
	 * For max detail and handle exception is good to retrieve the URL by getUrl() method 
	 * and than build the URL instance.
	 * 
	 * @return - the getURL() result as instance of URL 
	 * @throws PesapalException - if an exception occur. re-throw exception when encounter the MalformedUrlException 
	 */
	public URL get() throws PesapalException;
}
