/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.toulou;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

/**
 * REST Web Service
 * Endpoint gia tin lipsi location
 * @author Τάνια
 */
@Path("location")
public class LocationResource {

    @Context
    private UriInfo context;
    @Context
    Request request;

    /**
     * Creates a new instance of LocationResource
     */
    public LocationResource() {
    }
   
    /**
     * @param location String se morfi Json {latitude:"32",longtitude:"32"}
     */
    @POST
    @Consumes("text/plain")
    public String postLocation(String location) {
        System.out.println("got in location " + location);
        
        DBObject dbObjectLocation = (DBObject)JSON.parse(location);

        MongoClient mongoClient = new MongoClient("localhost" , 27017);

        DB db = mongoClient.getDB("snapchatydb");
        DBCollection coll = db.getCollection("signInHistory");
        
        DBObject push =new BasicDBObject().append("latitude",dbObjectLocation.get("latitude"))
                                          .append("longtitude",dbObjectLocation.get("longtitude"));
    try{
        coll.update((DBObject) eq("username",dbObjectLocation.get("username")),push);
        
        return "Got Location";
      }catch(MongoException e){
        System.out.println(e);
        return "Database error";

     }
    }
    
}
