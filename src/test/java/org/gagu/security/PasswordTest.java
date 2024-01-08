package org.gagu.security;

import org.gagu.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest(classes = SecurityConfig.class)
public class PasswordTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testEncoder() {
        String pw = "1111";

        // Encoded password into bcrypt
        String enPw = passwordEncoder.encode(pw);

        System.out.println("enPw : " + enPw);

        // compare between bcrypt password and password
        boolean matchResult = passwordEncoder.matches(pw, enPw);

        System.out.println("matchResult = " + matchResult);
    }
}
