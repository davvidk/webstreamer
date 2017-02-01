package webstreamer;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;

public class RestTest {

	private HttpServer server;
	protected WebTarget target;

	@Before
	public void setUp() throws IOException {
	
		server = ServerController.startServer();
		
		Client newClient = ClientBuilder.newClient();
		target = newClient.target(ServerController.BASE_URI);
	}
	
	@After
	public void tearDown() {
		server.shutdown();
	}

}
