package lk.ijse.book.service.impl;

import lk.ijse.book.dto.NewUserDTO;
import lk.ijse.book.dto.UserDTO;
import lk.ijse.book.entity.User;
import lk.ijse.book.repository.UserRepository;
import lk.ijse.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @Override
    public UserDTO signUp(NewUserDTO newUserDTO) {
        User user = new User();
        user.setAccountType("User");
        user.setAddress("a");
        user.setDateOfBirth(newUserDTO.getBirthday());
        user.setEmail(newUserDTO.getEmail());
        user.setFullName(newUserDTO.getFirstName() + " " + newUserDTO.getLastName());
        user.setNameWithInitials(newUserDTO.getFirstName() + " " + newUserDTO.getLastName());
        user.setTitle(newUserDTO.getTitle());
        user.setUserPassword(newUserDTO.getPassword());
        User save = userRepository.save(user);
        if (user != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setAuthenticate(true);
            userDTO.setUserID(user.getUserID() + "");
            return userDTO;
        } else {
            UserDTO userDTO = new UserDTO();
            userDTO.setAuthenticate(true);
            userDTO.setUserID(user.getUserID() + "");
            return userDTO;
        }
    }

    @Override
    public ResponseEntity<InputStreamResource> downloadFile(String path) {
        File file = new File("D:/Document/GitHub/book/Backend/src/main/resources/bookImages/" + "" + path + "");
        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName()).contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(file.length()).body(resource);
    }

    @Override
    public int uploadFile(MultipartFile[] files, String pathUrl) {
        int reply = 0;
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                reply = 1;
            }
            try {
                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
//                Path path = Paths.get("D:/Document/GitHub/book/Backend/src/main/resources/bookImages/" + pathUrl + "/" + file.getOriginalFilename());
                Path path = Paths.get("D:/Document/GitHub/book/Backend/src/main/resources/bookImages/" + file.getOriginalFilename());
                Files.write(path, bytes);

                reply = 2;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return reply;
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
