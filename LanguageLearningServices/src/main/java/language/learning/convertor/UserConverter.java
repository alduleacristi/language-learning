package language.learning.convertor;

import language.learning.dto.NounDTO;
import language.learning.dto.UserDTO;
import language.learning.model.Article;
import language.learning.model.Lesson;
import language.learning.model.Level;
import language.learning.model.Noun;
import language.learning.model.User;

/**
 * Created by Cristi on 1/3/2017.
 */

public class UserConverter {
    public static User convertToModel(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());

        return user;
    }

    public static UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}
