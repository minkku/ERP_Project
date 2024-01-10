package org.gagu.service.member;

import lombok.extern.log4j.Log4j2;
import org.gagu.entity.member.Member;
import org.gagu.repository.member.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemberDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public MemberDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("--------------- SERVICE ---------------------");
        Member member = memberRepository.findByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User does not exist" + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(member.getUserId())
                .password(member.getPassword())
                .roles("USER")
                .build();
    }
}
