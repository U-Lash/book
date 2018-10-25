package lk.ijse.book.controller;

import lk.ijse.book.dto.NewUserDTO;
import lk.ijse.book.dto.UserDTO;
import lk.ijse.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO authenticateLogin(@RequestBody UserDTO userDTO) {
        return userService.authenticateLogin(userDTO);
    }

    @PostMapping(value = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO signUp(@RequestBody NewUserDTO newUserDTO) {
        return userService.signUp(newUserDTO);
    }

    @GetMapping(value = "/file", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam(value = "path", required = false) String path) {
        return userService.downloadFile(path);
    }
}
