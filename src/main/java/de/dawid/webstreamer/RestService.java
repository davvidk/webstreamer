package de.dawid.webstreamer;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//@ApplicationPath( "/rest" )
public class RestService extends Application
{
	public RestService( ) {}
 
	@Override
	public Set<Class<?>> getClasses( )
	{
		final Set<Class<?>> returnValue = new HashSet<Class<?>>( );
		returnValue.add( StreamingResource.class );
		return returnValue;
	}
}