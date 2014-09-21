/**
 * 
 */
package test.com.davide.parise.pesapal.ipn;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davide.parise.pesapal.ApiUrlConstants;
import com.davide.parise.pesapal.Pesapal;
import com.davide.parise.pesapal.exception.IpnRequestException;
import com.davide.parise.pesapal.exception.PesapalException;
import com.davide.parise.pesapal.ipn.IpnRequestStatusDetail;

/**
 * @author Davide Parise mailto:bubini.mara5@gmail.com
 * Sep 19, 2014
 *
 */
public class IpnRequestStatusDetailTest {

	private final String realId = "8852fab4-f542-4d96-9107-7602d1567c6f";
	private final String realRef = "S6MLEd9XiF";
	
	IpnRequestStatusDetail request;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Pesapal.initialize("key", "secret");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		request  = null;
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatusDetail#getId()}.
	 */
	@Test
	public void testGetId() {
		request = new IpnRequestStatusDetail(realId, realRef);
		assertNotNull(request);
		assertEquals("Id not match ",realId,request.getId());
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatusDetail#getReference()}.
	 */
	@Test
	public void testGetReference() {
		request = new IpnRequestStatusDetail(realId, realRef);
		assertNotNull(request);
		assertEquals("Reference not match ",realRef,request.getReference());
		
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatusDetail#IpnRequestStatusDetail(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testIpnRequestStatusDetail() {
		request = new IpnRequestStatusDetail(realId, realRef);
		assertNotNull(request);
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatusDetail#getURL()}.
	 * @throws PesapalException 
	 */
	@Test
	public void testGetURL() throws PesapalException {
		request = new IpnRequestStatusDetail(realId, realRef);
		assertNotNull(request);
		String url;
		
		Pesapal.setDEMO(true);
		url = request.getURL();
		assertNotNull(url);
		assertTrue("Ulr is empty",!url.isEmpty());
		assertTrue("Url is invalid",url.startsWith(ApiUrlConstants.IPN_STATUS_DETAIL.url_demo));
		
		Pesapal.setDEMO(false);
		url = request.getURL();
		assertNotNull(url);
		assertTrue("Ulr is empty",!url.isEmpty());
		assertTrue("Url is invalid",url.startsWith(ApiUrlConstants.IPN_STATUS_DETAIL.url_live));

	}
	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatusDetail#getURL()}.
	 * @throws PesapalException 
	 */
	@Test(expected = IpnRequestException.class)
	public void testGetURLException() throws PesapalException {
		request = new IpnRequestStatusDetail("", realRef);
		assertNotNull(request);
		request.getURL();

	}

}
