/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.snapchaty;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *Endpoint gia tin lipsi online xristwn
 * @author Τάνια
 */
@Path("onlinenow")
public class OnlinenowResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OnlinenowResource
     */
    public OnlinenowResource() {
    }

    /**
     * Retrieves representation of an instance of pack1.OnlinenowResource
     * @return Online xristes se String Json morfis {username:"taniaG"}
     */
    @GET
    @Produces("text/plain")
    public String getText() {
        //TODO return proper representation object
        System.out.println("in get fucker");
        return "";
    }

    
}
