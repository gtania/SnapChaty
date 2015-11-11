/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.toulou;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.util.JSON;
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
        DBObject dbObjectUser = (DBObject)JSON.parse(user);

        MongoClient mongoClient = new MongoClient("localhost" , 27017);

        DB db = mongoClient.getDB("snapchatydb");
        DBCollection coll = db.getCollection("user");
        
        DBObject userObject = coll.findOne((DBObject) and(eq("username",dbObjectUser.get("username")),
                                                   eq("password",dbObjectUser.get("password"))));
        
        if(userObject != null)
        {
            mongoClient = new MongoClient("localhost" , 27017);

            db = mongoClient.getDB("snapchatydb");
            coll = db.getCollection("signInHistory");
            coll.insert(userObject);
            
           return "User exists"; 
        }else{
            return "User Does Not Exist";
        }
    }
}
