package com.bookstore.utility;

import com.bookstore.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * Created by Dominik on 07.05.2017.
 */
@Component
public class MailConstruct {

    @Autowired
    private Environment env;

    public SimpleMailMessage constructNewUserEmail(User user, String password){
        String message = "\nPlease use the following credentails to log in and edit your personal information including your own password."
                +"\nUsername: " + user.getUsername() + "\nPassword: "+ password;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("BookStore - New User");
        email.setText(message);
        email.setFrom(env.getProperty("support.email"));

        return email;

    }
}
