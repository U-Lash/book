package lk.ijse.book.service;

import lk.ijse.book.dto.UserDTO;

public interface UserService {
    UserDTO authenticateLogin(UserDTO userDTO);
}
