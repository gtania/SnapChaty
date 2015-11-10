/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.toulou;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Τάνια
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        
        resources.add(gr.teicm.toulou.LocationResource.class);
        resources.add(gr.teicm.toulou.OnlinenowResource.class);
        resources.add(gr.teicm.toulou.SigninResource.class);
        resources.add(gr.teicm.toulou.SignupResource.class);
       
    }
    
}