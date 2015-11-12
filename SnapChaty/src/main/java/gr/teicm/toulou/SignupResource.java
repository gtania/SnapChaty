/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.toulou;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import com.mongodb.util.JSONParseException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import org.bson.Document;



/**
 * REST Web Service
 *
 * @author Τάνια
 */
@Path("signup")
public class SignupResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SignupResource
     */
    public SignupResource() {
    }
/**
 * Endpoint opou dexetai ton kainourio xristi kai ton bazei sti basi
 * @param user {onoma:\"Tania\",epitheto:\"Giossi\",username:\"TaniaG\",pass:\"mypass\",email:\"tania.giossi@hotmail.com\"}
 * @return 
 */
    @POST
    @Consumes("text/plain")
    public String postUser(String user) {
        System.out.println(user);
        DBObject dbObjectUser;
        try{
                dbObjectUser = (DBObject)JSON.parse(user);

               try {  
                      MongoClient mongoClient = new MongoClient("localhost" , 27017);
                      System.out.println("Connected");

                      DB db = mongoClient.getDB("snapchatydb");
                      DBCollection coll = (DBCollection) db.getCollection("user");

                      coll.insert(dbObjectUser);
                      return "User singed up";

              } catch (Exception e) {

                      return "Database error";  
              }
               
        }catch(JSONParseException e){
             return "Cannot parse input";
        }
    }
}
