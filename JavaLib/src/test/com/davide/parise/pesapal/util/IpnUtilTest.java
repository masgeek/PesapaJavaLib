/**
 * 
 */
package test.com.davide.parise.pesapal.util;

import static org.junit.Assert.*;

import java.util.Map;

import oauth.signpost.OAuth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davide.parise.pesapal.Pesapal;
import com.davide.parise.pesapal.exception.IpnRequestException;
import com.davide.parise.pesapal.exception.PesapalException;
import com.davide.parise.pesapal.ipn.AbIpnRequest;
import com.davide.parise.pesapal.ipn.DefaultIpnRequest;
import com.davide.parise.pesapal.util.IpnUtil;

/**
 * @author Davide Parise mailto:bubini.mara5@gmail.com
 * Sep 15, 2014
 *
 */
public class IpnUtilTest {

	private String realCallback =" http://demo.pesapal.com/api/postpesapaldirectorderv4/apiredirecttoparenturl?"
			+ "url=http%3A%2F%2Fdemo.pesapal.com%2Fapi%2Fquerypaymentstatus"
			+ "%3Fpesapal_transaction_tracking_id"
			+ "%3D8852fab4-f542-4d96-9107-7602d1567c6f"
			+ "%26pesapal_merchant_reference%3DS6MLEd9XiF";
	
	private String decodedCallback = "http://demo.pesapal.com/api/postpesapaldirectorderv4/apiredirecttoparenturl?"
			+ "url=http://demo.pesapal.com/api/querypaymentstatus?"
			+ "pesapal_transaction_tracking_id=8852fab4-f542-4d96-9107-7602d1567c6f&"
			+ "pesapal_merchant_reference=S6MLEd9XiF";
	
	private final String realId = "8852fab4-f542-4d96-9107-7602d1567c6f";
	private final String realRef = "S6MLEd9XiF";
	
	private String normalURL="http://www.domain.com/sub/index.php";
	
	DefaultIpnRequest request;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Pesapal.initialize("key", "secret");
		Pesapal.setDEMO(true);
		
		String paramsNormalUrl = String.format("?%s=%s&params1=pippo&%s=%s&params2=pippo2",AbIpnRequest.PARAM_TARCK_ID,realId,AbIpnRequest.PARAM_MERCHANT_REFERECE,realRef);
		normalURL = normalURL.concat(paramsNormalUrl);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		request = null;
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.util.IpnUtil#createFromCallback(java.lang.String)}.
	 * @throws IpnRequestException 
	 */
	@Test
	public void testCreateFromCallback() throws IpnRequestException {
		String callback = OAuth.percentDecode(realCallback);
		request = IpnUtil.createFromCallback(callback);
		
		assertNotNull("Request is NUll",request);
		assertEquals("Id mismatch ",realId,request.getId());
		assertEquals("Reference mismatch ",realRef,request.getReference());
		
		callback = OAuth.percentDecode(decodedCallback);
		request = IpnUtil.createFromCallback(callback);
		
		assertNotNull("Request is NUll",request);
		assertEquals("Id mismatch ",realId,request.getId());
		assertEquals("Reference mismatch ",realRef,request.getReference());
	}
	/**
	 * Test method for {@link com.davide.parise.pesapal.util.IpnUtil#createFromCallback(java.lang.String)}.
	 * @throws PesapalException 
	 */
	@Test(expected = IpnRequestException.class)
	public void testCreateFromCallbackException() throws PesapalException {
		String callback = OAuth.percentDecode(null);
		request = IpnUtil.createFromCallback(callback);
	
		request.getURL();
	}
	
	/**
	 * Test method for {@link com.davide.parise.pesapal.util.IpnUtil#createFromCallback(java.lang.String)}.
	 * @throws PesapalException 
	 */
	@Test(expected = IpnRequestException.class)
	public void testCreateFromCallbackExceptionGetUrl() throws PesapalException {
		String callback = OAuth.percentDecode("www.google.com?fake=");
		request = IpnUtil.createFromCallback(callback);
		request.getURL();
	}

	
	@Test
	public void testCreateFromCallbackGetURL() throws PesapalException {
		String callback = OAuth.percentDecode(realCallback);
		request = IpnUtil.createFromCallback(callback);
		assertNotNull("Request is NUll",request);
		assertEquals("Id mismatch ",realId,request.getId());
		assertEquals("Reference mismatch ",realRef,request.getReference());
		
		String url = request.getURL();
		assertNotNull("URL is null",url);
		assertTrue("URL is empty",!url.isEmpty());
		
	}
	
	@Test
	public void testGetIpnParamsFromUrl() throws IpnRequestException{
		Map<String, String> map = IpnUtil.getIpnParamsFromUrl(normalURL);
		
		assertNotNull("params are null",map);
		assertTrue("params are empty",!map.isEmpty());
		
		assertTrue("not contain id",map.containsKey(AbIpnRequest.PARAM_TARCK_ID));
		assertTrue("not contain reference",map.containsKey(AbIpnRequest.PARAM_MERCHANT_REFERECE));
		
		assertEquals("Id not match",realId,map.get(AbIpnRequest.PARAM_TARCK_ID));
		assertEquals("Reference not match",realRef,map.get(AbIpnRequest.PARAM_MERCHANT_REFERECE));
	}
	
	@Test(expected = IpnRequestException.class)
	public void testGetIpnParamsFromUrlException() throws IpnRequestException{
		IpnUtil.getIpnParamsFromUrl("www.domain.com");
	}
}
