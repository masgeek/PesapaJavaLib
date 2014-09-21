/**
 * 
 */
package test.com.davide.parise.pesapal.ipn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davide.parise.pesapal.Pesapal;
import com.davide.parise.pesapal.exception.IpnRequestException;
import com.davide.parise.pesapal.exception.PesapalException;
import com.davide.parise.pesapal.ipn.AbIpnRequest;
import com.davide.parise.pesapal.ipn.DefaultIpnRequest;

/**
 * @author Davide Parise mailto:bubini.mara5@gmail.com
 * Sep 15, 2014
 *
 */
public class DefaultIpnRequestTest {

	private final String realCallback= "http://demo.pesapal.com/api/querypaymentstatus?"
			+ "pesapal_transaction_tracking_id=8852fab4-f542-4d96-9107-7602d1567c6f"
			+ "&pesapal_merchant_reference=S6MLEd9XiF";
	
	private final String realId = "8852fab4-f542-4d96-9107-7602d1567c6f";
	private final String realRef = "S6MLEd9XiF";

	DefaultIpnRequest request;
	String id = "MyId";
	String reference = "Reference";

	@Before
	public void setUp() throws Exception{
		Pesapal.initialize("key", "secret");
	}

	@After
	public void tearDown() throws Exception{
		request = null;
	}
	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.DefaultIpnRequest#DefaultIpnRequest(java.lang.String)}.
	 * @throws IpnRequestException 
	 */
	@Test
	public void testDefaultIpnRequest() throws IpnRequestException {
		
		String url = Pesapal.getDefaultCallback();
		url = url.concat("?"+AbIpnRequest.PARAM_MERCHANT_REFERECE+"="+reference);
		url = url.concat("&"+AbIpnRequest.PARAM_TARCK_ID+"="+id);
		
		request = new DefaultIpnRequest(url);
		try {
			String result = request.getURL();
			assertNotEquals("Url is not signed ",result.isEmpty());
			assertEquals("ID is not valid ",id,request.getId());
			assertEquals("Referece is not valid ",reference,request.getReference());
		} catch (PesapalException e) {
			// TODO Auto-generated catch block
			fail("Exception not expected "+e.getMessage());
		}
	}

	@Test(expected = IpnRequestException.class)
	public void testDefaultIpnRequsetException() throws PesapalException{
		request = new DefaultIpnRequest("http://www.demo.com");
		request.getURL();
	}
	
	@Test(expected = IpnRequestException.class)
	public void testDefaultIpnRequsetWithoutIDException() throws PesapalException{
		String url = Pesapal.getDefaultCallback();
		url = url.concat("?"+AbIpnRequest.PARAM_MERCHANT_REFERECE+"="+reference);
		
		request = new DefaultIpnRequest(url);
		request.getURL();
	}
	
	@Test(expected = IpnRequestException.class)
	public void testDefaultIpnRequsetWithoutParamsException() throws PesapalException{
		String url = Pesapal.getDefaultCallback();
		
		request = new DefaultIpnRequest(url);
		request.getURL();
	}
	
	
	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatus#getId()}.
	 * @throws IpnRequestException 
	 */
	@Test
	public void testGetId() throws IpnRequestException {
		request = new DefaultIpnRequest(realCallback);
		assertEquals("Id no match", realId,request.getId());
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatus#getReference()}.
	 * @throws IpnRequestException 
	 */
	@Test
	public void testGetReference() throws IpnRequestException {
		request = new DefaultIpnRequest(realCallback);
		assertEquals("Reference no match", realRef,request.getReference());

	}

}
