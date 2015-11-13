package gr.teicm.toulou.websocketservlet.test;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/*
*
* @Author AntoniosValais
*
*/

public class WebSocketServletTest
{
	private WebSocketClientMock webSocketClientMock;
	
	@Before
	public void beforeTest()
	{
		
	}
	
	@Ignore
	@Test
	public void connectionEstablishTest()
	{
		webSocketClientMock = new WebSocketClientMock();
		
		String sessionId = webSocketClientMock.createConnection();
		
		Boolean sessionClosed = webSocketClientMock.closeConnection();
		
		assertNotNull( sessionId );
		assertTrue( sessionClosed );
	}
	
	@Ignore
	@Test
	public void servletReceiveMessageTest()
	{
		webSocketClientMock = new WebSocketClientMock();
		
		String sessionId = webSocketClientMock.createConnection();
		
		Boolean sendMessageDone = webSocketClientMock.sendMessage( "dada!" );
		
		Boolean sessionClosed = webSocketClientMock.closeConnection();
		
		assertNotNull( sessionId );
		assertTrue( sessionClosed );
		assertTrue( sendMessageDone );	
	}
	
	
	
}
