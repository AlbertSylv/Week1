/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.AnimalNoDB;

/**
 * REST Web Service
 *
 * @author baske
 */
@Path("animals")
public class AnimalDemo {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalDemo
     */
    public AnimalDemo() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalDemo
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        return "Vuf... (Message from a dog)";
    }

    @Path("animal_list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson2() {
        
        return "[Dog, Cat, Mouse, Bird]";
    }
    
    @Path("animal")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson3() {
        AnimalNoDB ANDB = new AnimalNoDB("dog","muh");
        
        return new Gson().toJson(ANDB);
    }

    /**
     * PUT method for updating or creating an instance of AnimalDemo
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
