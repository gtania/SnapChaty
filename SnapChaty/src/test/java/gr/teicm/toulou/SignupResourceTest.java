/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.toulou;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
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
public class SignupResourceTest {
   

    /**
     * Test of postUser method, of class SignupResource.
     */
    @Test
    public void testPostUser() {
        System.out.println("postUser");
        String user = "{onoma:\"Tania\",epitheto:\"Giossi\",username:\"TaniaG\",pass:\"mypass\",email:\"tania.giossi@hotmail.com\"}";
        SignupResource instance = new SignupResource();
        String expResult = "User singed up";
        String result = instance.postUser(user);
        assertEquals(expResult, result);
        

    }
    @Test
    public void testPostUserWithUnparsableInput() {
        System.out.println("postUser");
        String user = "Unparsable Input";
        SignupResource instance = new SignupResource();
        String expResult = "Cannot parse input";
        String result = instance.postUser(user);
        assertEquals(expResult, result);
        

    }
    
}
