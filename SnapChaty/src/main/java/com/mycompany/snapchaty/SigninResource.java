/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.snapchaty;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *Endpoint gia elenxo login xristi
 * @author Τάνια
 */
@Path("signin")
public class SigninResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SigninResource
     */
    public SigninResource() {
    }

    /*
    @param user Dexetai user se String se morfi
    {username:"taniaG",password:"mypass"}
    */
    @POST
    @Consumes("text/plain")
    public String postUser(String user) {
        System.out.println("signin");
        return "";
    }
}
