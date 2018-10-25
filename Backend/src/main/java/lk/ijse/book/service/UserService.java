package lk.ijse.book.service;

import lk.ijse.book.dto.NewUserDTO;
import lk.ijse.book.dto.UserDTO;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    UserDTO authenticateLogin(UserDTO userDTO);

    UserDTO signUp(NewUserDTO newUserDTO);

    ResponseEntity<InputStreamResource> downloadFile(String path);

    int uploadFile(MultipartFile[] files, String pathUrl);
}
