package language.learning.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import language.learning.convertor.NounConverter;
import language.learning.convertor.UserConverter;
import language.learning.dao.UserDAO;
import language.learning.dto.NounDTO;
import language.learning.dto.Token;
import language.learning.dto.UserDTO;
import language.learning.exception.EntityNotFoundException;
import language.learning.model.Noun;
import language.learning.model.User;
import language.learning.security.Session;

/**
 * Created by Cristi on 1/3/2017.
 */

@Path("/security")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SecurityJaxRS {
    @Inject
    private UserDAO userDAO;
    @Inject
    private Session session;

    @POST
    @Path("/login")
    public String getAllNouns(@Context HttpServletRequest req, UserDTO userDTO) {
        try {
            System.out.println("User [" + userDTO.getEmail() + "] is trying to authenticate from ip [" + req.getRemoteAddr() + "]");

            User user = userDAO.getUserByEmail(userDTO.getEmail());
            if (!user.getPassword().equals(userDTO.getPassword())) {
                throw new NotFoundException("Invalid username or password");
            }

            UUID hash = UUID.randomUUID();
            Token token = new Token();
            token.setCreationTime(new Date());
            token.setUserDTO(UserConverter.convertToDTO(user));
            token.setIp(req.getRemoteAddr());

            session.addUser(hash.toString(), token);

            return hash.toString();
        } catch (EntityNotFoundException enf) {
            throw new NotFoundException("Invalid username or password");
        }
    }
}
