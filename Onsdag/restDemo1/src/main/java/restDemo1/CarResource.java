
package restDemo1;

import DTO.CarDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


@Path("car")
public class CarResource {

    @Context
    private UriInfo context;
    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private List<CarDTO> cars = new ArrayList();
    
    
    /**
     * Creates a new instance of CarResource
     */
    public CarResource() {
        if(cars.isEmpty()){
            cars.add(new CarDTO("volvo",12000,1995));
            cars.add(new CarDTO("peugeot",18000,2000));
            cars.add(new CarDTO("audi",120000,2010));
        }
    }

    /**
     * Retrieves representation of an instance of restDemo1.CarResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "[]";
    }
        @Path("driver")
        @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson2() {
        //TODO return proper representation object
        String a = "name";
        return "{\"name\":\"Kurt Wonnegut\"}";
    }

          @Path("carobject")
        @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson3() {
        CarDTO cardto = new CarDTO("volvo",12000,1995);
        String jsonString = GSON.toJson(cardto);
    return jsonString;
        
       
    }
              @Path("allcars")
        @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson4() {
        
        String jsonString = GSON.toJson(cars);
    return jsonString;
        
       
    }
    /**
     * PUT method for updating or creating an instance of CarResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
