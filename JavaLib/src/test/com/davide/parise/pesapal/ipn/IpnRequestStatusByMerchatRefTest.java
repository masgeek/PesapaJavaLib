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
import com.davide.parise.pesapal.ipn.IpnRequestStatusByMerchatRef;

/**
 * @author Davide Parise mailto:bubini.mara5@gmail.com
 * Sep 19, 2014
 *
 */
public class IpnRequestStatusByMerchatRefTest {

	private final String realRef = "S6MLEd9XiF";
	
	IpnRequestStatusByMerchatRef request;
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
		request = null;
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatusByMerchatRef#getId()}.
	 */
	@Test
	public void testGetId() {
		request = new IpnRequestStatusByMerchatRef(realRef);
		assertNotNull("Request instance is null",request);
		assertTrue("id no match",request.getId().isEmpty());
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatusByMerchatRef#getReference()}.
	 */
	@Test
	public void testGetReference() {
		request = new IpnRequestStatusByMerchatRef(realRef);
		assertNotNull("Request instance is null",request);
		assertEquals("reference no match",realRef,request.getReference());
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatusByMerchatRef#IpnRequestStatusByMerchatRef(java.lang.String)}.
	 */
	@Test
	public void testIpnRequestStatusByMerchatRef() {
		request = new IpnRequestStatusByMerchatRef(realRef);
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.IpnRequestStatusByMerchatRef#getURL()}.
	 * @throws PesapalException 
	 */
	@Test
	public void testGetURL() throws PesapalException {
		request = new IpnRequestStatusByMerchatRef(realRef);
		Pesapal.setDEMO(true);
		String url = request.getURL();
		assertNotNull(url);
		assertTrue("Url is empty",!url.isEmpty());
		assertTrue("Url is invalid in demo mode",url.startsWith(ApiUrlConstants.IPN_STATUS_REF.url_demo));

		Pesapal.setDEMO(false);
		url = request.getURL();
		assertNotNull(url);
		assertTrue("Url is empty",!url.isEmpty());
		assertTrue("Url is invalid in demo mode",url.startsWith(ApiUrlConstants.IPN_STATUS_REF.url_live));

	}

	@Test(expected = IpnRequestException.class)
	public void testGetURLException() throws PesapalException{
		request = new IpnRequestStatusByMerchatRef("");
		request.getURL();
	}
}
