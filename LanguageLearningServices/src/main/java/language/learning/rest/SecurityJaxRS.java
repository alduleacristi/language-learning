package language.learning.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import language.learning.convertor.NounConverter;
import language.learning.dto.NounDTO;
import language.learning.dto.UserDTO;
import language.learning.model.Noun;

/**
 * Created by Cristi on 1/3/2017.
 */

@Path("/api/security")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SecurityJaxRS {
    @POST
    @Path("/login")
    public String getAllNouns(UserDTO user) {
        System.out.println("User [" + user.getEmail() + "] is trying to authenticate");

        return "token";
    }
}
