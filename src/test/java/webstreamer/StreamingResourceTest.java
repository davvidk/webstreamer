package webstreamer;

import static org.junit.Assert.*;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.junit.Test;

public class StreamingResourceTest extends RestTest{

	@Test
	public void testGetIt() {
		Response responseMsg = target.path("stream").request().get();
		String contentLength = responseMsg.getHeaderString(HttpHeaders.CONTENT_LENGTH);
		System.out.println(contentLength);
		assertNotNull(contentLength);
	}
}
