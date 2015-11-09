/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.snapchaty;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Τάνια
 */
@ServerEndpoint("/pack1/ChatServ")
public class ChatServ {
     private static Set<Session> clients = new HashSet<Session>();

    @OnOpen
    public void onOpen(Session session)
    {
        System.out.println(session.getId() + " has opened a connection!");
        try
        {
            clients.add( session );
            session.getBasicRemote().sendText("Connection Established");
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * When a user sends a message to the server, this method will intercept the message
     * and allow us to react to it. For now the message is read as a String.
     */
    @OnMessage
    public void onMessage(String message, Session session)
    {
        System.out.println("Message from " + session.getId() + ": " + message);
        try
        {
            for(Session client : clients)
                client.getBasicRemote().sendText(message);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * The user closes the connection.
     * <p>
     * Note: you can't send messages to the client from this method
     */
    @OnClose
    public void onClose(Session session)
    {
        System.out.println("Session " + session.getId() + " has ended");
    }
}
