package com.demo_test5.test5.controllers;

import com.demo_test5.test5.entitys.UserEntity;
import com.demo_test5.test5.exceptions.UserAlreadyExistException;
import com.demo_test5.test5.exceptions.UserNotFoundException;
import com.demo_test5.test5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    //@TODO remove autowired
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Поймали ошибку при поиске юзера");
        }
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь сохранен!");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Поймали ошибку при отправке POST запроса");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Поймали ошибку при поиске юзера");
        }
    }

}
//@TODO error handling on API level