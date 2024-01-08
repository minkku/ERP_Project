package org.gagu.security;

import org.gagu.entity.Member;
import org.gagu.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDateTime;

@SpringJUnitConfig
@SpringBootTest
public class MemberTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertDummies() {
        Member member = Member.builder()
                .memberName("관리자")
                .userId("admin")
                .password("admin1234")
                .department("물류")
                .position("과장")
                .regdate(LocalDateTime.now())
                .build();
        memberRepository.save(member);
    }
}
