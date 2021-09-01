package com.ssimoesfelipe.hroauth.resources;

import com.ssimoesfelipe.hroauth.entities.User;
import com.ssimoesfelipe.hroauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        try {
            return ResponseEntity.ok(userService.findByEmail(email));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
