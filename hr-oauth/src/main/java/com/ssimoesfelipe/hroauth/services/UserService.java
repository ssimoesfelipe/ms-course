package com.ssimoesfelipe.hroauth.services;

import com.ssimoesfelipe.hroauth.entities.User;
import com.ssimoesfelipe.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            logger.error("Email Not Found: " + email);
            throw new IllegalArgumentException("Erro");
        }
        logger.info("Email Found: " + email);
        return user;
    }
}
