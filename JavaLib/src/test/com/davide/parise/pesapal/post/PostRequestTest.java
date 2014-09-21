/**
 * 
 */
package test.com.davide.parise.pesapal.post;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davide.parise.pesapal.ApiUrlConstants;
import com.davide.parise.pesapal.Pesapal;
import com.davide.parise.pesapal.exception.PostRequestException;
import com.davide.parise.pesapal.post.PostRequest;

/**
 * @author Davide Parise mailto:bubini.mara5@gmail.com
 * Sep 15, 2014
 *
 */
public class PostRequestTest {

	PostRequest request;
	private String amount = "1000";
	private String description = "description";
	private String lName;
	private String fName;
	private String mail;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Pesapal.initialize("key", "secret");
		Pesapal.setDEMO(false);
	}
	
	@After
	public void tearDown(){
		request = null;
	}

	private PostRequest create(){
		PostRequest.Builder builder = new PostRequest.Builder();
		builder.amount(amount );
		builder.description(description );
		builder.name(fName, lName);
		builder.mail(mail);
		builder.isMobile(false);
		return builder.build();
	}
	/**
	 * Test method for {@link com.davide.parise.pesapal.post.PostRequest#getURL()}.
	 * @throws PostRequestException 
	 */
	@Test
	public void testGetURL() throws PostRequestException {	
		request = create();
		
		assertNotNull(request);
		String url;
	
		url = request.getURL();
		assertNotNull("Url is null");
		assertTrue("Url not mathc",url.startsWith(ApiUrlConstants.POST.url_live));

	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.post.PostRequest#getCallback()}.
	 */
	@Test
	public void testGetCallback() {
		request = create();
		assertNotNull(request);
		assertEquals("Callback not match",ApiUrlConstants.CALLBACK.callback_live,request.getCallback());
		
		String callback = "http://www.domain.com";
		PostRequest.Builder builder = new PostRequest.Builder();
		builder.amount(amount );
		builder.description(description );
		builder.name(fName, lName);
		builder.mail(mail);
		builder.callback(callback);
		builder.isMobile(false);
		request = builder.build();
		
		assertNotNull(request);
		assertEquals("Callback not match when setted ",callback,request.getCallback());
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.post.PostRequest#getForm()}.
	 */
	@Test
	public void testGetForm() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.davide.parise.pesapal.post.PostRequest#getBaseUrl()}.
	 */
	@Test
	public void testGetBaseUrl() {
		request = create();
		assertEquals(ApiUrlConstants.POST.url_live,request.getBaseUrl());
	}

}
