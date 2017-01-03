package language.learning.dto;

import java.util.Date;

/**
 * Created by Cristi on 1/3/2017.
 */

public class Token {
    private UserDTO userDTO;
    private String ip;
    private Date creationTime;

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getIp() {

        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public UserDTO getUserDTO() {

        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
