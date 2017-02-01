package webstreamer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyResouceTest extends RestTest{

	
	@Test
	public void testGetIt() {
		String responseMsg = target.path("myresource").request()
				.get(String.class);
		assertEquals("Got it!", responseMsg);
	}
}
