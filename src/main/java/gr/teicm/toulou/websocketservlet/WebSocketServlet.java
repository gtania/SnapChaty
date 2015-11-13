/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.toulou.websocketservlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author AntoniosValais
 */
@ServerEndpoint("/createSesion")
public class WebSocketServlet
{
	private static Set< Session > connectedClients = new HashSet< Session >();

	@OnOpen
	public void onOpen( Session session )
	{
		System.out.println( session.getId() + " has opened a connection!" );
		
		connectedClients.add( session );
		session.getAsyncRemote().sendText( "Server says: Connection Established" );
		
		
	}

	@OnMessage
	public void onMessage( String message, Session session )
	{
		System.out.println( "Message from " + session.getId() + ": " + message );

			for(Session client : connectedClients)
			{
				try
				{
					client.getBasicRemote().sendText( message );
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}


	}

	@OnClose
	public Response onClose( Session session )
	{
		if(connectedClients.remove( session ))
		{
			System.out.println( session.getId() + ": has closed the connection!\n"
					+ connectedClients.size() + "Clients online" );
			
			return Response.ok().build();
		}
		else
		{
			return Response.status( Status.BAD_REQUEST ).build();
		}

	}
}
