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
import org.bson.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Τάνια
 */
public class SigninResourceTest {
    
    @Before
    public void setUp() {
        String user = "{onoma:\"Tania\",epitheto:\"Giossi\",username:\"TaniaG\",pass:\"mypass\",email:\"tania.giossi@hotmail.com\"}";
        SignupResource instance = new SignupResource();
        String result = instance.postUser(user);
        System.out.println("Test User inserted");
    }
    
    @After
    public void tearDown() {
        MongoClient mongoClient = new MongoClient("localhost" , 27017);
                      System.out.println("Connected");

                      DB db = mongoClient.getDB("snapchatydb");
                      DBCollection coll = (DBCollection) db.getCollection("user");

                      coll.findAndRemove(new BasicDBObject("username","TaniaG"));
                      DB hidtorydb = mongoClient.getDB("signInHistory");
                      DBCollection historycoll = (DBCollection) hidtorydb.getCollection("user");

                      historycoll.findAndRemove(new BasicDBObject("username","TaniaG"));
    }

    /**
     * Test of postUser method, of class SigninResource.
     */
    @Test
    public void testPostUserThatExists() {
        System.out.println("postUser");
        String user = "{username:\"TaniaG\",pass:\"mypass\"}";
        SigninResource instance = new SigninResource();
        String expResult = "User exists";
        String result = instance.postUser(user);
        assertEquals(expResult, result);
        
    }
     @Test
    public void testPostUserThatDoesNotExists() {
        System.out.println("postUser");
        String user = "{username:\"NonExostedUser\",pass:\"Apass\"}";
        SigninResource instance = new SigninResource();
        String expResult = "User Does Not Exist";
        String result = instance.postUser(user);
        assertEquals(expResult, result);
        
    }
    
}
