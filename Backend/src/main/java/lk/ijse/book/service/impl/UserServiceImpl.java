package lk.ijse.book.service.impl;

import lk.ijse.book.dto.UserDTO;
import lk.ijse.book.repository.UserRepository;
import lk.ijse.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO authenticateLogin(UserDTO userDTO) {
        UserDTO user = new UserDTO();
        if (userDTO.getAccountType().equals("Admin")) {
            List<Object[]> adminLogin = userRepository.getLogin(userDTO.getUserID(), userDTO.getUserPassword(), userDTO.getAccountType());
            user = setUser(adminLogin);
        } else if (userDTO.getAccountType().equals("User")) {
            List<Object[]> userLogin = userRepository.getLogin(userDTO.getUserID(), userDTO.getUserPassword(), userDTO.getAccountType());
            user = setUser(userLogin);
        }

        return user;
    }

    private UserDTO setUser(List<Object[]> logins) {
        UserDTO user = new UserDTO();
        if (logins != null) {
            for (Object[] login : logins) {
                if (!login[0].toString().equals("")) {
                    user.setAuthenticate(true);
                    user.setUserName(login[0].toString());
                    user.setAccountType(login[1].toString());
                } else {
                    user.setAuthenticate(false);
                }
            }
        } else {
            user.setAuthenticate(false);
        }
        return user;
    }
}
