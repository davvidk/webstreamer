package de.dawid.webstreamer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

@Path("/streamer")
public class StreamingResource {
	private static boolean STOPPED = false;
	
	// serve media from file system
	String MEDIA_FILE = "/Users/dkostrzycki/Music/iTunes/iTunes Media/Podcasts/c't uplink/c't uplink 10.5_ Streaming statt TV, Spiele für Linux, Haftung für Weblinks.mp3";
	final File audio = new File(MEDIA_FILE);
	
	@GET
	@Path("/play")
	@Produces("audio/mpeg")
	public Response play() {
		StreamingOutput output = new StreamingOutput() {

			@Override
			public void write(OutputStream output) throws IOException,
					WebApplicationException {
				FileInputStream input = new FileInputStream(audio);
				BufferedInputStream buf = new BufferedInputStream(input);
				int readBytes = 0;
				try {
					// read from the file; write to the ServletOutputStream
					while ((readBytes = buf.read()) != -1 && !StreamingResource.STOPPED) {
						output.write(readBytes);
					}
				} finally {
					buf.close();
					output.close();
				}
			}
		};
		return Response.ok(output)
				.header(HttpHeaders.CONTENT_LENGTH, audio.length()).build();
	}
	
	@GET
	@Path("/stop")
	@Produces("text/html")
	public String stop(){
		StreamingResource.STOPPED = true;
		return "ok";
	}
}