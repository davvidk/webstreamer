package de.dawid.webstreamer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StreamerServlet
 */
@WebServlet("/stream")
public class StreamerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StreamerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String fileName = (String) request.getParameter("file");
		    if (fileName == null || fileName.equals(""))
		    fileName="/Users/dkostrzycki/Music/iTunes/iTunes Media/Podcasts/c't uplink/c't uplink 10.5_ Streaming statt TV, Spiele für Linux, Haftung für Weblinks.mp3";
		    //  throw new ServletException(
		    //      "Invalid or non-existent file parameter in SendMp3 servlet.");

		    	  
		    
		      if (fileName.indexOf(".mp3") == -1)
		      fileName = fileName + ".mp3";

//		    String mp3Dir = getServletContext().getInitParameter("mp3-dir");
//		    if (mp3Dir == null || mp3Dir.equals(""))
//		      throw new ServletException(
//		          "Invalid or non-existent mp3Dir context-param.");

		    ServletOutputStream stream = null;
		    BufferedInputStream buf = null;
		    try {

		      stream = response.getOutputStream();
		      File mp3 = new File(fileName);

		      //set response headers
		      response.setContentType("audio/mpeg");

		      response.addHeader("Content-Disposition", "attachment; filename="
		          + fileName);

		      response.setContentLength((int) mp3.length());
	         
		    
		      FileInputStream input = new FileInputStream(mp3);
		      buf = new BufferedInputStream(input);
		      int readBytes = 0;
		      //read from the file; write to the ServletOutputStream
		      while ((readBytes = buf.read()) != -1)
		        stream.write(readBytes);
		    } catch (IOException ioe) {
		      throw new ServletException(ioe.getMessage());
		    } finally {
		      if (stream != null)
		        stream.close();
		      if (buf != null)
		        buf.close();
		    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
