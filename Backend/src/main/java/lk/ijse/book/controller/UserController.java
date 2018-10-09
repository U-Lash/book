package lk.ijse.book.controller;

import lk.ijse.book.dto.UserDTO;
import lk.ijse.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
}
