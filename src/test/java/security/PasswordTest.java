package security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordTest {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void testEncoder() {
        String pw = "1111";

        String enPw = passwordEncoder.encode(pw);

        System.out.println("enPw : " + enPw);

        boolean matchResult = passwordEncoder.matches(pw, enPw);

        System.out.println("matchResult" + matchResult);
    }
}
