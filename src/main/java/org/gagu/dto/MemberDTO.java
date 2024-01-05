package org.gagu.dto;

import org.gagu.domain.Member;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

//public class MemberDTO {
//    private Member(Long id, String userId, String pw, String userName, String depart, String position, LocalDateTime regdate) {
//        this.member_id = id;
//        this.member_userid = userId;
//        this.member_password = pw;
//        this.member_name = userName;
//        this.member_department = depart;
//        this.member_position = position;
//        this.member_regdate = regdate;
//    }
//
//    protected Member() { }
//    public static Member createMember(String userId, String pw, PasswordEncoder passwordEncoder) {
//        return new Member(null, userId, passwordEncoder.encode(pw), "USER");
//    }
//}
