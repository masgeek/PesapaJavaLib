/**
 * 
 */
package test.com.davide.parise.pesapal.ipn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import oauth.signpost.OAuth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davide.parise.pesapal.ApiUrlConstants;
import com.davide.parise.pesapal.Pesapal;
import com.davide.parise.pesapal.exception.IpnRequestException;
import com.davide.parise.pesapal.exception.PesapalException;
import com.davide.parise.pesapal.ipn.IpnRequestStatus;

/**
 * @author Davide Parise mailto:bubini.mara5@gmail.com
 * Sep 15, 2014
 *
 */
public class IpnRequestStatusTest {

	private final String realCallback = " http://demo.pesapal.com/api/postpesapaldirectorderv4/apiredirecttoparenturl"
			+ "?pesapal_transaction_tracking_id%3D8852fab4-f542-4d96-9107-7602d1567c6f%26"
			+ "pesapal_merchant_reference%3DS6MLEd9XiF";
		
	private final String realId = "8852fab4-f542-4d96-9107-7602d1567c6f";
	private final String realRef = "S6MLEd9XiF";
	
	IpnRequestStatus request;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Pesapal.initialize("mykey", "secret");
	}

	@After
	public void tearDown() throws Exception{
		request = null;
	}
	
	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatus#getId()}.
	 * @throws IpnRequestException 
	 */
	@Test
	public void testGetId() throws IpnRequestException {
		String callback = OAuth.percentDecode(realCallback);
		request = new IpnRequestStatus(callback);
		assertEquals("Id no match", realId,request.getId());
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatus#getReference()}.
	 * @throws IpnRequestException 
	 */
	@Test
	public void testGetReference() throws IpnRequestException {
		String callback = OAuth.percentDecode(realCallback);
		request = new IpnRequestStatus(callback);
		assertEquals("Reference no match", realRef,request.getReference());

	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatus#IpnRequestStatus(java.lang.String, java.lang.String)}.
	 * @throws IpnRequestException 
	 */
	@Test
	public void testIpnRequestStatus() throws IpnRequestException {
		request = new IpnRequestStatus(realCallback);
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatus#getURL()}.
	 * @throws PesapalException 
	 */
	@Test
	public void testGetURL() throws PesapalException {
		String callback = OAuth.percentDecode(realCallback);
		Pesapal.setDEMO(true);
		request = new IpnRequestStatus(callback);
		String url = request.getURL();
		assertNotNull("URL is null", url);
		assertFalse("Url is empty",url.isEmpty());
		assertTrue("Url is invalid",url.startsWith(ApiUrlConstants.IPN_STATUS.url_demo));
		
		Pesapal.setDEMO(false);
		request = new IpnRequestStatus(callback);
		url = request.getURL();
		assertNotNull("URL is null", url);
		assertFalse("Url is empty",url.isEmpty());
		assertTrue("Url is invalid",url.startsWith(ApiUrlConstants.IPN_STATUS.url_live));

	}

}
