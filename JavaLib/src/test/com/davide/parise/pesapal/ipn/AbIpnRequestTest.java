/**
 * 
 */
package test.com.davide.parise.pesapal.ipn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.davide.parise.pesapal.exception.IpnRequestException;
import com.davide.parise.pesapal.exception.PesapalException;
import com.davide.parise.pesapal.ipn.AbIpnRequest;

/**
 * @author Davide Parise mailto:bubini.mara5@gmail.com
 * Sep 15, 2014
 *
 */
public class AbIpnRequestTest {

	String baseUrl = "http://www.demo.com";
	String param1 = "param1";
	String value1 = "value1";
	String param2 = "param2";
	String value2 = "value2";
	String valueID = "myDefaultValueID";
	String valueReference = "myDefaultValueReference";
	
	String url;
	AbIpnRequestForTest request = new AbIpnRequestForTest();
	class AbIpnRequestForTest extends AbIpnRequest{
		
		@Override
		public String getURL() throws PesapalException {
			// TODO Auto-generated method stub			
			return null;
		}
		
		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getReference() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		/* For Test */
		public String getParamFromUrlTest(String url,String param) throws IpnRequestException{
			return getParamFromUrl(url, param);
		}
		
		public String getDefaultIDParam(){
			return PARAM_TARCK_ID;
		}
		
		public String getDefaultReferenceParam(){
			return PARAM_MERCHANT_REFERECE;
		}
		public String getIDTest(String url) throws IpnRequestException{
			return getId(url);
		}
		public String getReferenceTest(String url) throws IpnRequestException{
			return getReference(url);
		}
	};
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		url = baseUrl;
		url = url.concat("?"+param1+"="+value1);
		url = url.concat("&"+param2+"="+value2);
		url = url.concat("&"+request.getDefaultIDParam()+ "="+ valueID);
		url = url.concat("&"+request.getDefaultReferenceParam()+"="+valueReference);
	}
	protected void tearDown() { 
		url = null;
	}
	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.AbIpnRequest#getParamFromUrl(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetParamFromUrl() {
		String value = "";
		try {
			assertNotNull(url);
			value = request.getParamFromUrlTest(url,param1);
			assertEquals("Param Value 1", value1,value);
			value = request.getParamFromUrlTest(url,param2);
			assertEquals("Param Value 2", value2,value);
			value = request.getParamFromUrlTest(baseUrl, param1);
			assertTrue("Param not empty",value.isEmpty());
		} catch (IpnRequestException e) {
			// TODO Auto-generated catch block
			fail("Exception "+e.getMessage());
		}
	
	}
	@Test(expected = IpnRequestException.class) 
	public void testGetParamFromUrlException() throws IpnRequestException{
			request.getParamFromUrlTest(null, param1);
	} 
	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.AbIpnRequest#getId(java.lang.String)}.
	 */
	@Test
	public void testGetIdString() {
		String value;
		try {
			value = request.getIDTest(url);
			assertEquals("ID not match", valueID,value);
		} catch (IpnRequestException e) {
			// TODO Auto-generated catch block
			fail("Exception Not expected: "+e.getMessage());
		}
	}
	@Test(expected = IpnRequestException.class)
	public void testGetIdStringException() throws IpnRequestException {
		 request.getReferenceTest(null);
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.ipn.AbIpnRequest#getReference(java.lang.String)}.
	 */
	@Test
	public void testGetReferenceString() {
		String value;
		try {
			value = request.getReferenceTest(url);
			assertEquals("Reference not match",valueReference,value);
		} catch (IpnRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Exception Not expected: "+e.getMessage());
		}
	}
	
	@Test(expected = IpnRequestException.class)
	public void testGetReferenceStringException() throws IpnRequestException {
		request.getReferenceTest("");
	}
}
